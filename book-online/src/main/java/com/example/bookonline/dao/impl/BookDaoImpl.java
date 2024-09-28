package com.example.bookonline.dao.impl;

import com.example.bookonline.dao.BookDao;
import com.example.bookonline.entity.Book;
import com.example.bookonline.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDaoImpl implements BookDao {
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());
    public List<Book> selectAll() {
        String sql = "SELECT * FROM t_book ORDER BY id DESC";
        return template.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM t_book WHERE id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }
}
