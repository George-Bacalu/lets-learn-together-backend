package com.project.llt.service;

import com.project.llt.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User saveUser(User user);

    User updateUserById(User user, Long id);

    void deleteUserById(Long id);
}
