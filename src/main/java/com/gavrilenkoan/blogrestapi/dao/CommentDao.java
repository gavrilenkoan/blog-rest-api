package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface
CommentDao {

    List<Comment> selectCommentsByPostId(Integer postId);

    Integer insertCommentByPostId(Integer userId, Integer postId, Comment comment);

    Integer insertCommentByCommentId(Integer userId, Integer commentId, Comment comment);

    Integer deleteComment(Integer id);

    Optional<Comment> selectCommentById(Integer id);

    Comment updateComment(Integer id);
}
