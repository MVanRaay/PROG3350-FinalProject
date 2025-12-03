package com.example.product_service.service;

import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository _repo;

    public ProductService(ProductRepository repo) {
        _repo = repo;
    }

    public List<Product> findAll() {
        return _repo.findAll();
    }

    public Product findById(int id) {
        return _repo.findById(id).orElseThrow();
    }

    public Product addProduct(Product product) {
        product.setSku(UUID.randomUUID().toString());
        return _repo.save(product);
    }

    public Product updateProduct(int id, Product newProduct) {
        Product product = _repo.findById(id).orElseThrow();
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setPrice(newProduct.getPrice());
        product.setActive(newProduct.isActive());
        product.setImage(newProduct.getImage());
        return _repo.save(product);
    }

    public boolean deleteById(int id) {
        _repo.deleteById(id);
        return !_repo.existsById(id);
    }
}
