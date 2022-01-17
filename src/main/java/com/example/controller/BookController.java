package com.example.controller;

import com.example.entity.Book;
import com.example.entity.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;


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

    @Value("${book[0].name}")
    private String name;

    @Value("${userDir}")
    private String userDir;

    // 获得 yml 文件中的全局对象
    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("book: save " + book);
        return "book: save " + book;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("book: delete " + id);
        return "book: delete " + id.toString();
    }

    @PutMapping
    public String update(@RequestBody Book book) {
        System.out.println("book: update " + book);
        return "book: update " + book;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println("book: getById " + id);
        return "book: getById " + id.toString();
    }

    @GetMapping
    public String getAll() {
        System.out.println("book: getAll");
        System.out.println("book[0].name: " + name);
        System.out.println("userDir: " + userDir);
        System.out.println("Environment.book[0].name: " + env.getProperty("book[0].name"));
        System.out.println(dataSource);
        return "book: getAll";
    }

}
