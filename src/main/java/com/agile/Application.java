package com.agile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.agile.controller", "com" +
        ".agile.model", "com.agile.services","com.agile.repository"})

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
