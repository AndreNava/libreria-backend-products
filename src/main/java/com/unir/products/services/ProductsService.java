package com.unir.products.services;

import com.unir.products.model.pojo.Product;
import com.unir.products.model.request.CreateProductRequest;
import java.util.List;

public interface ProductsService {
    List<Product> getProducts();
    Product getProduct(String ISBN);
}