package by.zeus.demo.product.web.mapper;

import by.zeus.demo.product.web.dto.ProductDto;
import by.zeus.demo.category.domain.Category;
import by.zeus.demo.product.domain.Product;
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
        productDto.setCategory_id(product.getCategory().getId());
        return productDto;
    }

}
