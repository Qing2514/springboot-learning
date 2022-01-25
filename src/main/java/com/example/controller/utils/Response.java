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
    private String msg;

    public Response(Boolean flag) {
        this.flag = flag;
    }

    public Response(String msg) {
        this.flag = false;
        this.msg = msg;
    }

    public Response(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Response(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

}
