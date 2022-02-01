package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * BookDaoTest
 *
 * @author Qing2514
 * @since 0.0.1
 */
@SpringBootTest
// 测试数据库，数据不会插入到数据库（自动回滚，若id是自增，id会被占用）
@Transactional
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetAll() {
        bookDao.selectList(null);
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("testSave3");
        book.setDescription("testSave3");
        bookDao.insert(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(8);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 5);
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy() {
        String name = "Java";
        // QueryWrapper<Book> qw = new QueryWrapper<>();
        // qw.like("name",name);
        // bookDao.selectList(qw);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Book::getName, name);
        bookDao.selectList(lqw);
    }
}
