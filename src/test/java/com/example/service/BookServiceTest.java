package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * BookServiceTest
 *
 * @author Qing2514
 * @since 0.0.1
 */
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById() {
        bookService.getById(1);
    }

    @Test
    void testGetAll() {
        bookService.list();
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("Java2");
        bookService.save(book);
    }

    @Test
    void testDelete() {
        bookService.removeById(2);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(1);
        book.setName("testUpdate");
        bookService.updateById(book);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 5);
        bookService.page(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
