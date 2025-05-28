package com.example.WebsiteSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Аннотация, объединяющая три основные аннотации Spring: 1. @Configuration 2. @EnableAutoConfiguration 3. @ComponentScan
public class WebsiteSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteSpringBootApplication.class, args);
    }
}
