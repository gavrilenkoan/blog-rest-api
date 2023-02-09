package com.gavrilenkoan.blogrestapi.das;

import com.gavrilenkoan.blogrestapi.dao.CommentDao;
import com.gavrilenkoan.blogrestapi.dto.CommentDto;
import com.gavrilenkoan.blogrestapi.entity.Comment;
import com.gavrilenkoan.blogrestapi.rowmapper.CommentRowMapper;
import com.gavrilenkoan.blogrestapi.rowmapper.ReplyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentDas implements CommentDao {

    private final JdbcTemplate jdbcTemplate;

    public CommentDas(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Comment> selectCommentsByPostId(Integer postId) {
        var sql = "SELECT * FROM \"comment\" WHERE post_id = ?";
        return jdbcTemplate.query(sql, new CommentRowMapper(), postId);
    }

    @Override
    public List<Comment> selectRepliesByCommentId(Integer commentId) {
        var sql = "SELECT co.id, co.\"comment\", co.date_of_publish, co.user_id, cr.comment_id FROM \"comment\" co JOIN comment_reply cr ON co.id = cr.reply_id WHERE cr.comment_id = ?";
        return jdbcTemplate.query(sql, new ReplyRowMapper(), commentId);
    }

    @Override
    public void insertCommentByPostId(Integer userId, Integer postId, CommentDto commentDto) {
        var sql = "INSERT INTO \"comment\"(\"comment\", date_of_publish, user_id, post_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, commentDto.getComment(), Calendar.getInstance(), userId, postId);
    }

    @Override
    public void insertReplyByCommentId(Integer userId, Integer commentId, CommentDto commentDto) {
        var sql = "INSERT INTO \"comment\"(\"comment\", date_of_publish, user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, commentDto.getComment(), Calendar.getInstance(), userId);
        Integer replyId = jdbcTemplate.queryForObject("SELECT currval('comment_id_seq')", Integer.class);
        sql = "INSERT INTO comment_reply(comment_id, reply_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, commentId, replyId);
    }

    @Override
    public void deleteComment(Integer id) {
        var sql = "DELETE FROM \"comment\" co USING comment_reply cr WHERE cr.comment_id = ?";
        jdbcTemplate.update(sql, id);
        sql = "DELETE FROM \"comment\" WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Comment> selectCommentById(Integer id) {
        var sql = "SELECT * FROM \"comment\" WHERE id = ?";
        return jdbcTemplate.query(sql, new CommentRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public void updateComment(Integer id, String comment) {
        var sql = "UPDATE \"comment\" SET \"comment\" = ? WHERE id = ?";
        jdbcTemplate.update(sql, comment, id);
    }
}
