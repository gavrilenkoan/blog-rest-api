package com.gavrilenkoan.blogrestapi.das;

import com.gavrilenkoan.blogrestapi.dao.ReactionDao;
import com.gavrilenkoan.blogrestapi.dto.ReactionDto;
import com.gavrilenkoan.blogrestapi.entity.Reaction;
import com.gavrilenkoan.blogrestapi.rowmapper.ReactionRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReactionDas implements ReactionDao {

    private final JdbcTemplate jdbcTemplate;

    public ReactionDas(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Reaction> selectReactionsByPostId(Integer postId) {
        var sql = "SELECT * FROM reaction WHERE post_id = ?";
        return jdbcTemplate.query(sql, new ReactionRowMapper(), postId);
    }

    @Override
    public List<Reaction> selectReactionsByCommentId(Integer commentId) {
        var sql = "SELECT * FROM reaction WHERE comment_id = ?";
        return jdbcTemplate.query(sql, new ReactionRowMapper(), commentId);
    }

    @Override
    public void insertReactionByPostId(Integer userId, Integer postId, ReactionDto reactionDto) {
        var sql = "INSERT INTO reaction(reaction, user_id, post_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, reactionDto.getReaction(), userId, postId);
    }

    @Override
    public void insertReactionByCommentId(Integer userId, Integer commentId, ReactionDto reactionDto) {
        var sql = "INSERT INTO reaction(reaction, user_id, comment_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, reactionDto.getReaction(), userId, commentId);
    }

    @Override
    public void deleteReaction(Integer id) {
        var sql = "DELETE FROM reaction WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Reaction> selectReactionById(Integer id) {
        var sql = "SELECT * FROM reaction WHERE id = ?";
        return jdbcTemplate.query(sql, new ReactionRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public void updateReaction(Integer id, ReactionDto reactionDto) {
        var sql = "UPDATE reaction SET reaction = ? WHERE id = ?";
        jdbcTemplate.update(sql, reactionDto.getReaction(), id);
    }

    @Override
    public boolean ReactionUserPostRelationExists(Integer userId, Integer postId) {
        var sql = "SELECT * FROM reaction WHERE user_id = ? AND post_id = ?";
        return jdbcTemplate.query(sql, new ReactionRowMapper(), userId, postId)
                .stream()
                .findFirst()
                .isPresent();
    }

    @Override
    public boolean ReactionUserCommentRelationExists(Integer userId, Integer commentId) {
        var sql = "SELECT * FROM reaction WHERE user_id = ? AND comment_id = ?";
        return jdbcTemplate.query(sql, new ReactionRowMapper(), userId, commentId)
                .stream()
                .findFirst()
                .isPresent();
    }
}
