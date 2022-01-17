package com.example.entity;

/**
 * Book
 *
 * @author Qing2514
 * @since 0.0.1
 */
public class Book {

    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "编号: " + id + ", 书名: " + name;
    }
}
