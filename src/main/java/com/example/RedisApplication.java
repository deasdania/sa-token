package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@SpringBootApplication
@RestController
@RequestMapping("/product")
public class RedisApplication {

    @Autowired
    private ProductDao dao;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return dao.save(product);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable String id) {
        return dao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable String id) {
        return dao.deleteProduct(id);
    }

    public static void main(String []args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
