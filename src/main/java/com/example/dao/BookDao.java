package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * BookService
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
    // void save();
}
