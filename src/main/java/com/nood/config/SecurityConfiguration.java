package com.nood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 404
        http.exceptionHandling().accessDeniedPage("/unauth.html");

        http.formLogin()
            .loginProcessingUrl("/user/login")
            .defaultSuccessUrl("/test/index")
            .loginPage("/login.html");

        http.authorizeRequests()
                .antMatchers("/","/test/hello","/user/login", "/login.html").permitAll()    // 设置不需要拦截的页面
//                .antMatchers("/test/index").hasAuthority("admins")
//                .antMatchers("/test/index").hasAnyAuthority("admins, manager")  // 满足任何一个权限就可以访问
//                .antMatchers("/test/index").hasRole("sale")
//                .antMatchers("/test/index").hasRole("sale")
                .antMatchers("/test/index").hasAnyRole("admins, manager")
                .anyRequest().authenticated();                                                          // 其他请求必须认证后才可以被访问

        http.csrf().disable();
    }
}
