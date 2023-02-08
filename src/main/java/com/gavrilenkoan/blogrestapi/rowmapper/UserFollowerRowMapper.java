package com.gavrilenkoan.blogrestapi.rowmapper;

import com.gavrilenkoan.blogrestapi.entity.UserFollower;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFollowerRowMapper implements RowMapper<UserFollower> {

    @Override
    public UserFollower mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UserFollower(
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                resultSet.getInt("follower_id")
        );
    }
}
