package com.example.WebsiteSpringBoot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Указывает, что этот класс является JPA сущностью (будет отображаться в таблицу БД)
@Table(name = "products") // Задает имя таблицы в БД (если не указать, будет использовано имя класса)
@Data // Lombok - автоматически генерирует геттеры, сеттеры, toString(), equals(), hashCode()
@AllArgsConstructor // Lombok - генерирует конструктор со всеми полями
@NoArgsConstructor // Lombok - генерирует пустой конструктор
public class Product {

    @Id // Поле является первичным ключом
    @GeneratedValue(strategy = GenerationType.AUTO) // Стратегия генерации ID (автоматический выбор)
    @Column(name = "id") // Связь с колонкой "id" в таблице
    private Long id; // Уникальный идентификатор продукта

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "text") // Колонка с типом TEXT в БД
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "city")
    private String city;

    @Column(name = "author")
    private String author;
}
