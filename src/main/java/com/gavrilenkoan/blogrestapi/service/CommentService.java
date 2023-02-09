package com.gavrilenkoan.blogrestapi.service;

import com.gavrilenkoan.blogrestapi.dao.CommentDao;
import com.gavrilenkoan.blogrestapi.dto.CommentDto;
import com.gavrilenkoan.blogrestapi.entity.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentDao commentDao;

    public List<Comment> getCommentsByPostId(Integer postId) {
        return commentDao.selectCommentsByPostId(postId);
    }

    public List<Comment> getRepliesByCommentId(Integer commentId) {
        return commentDao.selectRepliesByCommentId(commentId);
    }

    public Comment getCommentById(Integer id) {
        return commentDao.selectCommentById(id)
                .orElseThrow(() -> new IllegalStateException("comment with id " + id + " not found"));
    }

    public String createComment(Integer userId, Integer postId, CommentDto commentDto) {
        commentDao.insertCommentByPostId(userId, postId, commentDto);
        return "inserted successfully";
    }

    public String createReply(Integer userId, Integer commentId, CommentDto commentDto) {
        commentDao.insertReplyByCommentId(userId, commentId, commentDto);
        return "inserted successfully";
    }

    public Comment updateComment(Integer userId, Integer commentId, CommentDto commentDto) {
        Comment comment = commentDao.selectCommentById(commentId)
                .orElseThrow(() -> new IllegalStateException("comment with id " + commentId + "not found"));
        if (!Objects.equals(comment.getUserId(), userId)) {
            throw new IllegalStateException("you can not edit this post");
        }
        if (commentDto.getComment() != null && !Objects.equals(commentDto.getComment(), "")) {
            commentDao.updateComment(commentId, commentDto.getComment());
            comment.setComment(commentDto.getComment());
        }
        return comment;
    }

    public String deleteComment(Integer userId, Integer commentId) {
        if (!Objects.equals(commentDao.selectCommentById(commentId).orElseThrow().getUserId(), userId)) {
            throw new IllegalStateException("you can not edit this comment");
        }
        commentDao.deleteComment(commentId);
        return "deleted successfully";
    }
}
