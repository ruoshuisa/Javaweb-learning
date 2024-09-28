package com.example.bookonline.dao.impl;

import com.alibaba.druid.sql.dialect.antspark.ast.AntsparkCreateTableStatement;
import com.example.bookonline.dao.UserDao;
import com.example.bookonline.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.bookonline.util.JdbcUtil;

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public int insertUser(User user) {
        String sql = "INSERT INTO t_user(account,password,nickname,avatar,address) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, user.getAccount(), user.getPassword(), user.getNickname(), user.getAvatar(), user.getAddress());
    }

    @Override
    public User findUser(User userDto) {
        try {
            String sql = "SELECT * FROM t_user WHERE account = ? AND password = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userDto.getAccount(), userDto.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isUserExists(String account) {
        try {
            String sql = "SELECT COUNT(*) FROM t_user WHERE account = ?";
            Integer count = jdbcTemplate.queryForObject(sql, Integer.class, account);
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
