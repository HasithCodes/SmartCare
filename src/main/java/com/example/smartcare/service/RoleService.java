package com.example.smartcare.service;

import com.example.smartcare.entity.Role;
import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}