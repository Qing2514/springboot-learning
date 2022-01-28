package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.Response;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

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
    public Response save(@RequestBody Book book) {
        log.info("info");
        log.warn("warn");
        log.error("error");
        boolean flag = bookService.save(book);
        return new Response(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        boolean flag = bookService.removeById(id);
        return new Response(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }

    @PutMapping
    public Response update(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new Response(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @GetMapping("/{id}")
    public Response getById(@PathVariable Integer id) {
        return new Response(true, bookService.getById(id));
    }

    @GetMapping
    public Response getAll() {
        // System.out.println("book[0].name: " + name);
        // System.out.println("userDir: " + userDir);
        // System.out.println("Environment.book[0].name: " + env.getProperty("book[0].name"));
        // System.out.println(source);
        return new Response(true, bookService.list());
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Response getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()) {
            bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new Response(true, page);
    }

}
