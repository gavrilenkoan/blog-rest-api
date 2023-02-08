package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.dto.UserDto;
import com.gavrilenkoan.blogrestapi.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> selectAllUsers();

    void insertUser(UserDto userDto);

    void deleteUser(Integer id);

    Optional<User> selectUserById(Integer id);

    Optional<User> selectUserByUsername(String username);

    Optional<User> selectUserByEmail(String email);

    void updateUserUsername(Integer id, String username);

    void updateUserFirstname(Integer id, String firstname);

    void updateUserLastname(Integer id, String lastname);

    void updateUserEmail(Integer id, String email);

    void updateUserPassword(Integer id, String password);

    List<User> selectAllFollowersById(Integer id);

    List<User> selectAllFollowingById(Integer id);

    void insertFollowing(Integer userId, Integer followerId);

    boolean isUserFollowerRelationExists(Integer userId, Integer followerId);
}

