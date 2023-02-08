package com.gavrilenkoan.blogrestapi.controller;

import com.gavrilenkoan.blogrestapi.config.JwtService;
import com.gavrilenkoan.blogrestapi.dto.PostDto;
import com.gavrilenkoan.blogrestapi.entity.Post;
import com.gavrilenkoan.blogrestapi.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping(path  = "api/v1/post")
@AllArgsConstructor
public class PostController {

    private PostService postService;
    private JwtService jwtService;

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAuthenticatedUsersPosts(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(postService.getUsersPosts(jwtService.extractId(token)));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Post>> getUsersPosts(@PathVariable Integer userId) {
        return ResponseEntity.ok(postService.getUsersPosts(userId));
    }

    @GetMapping("/post")
    public ResponseEntity<Post> getPost(@RequestParam Integer postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @PostMapping
    public ResponseEntity<String> createPost(HttpServletRequest request, @RequestBody PostDto postDto) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(postService.createPost(jwtService.extractId(token), postDto));
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(HttpServletRequest request, @RequestParam Integer postId, @RequestBody PostDto postDto) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(postService.updatePost(jwtService.extractId(token), postId, postDto));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(HttpServletRequest request, @RequestParam Integer postId) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(postService.deletePost(jwtService.extractId(token), postId));
    }
}
