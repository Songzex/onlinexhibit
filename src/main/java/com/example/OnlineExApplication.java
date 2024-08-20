package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableCaching
@CrossOrigin
public class OnlineExApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineExApplication.class, args);
    }

}
