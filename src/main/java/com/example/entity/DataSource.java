package com.example.entity;

import lombok.Data;

/**
 * DataSource
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Data
// @Component
// // "" 中不能有大写
// @ConfigurationProperties("datasource")
public class DataSource {
    private String driver;
    private String url;
    private String username;
    private String password;
}
