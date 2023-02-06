package com.gavrilenkoan.blogrestapi.dao;

import com.gavrilenkoan.blogrestapi.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentDaoImpl implements CommentDao{

    @Override
    public List<Comment> selectCommentsByPostId(Long postId) {
        return null;
    }

    @Override
    public Comment insertComment(Long userId, Long postId, Comment comment) {
        return null;
    }

    @Override
    public Long deleteComment(Long id) {
        return null;
    }

    @Override
    public Optional<Comment> selectCommentById(Long id) {
        return Optional.empty();
    }

    @Override
    public Comment updateComment(Long id) {
        return null;
    }
}
