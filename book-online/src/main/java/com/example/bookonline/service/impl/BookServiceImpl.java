package com.example.bookonline.service.impl;

import com.example.bookonline.dao.BookDao;
import com.example.bookonline.dao.impl.BookDaoImpl;
import com.example.bookonline.entity.Book;
import com.example.bookonline.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao=new BookDaoImpl();
    @Override
    public List<Book> getBooks() {
        return bookDao.selectAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
}
