package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * BookController
 *
 * @author Qing2514
 * @since 0.0.1
 */
@RestController
@RequestMapping("/books")
public class BookController {
    // 读取 yml 文件中的数据
    // @Value 默认不支持复杂对象的转换，要自己去实现自定义转换器
    // 例如下面，不能直接取一个对象，只能取具体某个值
    // @Value("${book[0]}")
    // private Book book0;

    // @Value("${book[0].name}")
    // private String name;
    // @Value("${userDir}")
    // private String userDir;
    // // 获得 yml 文件中的全局对象
    // @Autowired
    // private Environment env;
    // @Autowired
    // private Source source;

    @Autowired
    private IBookService bookService;

    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.removeById(id);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping
    public List<Book> getAll() {
        // System.out.println("book[0].name: " + name);
        // System.out.println("userDir: " + userDir);
        // System.out.println("Environment.book[0].name: " + env.getProperty("book[0].name"));
        // System.out.println(source);
        return bookService.list();
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return bookService.getPage(currentPage, pageSize);
    }

}
