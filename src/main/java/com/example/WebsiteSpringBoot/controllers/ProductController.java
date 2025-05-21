package com.example.WebsiteSpringBoot.controllers;

import com.example.WebsiteSpringBoot.models.Product;
import com.example.WebsiteSpringBoot.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Аннотация, помечающая класс как Spring MVC Controller
@RequiredArgsConstructor // Lombok аннотация генерирует конструктор с обязательными аргументами (final полями)
public class ProductController {
    private final ProductService productService; // final - значит значение должно быть установлено в конструкторе (что делает @RequiredArgsConstructor)

    @GetMapping("/") // Обработчик GET-запросов на корневой путь ("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) { // Параметр запроса "title" (не обязательный), Объект Model для передачи данных в представление
        model.addAttribute("products", productService.listProducts(title)); // Добавление в модель списка продуктов (поиск по title если указан)
        return "products"; // Возвращает имя шаблона "products.ftlh"
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) { // Извлечение ID продукта из пути URL
        model.addAttribute("product", productService.getProductById(id)); // Добавление в модель найденного продукта
        return "product-info"; // Возвращает имя шаблона "product-info.ftlh"
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
