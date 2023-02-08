package com.gavrilenkoan.blogrestapi.controller;

import com.gavrilenkoan.blogrestapi.config.JwtService;
import com.gavrilenkoan.blogrestapi.dto.UserDto;
import com.gavrilenkoan.blogrestapi.entity.User;
import com.gavrilenkoan.blogrestapi.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping(path  = "api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping
    public ResponseEntity<User> getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(userService.getUser(jwtService.extractId(token)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(HttpServletRequest request, @RequestBody UserDto userDto) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(userService.updateUser(jwtService.extractId(token), userDto));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(userService.deleteUser(jwtService.extractId(token)));
    }

    @GetMapping("/followers/{id}")
    public ResponseEntity<List<User>> getFollowers(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getFollowersById(id));
    }

    @GetMapping("/following/{id}")
    public ResponseEntity<List<User>> getFollowed(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getFollowingById(id));
    }

    @PostMapping("/{followingId}")
    public ResponseEntity<String> addFollowing(HttpServletRequest request, @PathVariable Integer followingId) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(userService.addFollowing(followingId, jwtService.extractId(token)));
    }
}
