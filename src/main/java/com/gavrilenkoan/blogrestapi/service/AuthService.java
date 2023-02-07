package com.gavrilenkoan.blogrestapi.service;

import com.gavrilenkoan.blogrestapi.config.JwtService;
import com.gavrilenkoan.blogrestapi.dao.UserDao;
import com.gavrilenkoan.blogrestapi.dto.AuthenticationDto;
import com.gavrilenkoan.blogrestapi.dto.UserDto;
import com.gavrilenkoan.blogrestapi.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;


    public String register(UserDto userDto) {

        if (userDao.selectUserByUsername(userDto.getUsername()).isPresent()) {
            throw new IllegalStateException("username already taken");
        }
        if (userDao.selectUserByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);

        userDao.insertUser(userDto);

        return jwtService.generateToken(userDao.selectUserByEmail(userDto.getEmail())
                .orElseThrow(IllegalStateException::new));
    }

    public String authenticate(AuthenticationDto request) {

        User user;
        if (userDao.selectUserByEmail(request.getUsernameOrEmail()).isEmpty()) {
            user = userDao.selectUserByUsername(request.getUsernameOrEmail())
                    .orElseThrow(() -> new IllegalStateException("wrong credentials"));
        } else {
            user = userDao.selectUserByEmail(request.getUsernameOrEmail())
                    .orElseThrow(() -> new IllegalStateException("wrong credentials"));
        }

        if (!bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalStateException("wrong credentials");
        }

        return jwtService.generateToken(user);
    }
}
