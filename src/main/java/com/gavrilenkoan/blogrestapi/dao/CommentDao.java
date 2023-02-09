package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.dto.CommentDto;
import com.gavrilenkoan.blogrestapi.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentDao {

    List<Comment> selectCommentsByPostId(Integer postId);

    List<Comment> selectRepliesByCommentId(Integer commentId);

    void insertCommentByPostId(Integer userId, Integer postId, CommentDto commentDto);

    void insertReplyByCommentId(Integer userId, Integer commentId, CommentDto commentDto);

    void deleteComment(Integer id);

    Optional<Comment> selectCommentById(Integer id);

    void updateComment(Integer id, String comment);
}
