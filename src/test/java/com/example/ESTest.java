package com.example;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * ESTest
 *
 * @author Qing2514
 * @since 0.0.1
 */
@SpringBootTest
public class ESTest {

    // 低版本
    // @Autowired
    // private ElasticsearchRestTemplate clesient;

    private RestHighLevelClient client;

    // 所有方法执行前都先执行该方法
    @BeforeEach
    void setup() {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    // 所有方法执行后都执行该方法
    @AfterEach
    void tearDown() throws IOException {
        client.close();
    }

    @Test
    void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);
    }
}
