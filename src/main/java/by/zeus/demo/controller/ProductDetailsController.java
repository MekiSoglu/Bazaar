package by.zeus.demo.controller;

import by.zeus.demo.entity.ProductDetails;
import by.zeus.demo.service.ProductDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prdDetails")
@CrossOrigin( "http://localhost:4200" )

public class ProductDetailsController {

    private final ProductDetailsService productDetailsService;

    public ProductDetailsController(ProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    @GetMapping("/{Id}")
    public ProductDetails getProductDetails(@PathVariable Long Id){
        return productDetailsService.findOne(Id).get();
    }
    @GetMapping("")
    public List<ProductDetails> getAllProductDetails(){
        return productDetailsService.findAll();
    }

    @PostMapping("")
    public void createProductDetails(@RequestBody ProductDetails productDetails){
        productDetailsService.create(productDetails);
    }

    @PutMapping("")
    public void updateProductDetails(@RequestBody ProductDetails productDetails){
        productDetailsService.Update(productDetails);
    }

    @DeleteMapping("/{Id}")
    public void delte(@PathVariable  Long Id){
        productDetailsService.delete(Id);
    }

    @DeleteMapping()
    public void deleteAll(){
        productDetailsService.deleteAll();
    }
}
