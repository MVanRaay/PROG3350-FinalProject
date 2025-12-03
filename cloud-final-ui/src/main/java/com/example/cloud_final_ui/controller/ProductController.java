package com.example.cloud_final_ui.controller;

import com.example.cloud_final_ui.model.Inventory;
import com.example.cloud_final_ui.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final RestClient restClient;

    public ProductController(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("https://api-gateway-1sg9.onrender.com/api").build();
    }

    @GetMapping
    public String index(Model model) {
        var response = restClient.get()
                .uri("/products")
                .retrieve()
                .body(Product[].class);

        List<Product> products = response == null
                ? List.of()
                : Arrays.stream(response)
                        .sorted(Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER))
                        .toList();

        var inventoryResponse = restClient.get()
                .uri("/inventory")
                .retrieve()
                .body(Inventory[].class);

        List<Inventory> inventory = inventoryResponse == null
                ? List.of()
                : Arrays.stream(inventoryResponse)
                        .toList();

        for (Product product : products) {
            product.setInventoryCount(inventory.stream()
                    .filter(i -> i.getProductId() == product.getId())
                    .findFirst()
                    .get()
                    .getQuantity());
        }

        model.addAttribute("products", products);

        return "index";
    }
}
