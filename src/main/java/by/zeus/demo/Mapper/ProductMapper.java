package by.zeus.demo.Mapper;

import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.Product;
import by.zeus.demo.service.CategoryService;
import by.zeus.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.mapstruct.Mapper;

@Mapper()
public class ProductMapper {

    CategoryService categoryService;

    ProductService productService;

    public ProductMapper(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    public  Product toProduct(ProductDto productDto){
        Product product=productService.find(productDto.getId());
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setActive(productDto.getActive());
        product.setImageUrl(product.getImageUrl());
        product.setLastUpdate(product.getLastUpdate());
        product.setDateCreate(product.getDateCreate());
        product.setUnitsInStock(product.getUnitsInStock());
        Category category=categoryService.find(productDto.getId());
        product.setCategory(category);
        return product;
    }

    public  ProductDto toProductDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setActive(product.isActive());
        productDto.setName(product.getName());
        productDto.setUnitStocks(product.getUnitsInStock());
        productDto.setDescription(productDto.getDescription());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setLastUpdate(product.getLastUpdate());
        productDto.setSku(product.getSku());
        productDto.setDataCreate(product.getDateCreate());
        return productDto;
    }

}
