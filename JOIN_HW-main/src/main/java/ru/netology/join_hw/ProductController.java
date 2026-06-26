package ru.netology.join_hw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/fetch-product")
    public String fetchProduct(@RequestParam String name) {
        List<String> products = productRepository.getProductName(name);
        if (products.isEmpty()) {
            return "Продукты не найдены для пользователя с именем: " + name;
        }
        return String.join(", ", products);
    }
}
