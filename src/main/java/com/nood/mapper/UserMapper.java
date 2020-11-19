package com.nood.mapper;

import com.nood.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findByName(@Param("name") String name);

}
