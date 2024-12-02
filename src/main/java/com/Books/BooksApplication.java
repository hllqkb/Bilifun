package com.Books;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.Books.mapper")
public class BooksApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(BooksApplication.class, args);
    }
}
