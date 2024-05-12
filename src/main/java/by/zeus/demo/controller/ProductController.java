package by.zeus.demo.controller;

import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Product;
import by.zeus.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{Id}")
    public ProductDto getProduct(@PathVariable Long Id){
        return productService.find(Id);
    }

    @GetMapping("/products")
    @CrossOrigin ( "http://localhost:4200" )
    public List<ProductDto> getAllProducts(){
        return productService.getAll();
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody ProductDto productDto){
        productService.update(productDto);
    }

    @PostMapping("/products")
    public void create(@RequestBody ProductDto product){
        productService.create(product);
    }

    @DeleteMapping("/products/{Id}")
    public void delete(@PathVariable Long Id){
        productService.delete(Id);
    }
}
