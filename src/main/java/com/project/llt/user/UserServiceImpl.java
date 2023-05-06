package com.project.llt.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("User with id %s was not found", id)));
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUserById(User user, Long id) {
        User userToUpdate = getUserById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setMobile(user.getMobile());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setBirthday(user.getBirthday());
        userToUpdate.setInstitution(user.getInstitution());
        userToUpdate.setRole(user.getRole());
        return userDao.update(userToUpdate);
    }

    @Override
    public void deleteUserById(Long id) {
        User userToDelete = getUserById(id);
        userDao.delete(userToDelete);
    }
}
