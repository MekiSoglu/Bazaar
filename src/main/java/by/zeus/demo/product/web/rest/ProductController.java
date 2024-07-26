package by.zeus.demo.product.web.rest;

import by.zeus.demo.product.web.mapper.ProductMapper;
import by.zeus.demo.product.web.dto.ProductDto;
import by.zeus.demo.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )

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
    public Page<ProductDto> getAllProducts(Pageable pageable){
        int page=pageable.getPageNumber();
        int size=pageable.getPageSize();
        return productService.getAll(page,size);
    }

    @GetMapping("/getProducts")
    public List<ProductDto> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/show/{Id}")
    public Map<String, String> ShowDetails(@PathVariable Long Id){
        return productService.showDetails(Id);
    }

    //webhook
    @GetMapping("category/{Id}")
    public Page<ProductDto> findByCategoryId(@PathVariable Long Id,Pageable pageable){
        int page=pageable.getPageNumber();
        int size=pageable.getPageSize();
        return productService.findByCategoryId(Id,page,size);
    }

    @GetMapping("search/{name}")
    public Page<ProductDto> findByName(@PathVariable String name,Pageable pageable){
        int page=pageable.getPageNumber();
        int size=pageable.getPageSize();
        return productService.findByName(name,page,size);
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
