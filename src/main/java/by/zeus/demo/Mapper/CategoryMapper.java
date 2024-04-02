package by.zeus.demo.Mapper;

import by.zeus.demo.dto.CategoryDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.service.CategoryService;
import by.zeus.demo.service.ProductService;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

public class CategoryMapper {



    public static Category toCategory(CategoryDto categoryDto,Category parentCategorys){
        Category category=new Category();
        category.setId(categoryDto.getId());
        category.setVersion(categoryDto.getVersion());
        category.setCategoryName(category.getCategoryName());
        Category parentCategory=parentCategorys;
        category.setParent(parentCategory);
       // Set<Product> products=productService.findOne(categoryDto.getId()).get();
        return category;
    }

}
