package by.zeus.demo.Mapper;

import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.Product;
import by.zeus.demo.service.CategoryService;
import by.zeus.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

public class ProductMapper {



    public static   Product toProduct(ProductDto productDto,Category category){
        Product product=new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setActive(productDto.getActive());
        product.setImageUrl(product.getImageUrl());
        product.setLastUpdate(product.getLastUpdate());
        product.setDateCreate(product.getDateCreate());
        product.setUnitsInStock(product.getUnitsInStock());
        product.setCategory(category);
        return product;
    }

    public static   ProductDto toProductDto(Product product){
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
