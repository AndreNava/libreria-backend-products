package com.unir.products.controller;

import com.unir.products.model.pojo.Product;
import com.unir.products.services.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductsController {

    private final ProductsService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(@RequestHeader Map<String, String> headers) {
        log.info("headers: {}", headers);
        List<Product> products = service.getProducts();
        return products != null ? ResponseEntity.ok(products) : ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        log.info("Request received for product {}", productId);
        Product product = service.getProduct(productId);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }
}