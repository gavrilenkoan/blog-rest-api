package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public List<User> selectUsers() {
        return null;
    }

    @Override
    public String insertUser(User user) {
        return null;
    }

    @Override
    public Long deleteUser(Long id) {
        return null;
    }

    @Override
    public Optional<User> selectUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> selectUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User updateUser(Long id) {
        return null;
    }
}
