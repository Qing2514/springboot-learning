package com.example;

import com.alibaba.fastjson.JSON;
import com.example.dao.BookDao;
import com.example.domain.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

/**
 * ESTest
 *
 * @author Qing2514
 * @since 0.0.1
 */
@SpringBootTest
public class ESTest {

    @Autowired
    private BookDao bookDao;

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

    @Test
    void createIndexByIK() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        String json = "{\"mappings\": {\"properties\": {\"id\": {\"type\": \"keyword\"},\"name\": {\"type\": " +
                "\"text\",\"analyzer\": \"ik_max_word\",\"copy_to\": \"all\"},\"description\": {\"type\": \"text\"," +
                "\"analyzer\": \"ik_max_word\",\"copy_to\": \"all\"},\"all\": {\"type\": \"text\",\"analyzer\": " +
                "\"ik_max_word\"}}}}";
        // 设置请求中的参数
        request.source(json, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void createDoc() throws IOException {
        Book book = bookDao.selectById(1);
        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        // 设置请求中的参数
        String json = JSON.toJSONString(book);
        System.out.println(json);
        request.source(json, XContentType.JSON);
        client.index(request, RequestOptions.DEFAULT);
    }

    @Test
    void createDocAll() throws IOException {
        List<Book> bookList = bookDao.selectList(null);
        BulkRequest bulk = new BulkRequest();
        for (Book book : bookList) {
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json, XContentType.JSON);
            bulk.add(request);
        }
        client.bulk(bulk, RequestOptions.DEFAULT);
    }

    @Test
        // 按id查询
    void get() throws IOException {
        // 查询id为1的项
        GetRequest request = new GetRequest("books", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        System.out.println(json);
    }

    @Test
        // 按条件查询
    void search() throws IOException {
        SearchRequest request = new SearchRequest("books");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        // 查询all属性(包含name属性和description属性)中含java的项
        builder.query(QueryBuilders.termQuery("all", "java"));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            String source = hit.getSourceAsString();
            System.out.println(source);
            Book book = JSON.parseObject(source, Book.class);
            System.out.println(book);
        }
    }
}
