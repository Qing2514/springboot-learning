package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;

import java.util.List;

/**
 * BookService
 *
 * @author Qing2514
 * @since 0.0.1
 */
public interface BookService {
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean deleteById(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(int currentPage, int pageSize);
}
