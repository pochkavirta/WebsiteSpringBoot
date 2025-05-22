package com.example.WebsiteSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Аннотация, объединяющая три основные аннотации Spring:
// 1. @Configuration - класс содержит конфигурацию Spring
// 2. @EnableAutoConfiguration - автоматическая настройка Spring Boot
// 3. @ComponentScan - сканирование компонентов в текущем пакете и подпакетах
@SpringBootApplication
public class WebsiteSpringBootApplication {

    public static void main(String[] args) {
        // Запуск Spring Boot приложения:
        // 1. WebsiteSpringBootApplication.class - корневой класс конфигурации
        // 2. args - аргументы командной строки
        SpringApplication.run(WebsiteSpringBootApplication.class, args);
    }
}
