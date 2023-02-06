package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> selectUsers();
    String insertUser(User user);
    Long deleteUser(Long id);
    Optional<User> selectUserById(Long id);
    Optional<User> selectUserByUsername(String username);
    Optional<User> selectUserByEmail(String email);
    User updateUser(Long id);
}
