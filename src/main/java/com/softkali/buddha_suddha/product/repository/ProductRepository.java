package com.softkali.buddha_suddha.product.repository;

import com.softkali.buddha_suddha.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<List<Product>> findByLocation(String location);
    Optional<List<Product>> findByCategory(String category);

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %?1% OR p.productDescription LIKE %?1% OR p.category LIKE %?1%")
    Optional<List<Product>> findAll(String key);
}
