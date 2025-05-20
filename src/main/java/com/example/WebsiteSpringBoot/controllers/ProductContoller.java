package com.example.WebsiteSpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductContoller {
    @GetMapping("/")
    public String products() {
        return "products";
    }
}
