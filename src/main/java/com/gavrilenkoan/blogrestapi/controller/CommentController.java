package com.gavrilenkoan.blogrestapi.controller;

import com.gavrilenkoan.blogrestapi.config.JwtService;
import com.gavrilenkoan.blogrestapi.dto.CommentDto;
import com.gavrilenkoan.blogrestapi.entity.Comment;
import com.gavrilenkoan.blogrestapi.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping(path  = "api/v1/comment")
@AllArgsConstructor
public class CommentController {

    private CommentService commentService;
    private JwtService jwtService;

    @GetMapping
    public ResponseEntity<List<Comment>> getCommentsByPostId(@RequestParam Integer postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

    @GetMapping("/reply")
    public ResponseEntity<List<Comment>> getRepliesByCommentId(@RequestParam Integer commentId) {
        return ResponseEntity.ok(commentService.getRepliesByCommentId(commentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @PostMapping
    public ResponseEntity<String> createComment(HttpServletRequest request,
                                                 @RequestParam Integer postId,
                                                 @RequestBody CommentDto commentDto) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(commentService.createComment(jwtService.extractId(token), postId, commentDto));
    }

    @PostMapping("/reply")
    public ResponseEntity<String> createReply(HttpServletRequest request,
                                               @RequestParam Integer commentId,
                                               @RequestBody CommentDto commentDto) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(commentService.createReply(jwtService.extractId(token), commentId, commentDto));
    }

    @PutMapping
    public ResponseEntity<Comment> updateComment(HttpServletRequest request,
                                                 @RequestParam Integer commentId,
                                                 @RequestBody CommentDto commentDto) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(commentService.updateComment(jwtService.extractId(token), commentId, commentDto));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteComment(HttpServletRequest request, @RequestParam Integer commentId) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(commentService.deleteComment(jwtService.extractId(token), commentId));
    }
}
