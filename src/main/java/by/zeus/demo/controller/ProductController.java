package by.zeus.demo.controller;

import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Product;
import by.zeus.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{Id}")
    public ProductDto getProduct(@PathVariable Long Id){
        return productService.find(Id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody ProductDto product){
        productService.create(product);
    }
}
