package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

/**
 * IBookService
 *
 * @author Qing2514
 * @since 0.0.1
 */
public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int pages, int pageSize, Book book);
}
