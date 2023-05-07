package com.project.llt.user;

import com.project.llt.institution.InstitutionService;
import com.project.llt.role.RoleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final InstitutionService institutionService;
    private final RoleService roleService;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userDao.findAll();
        return users.stream().map(user -> UserDto.builder()
              .id(user.getId())
              .name(user.getName())
              .email(user.getEmail())
              .password(user.getPassword())
              .mobile(user.getMobile())
              .address(user.getAddress())
              .birthday(user.getBirthday())
              .institutionId(user.getInstitution().getId())
              .roleId(user.getRole().getId())
              .build()).toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = getUserEntityById(id);
        return UserDto.builder()
              .id(user.getId())
              .name(user.getName())
              .email(user.getEmail())
              .password(user.getPassword())
              .mobile(user.getMobile())
              .address(user.getAddress())
              .birthday(user.getBirthday())
              .institutionId(user.getInstitution().getId())
              .roleId(user.getRole().getId())
              .build();
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = User.builder()
              .id(userDto.getId())
              .name(userDto.getName())
              .email(userDto.getEmail())
              .password(userDto.getPassword())
              .mobile(userDto.getMobile())
              .address(userDto.getAddress())
              .birthday(userDto.getBirthday())
              .institution(institutionService.getInstitutionEntityById(userDto.getInstitutionId()))
              .role(roleService.getRoleEntityById(userDto.getRoleId()))
              .build();
        User savedUser = userDao.save(user);
        return UserDto.builder()
              .id(savedUser.getId())
              .name(savedUser.getName())
              .email(savedUser.getEmail())
              .password(savedUser.getPassword())
              .mobile(savedUser.getMobile())
              .address(savedUser.getAddress())
              .birthday(savedUser.getBirthday())
              .institutionId(savedUser.getInstitution().getId())
              .roleId(savedUser.getRole().getId())
              .build();
    }

    @Override
    public UserDto updateUserById(UserDto userDto, Long id) {
        User userToUpdate = getUserEntityById(id);
        userToUpdate.setName(userDto.getName());
        userToUpdate.setEmail(userDto.getEmail());
        userToUpdate.setPassword(userDto.getPassword());
        userToUpdate.setMobile(userDto.getMobile());
        userToUpdate.setAddress(userDto.getAddress());
        userToUpdate.setBirthday(userDto.getBirthday());
        userToUpdate.setInstitution(institutionService.getInstitutionEntityById(userDto.getInstitutionId()));
        userToUpdate.setRole(roleService.getRoleEntityById(userDto.getRoleId()));
        User updatedUser = userDao.update(userToUpdate);
        return UserDto.builder()
              .id(updatedUser.getId())
              .name(updatedUser.getName())
              .email(updatedUser.getEmail())
              .password(updatedUser.getPassword())
              .mobile(updatedUser.getMobile())
              .address(updatedUser.getAddress())
              .birthday(updatedUser.getBirthday())
              .institutionId(updatedUser.getInstitution().getId())
              .roleId(updatedUser.getRole().getId())
              .build();
    }

    @Override
    public void deleteUserById(Long id) {
        User userToDelete = getUserEntityById(id);
        userDao.delete(userToDelete);
    }

    @Override
    public User getUserEntityById(Long id) {
        return userDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("User with id %s was not found", id)));
    }
}
