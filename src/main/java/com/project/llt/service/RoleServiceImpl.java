package com.project.llt.service;

import com.project.llt.dao.RoleDao;
import com.project.llt.model.Role;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Override
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Role with id %s was not found", id)));
    }

    @Override
    public Role saveRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role updateRoleById(Role role, Long id) {
        Role roleToUpdate = getRoleById(id);
        roleToUpdate.setAuthority(role.getAuthority());
        return roleDao.update(roleToUpdate);
    }

    @Override
    public void deleteRoleById(Long id) {
        Role roleToDelete = getRoleById(id);
        roleDao.delete(roleToDelete);
    }
}
