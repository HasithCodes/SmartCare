package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Role;
import com.example.smartcare.repository.RoleRepository;
import com.example.smartcare.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) { return roleRepository.save(role); }

    @Override
    public List<Role> getAllRoles() { return roleRepository.findAll(); }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
    }

    @Override
    public Role updateRole(Long id, Role updatedRole) {
        Role existingRole = getRoleById(id);
        existingRole.setRoleName(updatedRole.getRoleName());
        return roleRepository.save(existingRole);
    }

    @Override
    public void deleteRole(Long id) { roleRepository.delete(getRoleById(id)); }
}