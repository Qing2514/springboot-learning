package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * WebTest
 *
 * @author Qing2514
 * @since 0.0.1
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 随机端口号
// 开启虚拟MVC调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        // 创建虚拟请求，当前端口号下访问 /books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books1");
        // 执行请求
        ResultActions action = mvc.perform(builder);

        // 定义调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 定义预期执行状态
        ResultMatcher ok = status.isOk();
        // 使用真是执行情况与预期结果进行对比
        action.andExpect(ok);
    }

    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        // 创建虚拟请求，当前端口号下访问 /books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行请求
        ResultActions action = mvc.perform(builder);

        // 定义调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        // 定义预期响应体
        ResultMatcher result = content.string("testMockGet");
        // 使用真是执行情况与预期结果进行对比
        action.andExpect(result);
    }

    @Test
    void testJson(@Autowired MockMvc mvc) throws Exception {
        // 创建虚拟请求，当前端口号下访问 /books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行请求
        ResultActions action = mvc.perform(builder);

        // 定义调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        // 定义预期响应体（json）
        ResultMatcher result = content.json("{\"flag\":true,\"data\":[{\"id\":1,\"name\":\"JavaEE\"," +
                "\"description\":\"1\"},{\"id\":5,\"name\":\"Java\",\"description\":\"1\"},{\"id\":7," + "\"name" +
                "\":\"Java2\",\"description\":\"1\"},{\"id\":9,\"name\":\"JavaWeb\",\"description\":\"1\"}," + "{\"id" +
                "\":11,\"name\":\"springboot\",\"description\":\"1\"},{\"id\":12,\"name\":\"springmvc\"," +
                "\"description\":\"2\"}],\"msg\":null}");
        // 使用真是执行情况与预期结果进行对比
        action.andExpect(result);
    }

    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception {
        // 创建虚拟请求，当前端口号下访问 /books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行请求
        ResultActions action = mvc.perform(builder);

        // 定义调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        // 定义预期响应头
        ResultMatcher contentType = header.string("Content-Type", "null");
        // 使用真是执行情况与预期结果进行对比
        action.andExpect(contentType);
    }

    @Test
    void testGetById(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/1");
        ResultActions action = mvc.perform(builder);

        // 对比执行状态
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        action.andExpect(ok);

        // 对比响应头
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        action.andExpect(contentType);

        // 对比响应体
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\"flag\":true,\"data\":{\"id\":1,\"name\":\"JavaEE\"," + "\"description" +
                "\":\"1\"},\"msg\":null}");
        action.andExpect(result);
    }
}
