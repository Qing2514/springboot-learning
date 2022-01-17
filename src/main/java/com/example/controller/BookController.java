package com.example.controller;

import com.example.entity.Book;
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
        return "book: getAll";
    }

}
