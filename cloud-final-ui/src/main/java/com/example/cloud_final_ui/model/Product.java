package com.example.cloud_final_ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String sku;
    private boolean active;
    private String image;
    private Integer inventoryCount;
}
