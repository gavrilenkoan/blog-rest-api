package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.dto.UserDto;
import com.gavrilenkoan.blogrestapi.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> selectAllUsers();

    void insertUser(UserDto userDto);

    Integer deleteUser(Integer id);

    Optional<User> selectUserById(Integer id);

    Optional<User> selectUserByUsername(String username);

    Optional<User> selectUserByEmail(String email);

    Integer updateUserUsername(Integer id, String username);

    Integer updateUserFirstname(Integer id, String firstname);

    Integer updateUserLastname(Integer id, String lastname);

    Integer updateUserEmail(Integer id, String email);

    Integer updateUserPassword(Integer id, String password);
}
