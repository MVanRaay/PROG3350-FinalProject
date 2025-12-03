package com.example.inventory_service.controller;

import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService _service;

    public InventoryController(InventoryService service) {
        _service = service;
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return new ResponseEntity<>(_service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(_service.findByProductId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/add")
    public ResponseEntity<Inventory> addStockToInventory(@PathVariable int id, @RequestParam int quantity) {
        try {
            return new ResponseEntity<>(_service.addStock(id, quantity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/remove")
    public ResponseEntity<Inventory> removeStockFromInventory(@PathVariable int id, @RequestParam int quantity) {
        try {
            return new ResponseEntity<>(_service.removeStock(id, quantity), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        try {
            return new ResponseEntity<>(_service.addInventoryRecord(inventory.getProductId(), inventory.getQuantity()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable int id) {
        try {
            boolean isDeleted = _service.deleteInventoryRecord(id);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
