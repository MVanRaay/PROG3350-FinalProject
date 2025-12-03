package com.example.inventory_service.config;

import com.example.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final InventoryService _service;

    @Autowired
    public DataSeeder(InventoryService service) {
        _service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        if (_service.findAll().isEmpty()) {
            seedData();
            System.out.println("Seeding database with inventory records.");
        } else {
            System.out.println("Database already seeded with inventory records.");
        }
    }

    private void seedData() {
        _service.addInventoryRecord(1, 5);
        _service.addInventoryRecord(2, 2);
        _service.addInventoryRecord(3, 7);
        _service.addInventoryRecord(4, 3);
        _service.addInventoryRecord(5, 4);
        _service.addInventoryRecord(6, 2);
        _service.addInventoryRecord(7, 9);
        _service.addInventoryRecord(8, 7);
        _service.addInventoryRecord(9, 15);
        _service.addInventoryRecord(10, 6);
        _service.addInventoryRecord(11, 8);
        _service.addInventoryRecord(12, 5);
        _service.addInventoryRecord(13, 3);
        _service.addInventoryRecord(14, 8);
        _service.addInventoryRecord(15, 10);
        _service.addInventoryRecord(16, 4);
        _service.addInventoryRecord(17, 6);
        _service.addInventoryRecord(18, 13);
        _service.addInventoryRecord(19, 2);
        _service.addInventoryRecord(20, 17);
    }
}
