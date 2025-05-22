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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Product product) throws IOException {
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
