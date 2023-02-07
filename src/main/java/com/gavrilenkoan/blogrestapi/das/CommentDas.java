package com.gavrilenkoan.blogrestapi.das;

import com.gavrilenkoan.blogrestapi.dao.CommentDao;
import com.gavrilenkoan.blogrestapi.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentDas implements CommentDao {

    @Override
    public List<Comment> selectCommentsByPostId(Integer postId) {
        return null;
    }

    @Override
    public Integer insertCommentByPostId(Integer userId, Integer postId, Comment comment) {
        return null;
    }

    @Override
    public Integer insertCommentByCommentId(Integer userId, Integer commentId, Comment comment) {
        return null;
    }

    @Override
    public Integer deleteComment(Integer id) {
        return null;
    }

    @Override
    public Optional<Comment> selectCommentById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Comment updateComment(Integer id) {
        return null;
    }
}
