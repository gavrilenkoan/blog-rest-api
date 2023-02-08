package com.gavrilenkoan.blogrestapi.service;

import com.gavrilenkoan.blogrestapi.das.UserDas;
import com.gavrilenkoan.blogrestapi.dto.UserDto;
import com.gavrilenkoan.blogrestapi.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDas userDas;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUsers() {
        return userDas.selectAllUsers();
    }

    public User getUser(Integer id) {
        return userDas.selectUserById(id)
                .orElseThrow(() -> new IllegalStateException("user with id " + id + "not found"));
    }

    public User updateUser(Integer id, UserDto userDto) {
        if (userDto.getUsername() != null && !Objects.equals(userDto.getUsername(), "") && userDas.selectUserByUsername(userDto.getUsername()).isEmpty()) {
            userDas.updateUserUsername(id, userDto.getUsername());
        }
        if (userDto.getFirstname() != null && !Objects.equals(userDto.getFirstname(), "")) {
            userDas.updateUserFirstname(id, userDto.getFirstname());
        }
        if (userDto.getLastname() != null && !Objects.equals(userDto.getLastname(), "")) {
            userDas.updateUserLastname(id, userDto.getLastname());
        }
        if (userDto.getPassword() != null && !Objects.equals(userDto.getPassword(), "")) {
            userDas.updateUserPassword(id, bCryptPasswordEncoder.encode(userDto.getPassword()));
        }
        if (userDto.getEmail() != null && !Objects.equals(userDto.getEmail(), "") && userDas.selectUserByEmail(userDto.getEmail()).isEmpty()) {
            userDas.updateUserEmail(id, userDto.getEmail());
        }
        return userDas.selectUserById(id)
                .orElseThrow(() -> new IllegalStateException("user with id " + id + "not found"));
    }

    public String deleteUser(Integer id) {
        return userDas.deleteUser(id) == 1 ? "deleted successfully" : "smth went wrong";
    }

    public List<User> getFollowersById(Integer id) {
        return userDas.selectAllFollowersById(id);
    }

    public List<User> getFollowedById(Integer id) {
        return userDas.selectAllFollowedById(id);
    }

    public String addFollowed(Integer userId, Integer followerId) {
        return userDas.insertFollowed(userId, followerId) == 1 ? "inserted successfully" : "something went wrong";
    }
}
