package com.project.llt.role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role saveRole(Role role);

    Role updateRoleById(Role role, Long id);

    void deleteRoleById(Long id);
}
