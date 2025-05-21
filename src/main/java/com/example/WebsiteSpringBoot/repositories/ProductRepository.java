package com.example.WebsiteSpringBoot.repositories;

import com.example.WebsiteSpringBoot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> { // Наследуется от JpaRepository, что дает базовые CRUD-операции
    List<Product> findByTitle(String title); // Декларация метода для поиска продуктов по названию
}
