package DAO;

import Model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcUser implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcUser(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(User user) {
        String sql = "INSERT INTO user (username, password) VALUES (?, ?) RETURNING user_id";
        Integer newUserId;
        try {
            newUserId = jdbcTemplate.queryForObject(sql, Integer.class, user);
        } catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, username, password FROM users";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    public void updateAccount(User user) {
        jdbcTemplate.update("UPDATE users SET name=?, WHERE id=?", user.getUsername(), user.getId());
    }

    public void deleteAccount(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    private User mapRowToUser(SqlRowSet rs){
        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }


}
