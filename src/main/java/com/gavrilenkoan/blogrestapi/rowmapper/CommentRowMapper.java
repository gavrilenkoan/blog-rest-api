package com.gavrilenkoan.blogrestapi.rowmapper;

import com.gavrilenkoan.blogrestapi.entity.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {

        return new Comment(
                resultSet.getInt("id"),
                resultSet.getString("comment"),
                resultSet.getTimestamp("date_of_publish"),
                resultSet.getInt("post_id"),
                resultSet.getInt("user_id")
        );
    }
}