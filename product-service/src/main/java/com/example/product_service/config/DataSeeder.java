package com.example.product_service.config;

import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductService service;

    @Autowired
    public DataSeeder(ProductService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        if (service.findAll().isEmpty()) {
            seedData();
            System.out.println("Seeding database with products");
        } else {
            System.out.println("Database already seeded");
        }
    }

    private void seedData() {
        Product product1 = new Product();
        product1.setName("Nike Air Max 90");
        product1.setDescription("White and Red");
        product1.setPrice(129.99);
        product1.setActive(true);
        product1.setImage("");
        service.addProduct(product1);

        Product product2 = new Product();
        product2.setName("Adidas Ultraboost");
        product2.setDescription("Black running shoes");
        product2.setPrice(180.00);
        product2.setActive(true);
        product2.setImage("");
        service.addProduct(product2);

        Product product3 = new Product();
        product3.setName("Converse Chuck Taylor");
        product3.setDescription("Classic canvas high-tops");
        product3.setPrice(65.00);
        product3.setActive(true);
        product3.setImage("");
        service.addProduct(product3);

        Product product4 = new Product();
        product4.setName("Vans Old Skool");
        product4.setDescription("Black and white skateboard shoes");
        product4.setPrice(70.00);
        product4.setActive(true);
        product4.setImage("");
        service.addProduct(product4);

        Product product5 = new Product();
        product5.setName("New Balance 574");
        product5.setDescription("Grey suede casual sneakers");
        product5.setPrice(85.00);
        product5.setActive(true);
        product5.setImage("");
        service.addProduct(product5);

        Product product6 = new Product();
        product6.setName("Puma Suede Classic");
        product6.setDescription("Blue suede with white stripe");
        product6.setPrice(75.00);
        product6.setActive(true);
        product6.setImage("");
        service.addProduct(product6);

        Product product7 = new Product();
        product7.setName("Reebok Classic Leather");
        product7.setDescription("All white leather sneakers");
        product7.setPrice(80.99);
        product7.setActive(true);
        product7.setImage("");
        service.addProduct(product7);

        Product product8 = new Product();
        product8.setName("Air Jordan 1");
        product8.setDescription("Bred colorway");
        product8.setPrice(170.00);
        product8.setActive(true);
        product8.setImage("");
        service.addProduct(product8);

        Product product9 = new Product();
        product9.setName("Asics Gel-Kayano");
        product9.setDescription("Running shoes with gel cushioning");
        product9.setPrice(160.00);
        product9.setActive(true);
        product9.setImage("");
        service.addProduct(product9);

        Product product10 = new Product();
        product10.setName("Saucony Jazz Original");
        product10.setDescription("Vintage running style");
        product10.setPrice(90.00);
        product10.setActive(true);
        product10.setImage("");
        service.addProduct(product10);

        Product product11 = new Product();
        product11.setName("Under Armour HOVR");
        product11.setDescription("Connected running shoes");
        product11.setPrice(140.00);
        product11.setActive(true);
        product11.setImage("");
        service.addProduct(product11);

        Product product12 = new Product();
        product12.setName("Brooks Ghost 14");
        product12.setDescription("Neutral running shoes");
        product12.setPrice(130.00);
        product12.setActive(true);
        product12.setImage("");
        service.addProduct(product12);

        Product product13 = new Product();
        product13.setName("Salomon Speedcross");
        product13.setDescription("Trail running shoes");
        product13.setPrice(135.00);
        product13.setActive(true);
        product13.setImage("");
        service.addProduct(product13);

        Product product14 = new Product();
        product14.setName("Hoka Clifton 8");
        product14.setDescription("Maximum cushion running shoes");
        product14.setPrice(145.00);
        product14.setActive(true);
        product14.setImage("");
        service.addProduct(product14);

        Product product15 = new Product();
        product15.setName("On Cloud 5");
        product15.setDescription("Swiss engineered running shoes");
        product15.setPrice(139.99);
        product15.setActive(true);
        product15.setImage("");
        service.addProduct(product15);

        Product product16 = new Product();
        product16.setName("Timberland 6-Inch Boot");
        product16.setDescription("Classic wheat work boots");
        product16.setPrice(198.00);
        product16.setActive(true);
        product16.setImage("");
        service.addProduct(product16);

        Product product17 = new Product();
        product17.setName("Dr. Martens 1460");
        product17.setDescription("8-eye leather boots");
        product17.setPrice(170.00);
        product17.setActive(true);
        product17.setImage("");
        service.addProduct(product17);

        Product product18 = new Product();
        product18.setName("Clarks Desert Boot");
        product18.setDescription("Suede chukka boots");
        product18.setPrice(150.00);
        product18.setActive(true);
        product18.setImage("");
        service.addProduct(product18);

        Product product19 = new Product();
        product19.setName("Allbirds Wool Runners");
        product19.setDescription("Sustainable merino wool shoes");
        product19.setPrice(98.00);
        product19.setActive(true);
        product19.setImage("");
        service.addProduct(product19);

        Product product20 = new Product();
        product20.setName("Crocs Classic Clog");
        product20.setDescription("Comfortable foam clogs");
        product20.setPrice(50.00);
        product20.setActive(true);
        product20.setImage("");
        service.addProduct(product20);
    }
}
