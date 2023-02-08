package com.gavrilenkoan.blogrestapi.das;

import com.gavrilenkoan.blogrestapi.dao.PostDao;
import com.gavrilenkoan.blogrestapi.dto.PostDto;
import com.gavrilenkoan.blogrestapi.entity.Post;
import com.gavrilenkoan.blogrestapi.rowmapper.PostRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostDas implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    public PostDas(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> selectPosts() {
        var sql = "SELECT * FROM post";
        return jdbcTemplate.query(sql, new PostRowMapper());
    }

    @Override
    public List<Post> selectPostsByUserId(Integer userId) {
        var sql = "SELECT * FROM post WHERE user_id = ?";
        return jdbcTemplate.query(sql, new PostRowMapper(), userId);
    }

    @Override
    public void insertPost(Integer userId, PostDto postDto) {
        var sql = "INSERT INTO post(title, \"text\", user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, postDto.getTitle(), postDto.getText(), userId);
    }

    @Override
    public void deletePost(Integer id) {
        var sql = "DELETE FROM post WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Post> selectPostById(Integer id) {
        var sql = "SELECT * FROM post WHERE id = ?";
        return jdbcTemplate.query(sql, new PostRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public void updatePostTitle(Integer id, String title) {
        var sql = "UPDATE post SET title = ? WHERE id = ?";
        jdbcTemplate.update(sql, title, id);
    }

    @Override
    public void updatePostText(Integer id, String text) {
        var sql = "UPDATE post SET \"text\" = ? WHERE id = ?";
        jdbcTemplate.update(sql, text, id);
    }
}
