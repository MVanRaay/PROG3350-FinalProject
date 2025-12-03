package com.example.inventory_service.service;

import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository _repo;

    public InventoryService(InventoryRepository repo) {
        _repo = repo;
    }

    public List<Inventory> findAll() {
        return _repo.findAll();
    }

    public Inventory findByProductId(int productId) {
        return _repo.findInventoryByProductId(productId).orElseThrow();
    }

    public Inventory addStock(int productId, int quantity) {
        Inventory stock = _repo.findInventoryByProductId(productId).orElseThrow();
        stock.setQuantity(stock.getQuantity() + quantity);
        return _repo.save(stock);
    }

    public Inventory removeStock(int productId, int quantity) {
        Inventory stock = _repo.findInventoryByProductId(productId).orElseThrow();
        if (stock.getQuantity() < quantity) throw new IllegalArgumentException();
        stock.setQuantity(stock.getQuantity() - quantity);
        return _repo.save(stock);
    }

    public Inventory addInventoryRecord(int productId, int quantity) {
        if (_repo.existsInventoryByProductId(productId)) throw new IllegalArgumentException();
        Inventory stock = new Inventory();
        stock.setProductId(productId);
        stock.setQuantity(quantity);
        return _repo.save(stock);
    }

    public boolean deleteInventoryRecord(int productId) {
        if (!_repo.existsInventoryByProductId(productId)) throw new IllegalArgumentException();
        _repo.deleteInventoryByProductId(productId);
        return !_repo.existsInventoryByProductId(productId);
    }
}
