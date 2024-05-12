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
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{Id}")
    @CrossOrigin ( "http://localhost:4200" )
    public ProductDto getProduct(@PathVariable Long Id){
        return ProductMapper.toProductDto(productService.findOne(Id).get());
    }

    @GetMapping("")
    @CrossOrigin ( "http://localhost:4200" )
    public List<ProductDto> getAllProducts(){
        return productService.getAll();
    }

    @PutMapping("")
    @CrossOrigin ( "http://localhost:4200" )
    public void updateProduct(@RequestBody ProductDto productDto){
        productService.update(productDto);
    }

    @PostMapping("")
    @CrossOrigin ( "http://localhost:4200" )
    public void create(@RequestBody ProductDto product){
        productService.create(product);
    }

    @DeleteMapping("/{Id}")
    @CrossOrigin ( "http://localhost:4200" )
    public void delete(@PathVariable Long Id){
        productService.delete(Id);
    }

    @DeleteMapping()
    public void deleteAll(){
        productService.deleteAll();
    }


}
