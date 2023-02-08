package com.gavrilenkoan.blogrestapi.rowmapper;

import com.gavrilenkoan.blogrestapi.entity.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Post(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("text"),
                resultSet.getInt("user_id")
        );
    }
}