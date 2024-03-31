package by.zeus.demo.Mapper;

import by.zeus.demo.dto.CategoryDto;
import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.Product;
import by.zeus.demo.service.CategoryService;
import by.zeus.demo.service.ProductService;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public class CategoryMapper {
    CategoryService categoryService;

    ProductService productService;

    public CategoryMapper(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    public Category toCategory(CategoryDto categoryDto){
        Category category=categoryService.find(categoryDto.getId());
        category.setId(categoryDto.getId());
        category.setVersion(categoryDto.getVersion());
        category.setCategoryName(category.getCategoryName());
        Category parentCategory=categoryService.find(categoryDto.getCategoryParentId());
        category.setParent(parentCategory);
       // Set<Product> products=productService.findOne(categoryDto.getId()).get();
        return category;
    }

}
