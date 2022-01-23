package com.example.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Boolean flag;
    private Object data;

    public Response(Boolean flag) {
        this.flag = flag;
    }
}
