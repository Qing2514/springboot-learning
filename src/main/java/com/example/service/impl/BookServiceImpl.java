package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.BookDao;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BookServiceImpl
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null);
        // // 当前页数
        // System.out.println(page.getCurrent());
        // // 每页数据数
        // System.out.println(page.getSize());
        // // 数据总数
        // System.out.println(page.getTotal());
        // // 总共页数
        // System.out.println(page.getPages());
        // // 具体所有数据
        // System.out.println(page.getRecords());
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, lqw);
        return page;
    }
}
