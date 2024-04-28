package by.zeus.demo.Mapper;

import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.Product;
public class ProductMapper {



    public static Product toProduct(ProductDto productDto,Category category){
        Product product=new Product();
        product.setId(productDto.getId());
        product.setSku(productDto.getSku());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setActive(productDto.getActive());
        product.setImageUrl(productDto.getImageUrl());
        product.setLastUpdate(productDto.getLastUpdate());
        product.setDateCreate(productDto.getDataCreate());
        product.setUnitsInStock(productDto.getUnitStocks());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setCategory(category);
        return product;
    }

    public static   ProductDto toProductDto(Product product){
        ProductDto productDto=new ProductDto();

        productDto.setId(product.getId());
        productDto.setSku(product.getSku());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setActive(product.isActive());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setLastUpdate(product.getLastUpdate());
        productDto.setDataCreate(product.getDateCreate());
        productDto.setUnitStocks(product.getUnitsInStock());
        productDto.setUnitPrice(product.getUnitPrice());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }

}
