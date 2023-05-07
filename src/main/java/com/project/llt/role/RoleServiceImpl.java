package com.project.llt.role;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;
    private final ModelMapper modelMapper;

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleDao.findAll();
        return !roles.isEmpty() ? roles.stream().map(this::convertToDto).toList() : new ArrayList<>();
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = getRoleEntityById(id);
        return convertToDto(role);
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        Role role = convertToEntity(roleDto);
        Role savedRole = roleDao.save(role);
        return convertToDto(savedRole);
    }

    @Override
    public RoleDto updateRoleById(RoleDto roleDto, Long id) {
        Role roleToUpdate = getRoleEntityById(id);
        roleToUpdate.setAuthority(roleDto.getAuthority());
        Role updatedRole = roleDao.update(roleToUpdate);
        return convertToDto(updatedRole);
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

    private RoleDto convertToDto(Role role) {
        return modelMapper.map(role, RoleDto.class);
    }

    private Role convertToEntity(RoleDto roleDto) {
        return modelMapper.map(roleDto, Role.class);
    }
}
