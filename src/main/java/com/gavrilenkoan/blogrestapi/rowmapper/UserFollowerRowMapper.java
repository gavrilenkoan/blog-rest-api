package com.gavrilenkoan.blogrestapi.rowmapper;

import com.gavrilenkoan.blogrestapi.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFollowerRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(
                resultSet.getInt("id")
        );
    }
}
