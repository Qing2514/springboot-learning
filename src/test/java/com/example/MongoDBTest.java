package com.example;

import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * MongoDBTest
 *
 * @author Qing2514
 * @since 0.0.1
 */
@SpringBootTest
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void save() {
        Book book = new Book();
        book.setId(1);
        book.setName("JavaEE");
        System.out.println(book);
        mongoTemplate.save(book);
    }

    @Test
    void find() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }
}
