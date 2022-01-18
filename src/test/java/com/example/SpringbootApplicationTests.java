package com.example;

import com.example.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootApplication.class)
class SpringbootApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        bookDao.save();
    }

}
