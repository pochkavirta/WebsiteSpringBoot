package com.example.WebsiteSpringBoot.services;

import com.example.WebsiteSpringBoot.models.Product;
import com.example.WebsiteSpringBoot.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Аннотация @Service указывает, что этот класс является сервисом - компонентом бизнес-логики
@Slf4j // Аннотация Lombok @Slf4j автоматически создает логгер (переменную log) для класса
@RequiredArgsConstructor // Аннотация Lombok @RequiredArgsConstructor генерирует конструктор для всех final полей
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        if (title != null) {
            return productRepository.findByTitle(title);
        }
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
