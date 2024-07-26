package by.zeus.demo.Mapper;

import by.zeus.demo.dto.CategoryDetailsDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.CategoryDetails;
import by.zeus.demo.service.CategoryService;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class CategoryDetailsMapper {
    private static  CategoryService categoryService = null;
    public static List<Long> Ids;

    public CategoryDetailsMapper(CategoryService categoryService) {
        CategoryDetailsMapper.categoryService = categoryService;
    }

    public static CategoryDetails toCategoryDetails(CategoryDetailsDto categoryDetailsDto){
        CategoryDetails categoryDetails=new CategoryDetails();
        categoryDetails.setName(categoryDetailsDto.getName());
        categoryDetails.setCategoryList(categoryService.findAll(categoryDetailsDto.getCategoryList()));
        categoryDetails.setId(categoryDetailsDto.getId());
        return categoryDetails;
    }

    public static CategoryDetailsDto toDto(CategoryDetails categoryDetails){
        CategoryDetailsDto categoryDetailsDto=new CategoryDetailsDto();
        categoryDetailsDto.setId(categoryDetails.getId());
        categoryDetailsDto.setName(categoryDetails.getName());
        Ids=new ArrayList<>();
        for(Category category: categoryDetails.getCategoryList()){
            Ids.add(category.getId());
        }
        categoryDetailsDto.setCategoryList(Ids);
        return categoryDetailsDto;
    }

}