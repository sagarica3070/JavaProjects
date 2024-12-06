package com.example.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.inventory_service.model.Inventory; // Ensure this is the correct import for your Inventory class
import com.example.inventory_service.repository.InventoryRepository;
@EnableDiscoveryClient

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            // First Inventory instance
            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone_13");
            inventory1.setQuantity(100);

            // Second Inventory instance
            Inventory inventory2 = new Inventory();
            inventory2.setSkuCode("iphone_1_red");
            inventory2.setQuantity(2);

            // Save both instances to the repository
            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
        };
    }
}
