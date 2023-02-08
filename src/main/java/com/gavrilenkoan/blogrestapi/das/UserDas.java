package com.gavrilenkoan.blogrestapi.das;

import com.gavrilenkoan.blogrestapi.dao.UserDao;
import com.gavrilenkoan.blogrestapi.dto.UserDto;
import com.gavrilenkoan.blogrestapi.entity.User;
import com.gavrilenkoan.blogrestapi.rowmapper.UserFollowerRowMapper;
import com.gavrilenkoan.blogrestapi.rowmapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDas implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDas(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> selectAllUsers() {
        var sql = "SELECT * FROM _user";
        return jdbcTemplate.query(sql, new UserRowMapper());
        }

    @Override
    public void insertUser(UserDto userDto) {
        var sql = "INSERT INTO _user(username, firstname, lastname, email, \"password\") VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                userDto.getUsername(), userDto.getFirstname(), userDto.getLastname(), userDto.getEmail(), userDto.getPassword()
        );
    }

    @Override
    public Integer deleteUser(Integer id) {
        var sql = "DELETE FROM _user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<User> selectUserById(Integer id) {
        var sql = "SELECT * FROM _user WHERE id = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        var sql = "SELECT * FROM _user WHERE username = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), username)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<User> selectUserByEmail(String email) {
        var sql = "SELECT * FROM _user WHERE email = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), email)
                .stream()
                .findFirst();
    }

    @Override
    public void updateUserUsername(Integer id, String username) {
        var sql = "UPDATE _user SET username = ? WHERE id = ?";
        jdbcTemplate.update(sql, username, id);
    }

    @Override
    public void updateUserFirstname(Integer id, String firstname) {
        var sql = "UPDATE _user SET firstname = ? WHERE id = ?";
        jdbcTemplate.update(sql, firstname, id);
    }

    @Override
    public void updateUserLastname(Integer id, String lastname) {
        var sql = "UPDATE _user SET lastname = ? WHERE id = ?";
        jdbcTemplate.update(sql, lastname, id);
    }

    @Override
    public void updateUserEmail(Integer id, String email) {
        var sql = "UPDATE _user SET email = ? WHERE id = ?";
        jdbcTemplate.update(sql, email, id);
    }

    @Override
    public void updateUserPassword(Integer id, String password) {
        var sql = "UPDATE _user SET \"password\" = ? WHERE id = ?";
        jdbcTemplate.update(sql, password, id);
    }

    @Override
    public List<User> selectAllFollowersById(Integer id) {
        var sql = "SELECT _user.id, username, firstname, lastname, email, \"password\" FROM _user JOIN user_follower uf ON _user.id = uf.follower_id WHERE uf.user_id = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), id);
    }

    @Override
    public List<User> selectAllFollowingById(Integer id) {
        var sql = "SELECT _user.id, username, firstname, lastname, email, \"password\" FROM _user JOIN user_follower uf ON _user.id = uf.user_id WHERE uf.follower_id = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), id);
    }

    @Override
    public Integer insertFollowing(Integer userId, Integer followerId) {
        var sql = "INSERT INTO user_follower(user_id, follower_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, userId, followerId);
    }

    @Override
    public boolean isUserFollowerRelationExists(Integer userId, Integer followerId) {
        var sql = "SELECT * FROM user_follower WHERE user_id = ? AND follower_id = ?";
        return jdbcTemplate.query(sql, new UserFollowerRowMapper(), userId, followerId)
                .stream()
                .findFirst()
                .isPresent();
    }
}
