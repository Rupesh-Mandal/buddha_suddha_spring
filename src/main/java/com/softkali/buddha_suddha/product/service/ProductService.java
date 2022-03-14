package com.softkali.buddha_suddha.product.service;

import com.softkali.buddha_suddha.product.model.Product;
import com.softkali.buddha_suddha.product.repository.CategoryRepository;
import com.softkali.buddha_suddha.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public Object getAllProduct(String location) {
        List<Product> productList=productRepository.findByLocation(location).get();
        return productList;
    }

    public Object getAllCategory() {
        return categoryRepository.findAll();
    }

    public Object productCategory(String productCategory) {
        return productRepository.findByCategory(productCategory).get();
    }

    public Object loadSearch(String key) {
        return productRepository.findAll(key);
    }
}
