package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate<String, Product> template; // Autowiring the correct template

    // Save a product
    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    // Get all products
    public List<Product> findAll() {
        return (List<Product>) (List<?>) template.opsForHash().values(HASH_KEY);
    }

    // Find a product by its ID
    public Product findProductById(String id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    // Delete a product by its ID
    public String deleteProduct(String id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "Product removed";
    }
}
