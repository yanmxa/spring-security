package com.nood.mapper;

import com.nood.model.Permission;

import java.util.List;

public interface PermissionMapper {
    List<Permission> findAll();
    List<Permission> findByAdminUserId(int userId);
}
