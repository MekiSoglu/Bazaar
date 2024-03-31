package by.zeus.demo.controller;

import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Product;
import by.zeus.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public void getProduct(Long Id){
        productService.find(Id);
    }

    @PostMapping("/create")
    public void create(@RequestBody ProductDto product){
        productService.create(product);
    }
}
