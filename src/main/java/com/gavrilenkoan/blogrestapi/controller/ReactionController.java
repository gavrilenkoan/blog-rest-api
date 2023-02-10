package com.gavrilenkoan.blogrestapi.controller;

import com.gavrilenkoan.blogrestapi.config.JwtService;
import com.gavrilenkoan.blogrestapi.dto.ReactionDto;
import com.gavrilenkoan.blogrestapi.entity.Reaction;
import com.gavrilenkoan.blogrestapi.service.ReactionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping(path  = "api/v1/reaction")
@AllArgsConstructor
public class ReactionController {

    private ReactionService reactionService;
    private JwtService jwtService;

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Reaction>> getReactionsByPostId(@PathVariable Integer postId) {
        return ResponseEntity.ok(reactionService.getReactionsByPostId(postId));
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<List<Reaction>> getReactionsByCommentId(@PathVariable Integer commentId) {
        return ResponseEntity.ok(reactionService.getReactionsByCommentId(commentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reaction> getReactionsById(@PathVariable Integer id) {
        return ResponseEntity.ok(reactionService.getReactionsById(id));
    }

    @PostMapping("/post")
    public ResponseEntity<String> createReactionByPostId(HttpServletRequest request,
                                                         @RequestParam Integer postId,
                                                         @RequestBody ReactionDto reactionDto) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(reactionService.createReactionByPostId(jwtService.extractId(token), postId, reactionDto));
    }

    @PostMapping("/comment")
    public ResponseEntity<String> createReactionByCommentId(HttpServletRequest request,
                                                            @RequestParam Integer commentId,
                                                            @RequestBody ReactionDto reactionDto) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(reactionService.createReactionByCommentId(jwtService.extractId(token), commentId, reactionDto));
    }

    @PutMapping
    public ResponseEntity<Reaction> updateReaction(HttpServletRequest request,
                                               @RequestParam Integer reactionId,
                                               @RequestBody ReactionDto reactionDto) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(reactionService.updateReaction(jwtService.extractId(token), reactionId, reactionDto));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReaction(HttpServletRequest request,
                                                 @RequestParam Integer reactionId) {
        String token = request.getHeader(AUTHORIZATION).substring("Bearer ".length());
        return ResponseEntity.ok(reactionService.deleteReaction(jwtService.extractId(token), reactionId));
    }
}
