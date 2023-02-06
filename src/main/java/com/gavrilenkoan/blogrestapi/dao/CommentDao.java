package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentDao {
    List<Comment> selectCommentsByPostId(Long postId);
    Comment insertComment(Long userId, Long postId, Comment comment);
    Long deleteComment(Long id);
    Optional<Comment> selectCommentById(Long id);
    Comment updateComment(Long id);
}
