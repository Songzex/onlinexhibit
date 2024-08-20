package com.example.config;

import org.springframework.stereotype.Component;

/**
 *资源未找到异常
 */

public class MyException  extends NullPointerException {

    public MyException(String message) {
        super(message);
    }


}
