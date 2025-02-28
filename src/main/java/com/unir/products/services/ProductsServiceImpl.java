package com.unir.products.services;

import com.unir.products.data.ProductRepository;
import com.unir.products.model.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getProducts() {
        List<Product> products = repository.findAll();
        return products.isEmpty() ? null : products;
    }

    @Override
    public Product getProduct(String productId) {
        return repository.findByISBN(productId)
                .stream()
                .findFirst()
                .orElse(null);
    }

}