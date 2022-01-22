package com.example.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * DataSource
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Data
@Component
// "" 中不能有大写
@ConfigurationProperties("source")
public class Source {
    private String driver;
    private String url;
    private String username;
    private String password;
}
