package com.example.WebsiteSpringBoot.repositories;

import com.example.WebsiteSpringBoot.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
