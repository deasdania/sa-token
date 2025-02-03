package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {

    @Autowired
    private ProductDao dao;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Save Product");
            System.out.println("2. Get All Products");
            System.out.println("3. Get Product By ID");
            System.out.println("4. Delete Product By ID");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter product id:");
                    String id = scanner.nextLine();
                    System.out.println("Enter product name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter product price:");
                    Long price = scanner.nextLong();
                    System.out.println("Enter product qty:");
                    int qty = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    Product newProduct = new Product();
                    newProduct.setId(id);
                    newProduct.setName(name);
                    newProduct.setPrice(price);
                    newProduct.setQty(qty);
                    dao.save(newProduct);
                    System.out.println("Product saved successfully.");
                    break;
                case 2:
                    List<Product> products = dao.findAll();
                    System.out.println("All Products:");
                    products.forEach(product -> System.out.println(product));
                    break;
                case 3:
                    System.out.println("Enter product ID:");
                    String did = scanner.nextLine();
                    Product product = dao.findProductById(did);
                    if (product != null) {
                        System.out.println("Product found: " + product);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter product ID to delete:");
                    String deleteId = scanner.nextLine();
                    String result = dao.deleteProduct(deleteId);
                    System.out.println(result);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
