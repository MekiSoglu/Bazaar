package by.zeus.demo.controller;

import by.zeus.demo.Mapper.ProductMapper;
import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Product;
import by.zeus.demo.service.ProductService;
import org.hibernate.annotations.SoftDelete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin ( "http://localhost:4200" )

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{Id}")
    public ProductDto getProduct(@PathVariable Long Id){
        return ProductMapper.toProductDto(productService.findOne(Id).get());
    }

    @GetMapping("")
    public List<ProductDto> getAllProducts(){
        return productService.getAll();
    }

    @PutMapping("")
    public void updateProduct(@RequestBody ProductDto productDto){
        productService.update(productDto);
    }

    @PostMapping("")
    public void create(@RequestBody ProductDto product){
        productService.create(product);
    }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable Long Id){
        productService.delete(Id);
    }

    @DeleteMapping()
    public void deleteAll(){
        productService.deleteAll();
    }


}
