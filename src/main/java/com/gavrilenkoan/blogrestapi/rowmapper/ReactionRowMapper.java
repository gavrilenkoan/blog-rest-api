package com.gavrilenkoan.blogrestapi.rowmapper;

import com.gavrilenkoan.blogrestapi.entity.Reaction;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReactionRowMapper implements RowMapper<Reaction> {

    @Override
    public Reaction mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Reaction(
                resultSet.getInt("id"),
                resultSet.getBoolean("reaction"),
                resultSet.getInt("user_id"),
                resultSet.getInt("post_id"),
                resultSet.getInt("comment_id")
        );
    }
}
