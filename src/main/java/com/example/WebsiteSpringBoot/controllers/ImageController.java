package com.example.WebsiteSpringBoot.controllers;

import com.example.WebsiteSpringBoot.models.Image;
import com.example.WebsiteSpringBoot.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
// Аннотация, помечающая класс как Spring REST-контроллер (Автоматически преобразует возвращаемые значения в JSON/HTTP-ответы)
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable long id) {
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok() // Строим HTTP-ответ
                .header("fileName", image.getOriginalFileName()) // Добавляем кастомный заголовок с оригинальным именем файла
                .contentType(MediaType.valueOf(image.getContentType())) // Устанавливаем Content-Type из метаданных изображения
                .contentLength(image.getSize()) // Указываем размер файла в байтах
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes()))); // Тело ответа: оборачиваем байты в InputStreamResource
    }
}
