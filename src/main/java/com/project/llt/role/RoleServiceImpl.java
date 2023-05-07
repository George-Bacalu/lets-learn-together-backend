package com.project.llt.role;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleDao.findAll();
        return roles.stream().map(role -> RoleDto.builder()
              .id(role.getId())
              .authority(role.getAuthority())
              .build()).toList();
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = getRoleEntityById(id);
        return RoleDto.builder()
              .id(role.getId())
              .authority(role.getAuthority())
              .build();
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        Role role = Role.builder()
              .id(roleDto.getId())
              .authority(roleDto.getAuthority())
              .build();
        Role savedRole = roleDao.save(role);
        return RoleDto.builder()
              .id(savedRole.getId())
              .authority(savedRole.getAuthority())
              .build();
    }

    @Override
    public RoleDto updateRoleById(RoleDto roleDto, Long id) {
        Role roleToUpdate = getRoleEntityById(id);
        roleToUpdate.setAuthority(roleDto.getAuthority());
        Role updatedRole = roleDao.update(roleToUpdate);
        return RoleDto.builder()
              .id(updatedRole.getId())
              .authority(updatedRole.getAuthority())
              .build();
    }

    @Override
    public void deleteRoleById(Long id) {
        Role roleToDelete = getRoleEntityById(id);
        roleDao.delete(roleToDelete);
    }

    @Override
    public Role getRoleEntityById(Long id) {
        return roleDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Role with id %s was not found", id)));
    }
}
