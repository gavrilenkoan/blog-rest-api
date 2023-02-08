package com.gavrilenkoan.blogrestapi.service;

import com.gavrilenkoan.blogrestapi.dao.UserDao;
import com.gavrilenkoan.blogrestapi.dto.UserDto;
import com.gavrilenkoan.blogrestapi.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUsers() {
        return userDao.selectAllUsers()
                .stream().peek(user -> {
                    user.setFollowers(userDao.selectAllFollowersById(user.getId()));
                    user.setFollowing(userDao.selectAllFollowingById(user.getId()));
                }).
                collect(Collectors.toList());
    }

    public User getUser(Integer id) {
        return userDao.selectUserById(id)
                .orElseThrow(() -> new IllegalStateException("user with id " + id + "not found"));
    }

    public User updateUser(Integer id, UserDto userDto) {
        if (userDto.getUsername() != null && !Objects.equals(userDto.getUsername(), "")
                && userDao.selectUserByUsername(userDto.getUsername()).isEmpty()) {
            userDao.updateUserUsername(id, userDto.getUsername());
        }
        if (userDto.getFirstname() != null && !Objects.equals(userDto.getFirstname(), "")) {
            userDao.updateUserFirstname(id, userDto.getFirstname());
        }
        if (userDto.getLastname() != null && !Objects.equals(userDto.getLastname(), "")) {
            userDao.updateUserLastname(id, userDto.getLastname());
        }
        if (userDto.getPassword() != null && !Objects.equals(userDto.getPassword(), "")) {
            userDao.updateUserPassword(id, bCryptPasswordEncoder.encode(userDto.getPassword()));
        }
        if (userDto.getEmail() != null && !Objects.equals(userDto.getEmail(), "")
                && userDao.selectUserByEmail(userDto.getEmail()).isEmpty()) {
            userDao.updateUserEmail(id, userDto.getEmail());
        }
        return userDao.selectUserById(id)
                .orElseThrow(() -> new IllegalStateException("user with id " + id + "not found"));
    }

    public String deleteUser(Integer id) {
        userDao.deleteUser(id);
        return "deleted successfully";
    }

    public List<User> getFollowersById(Integer id) {
        return userDao.selectAllFollowersById(id);
    }

    public List<User> getFollowingById(Integer id) {
        return userDao.selectAllFollowingById(id);
    }

    public String addFollowing(Integer userId, Integer followerId) {
        if (Objects.equals(userId, followerId)) {
            throw new IllegalStateException("you can not follow yourself");
        }
        if (userDao.isUserFollowerRelationExists(userId, followerId)) {
            throw new IllegalStateException("such relation already exists");
        }
        userDao.insertFollowing(userId, followerId);
        return "inserted successfully";
    }
}
