package com.project.llt.user;

import com.project.llt.institution.InstitutionService;
import com.project.llt.role.RoleService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final InstitutionService institutionService;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userDao.findAll();
        return !users.isEmpty() ? users.stream().map(this::convertToDto).toList() : new ArrayList<>();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = getUserEntityById(id);
        return convertToDto(user);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        User savedUser = userDao.save(user);
        return convertToDto(savedUser);
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
        return convertToDto(updatedUser);
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

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
