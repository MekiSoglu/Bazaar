package by.zeus.demo.category.web.mapper;

import by.zeus.demo.category.web.dto.CategoryDetailsDto;
import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.category.service.CategoryService;
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
        categoryDetailsDto.setId(categoryDetailsDto.getId());
        categoryDetailsDto.setName(categoryDetailsDto.getName());
        Ids=new ArrayList<>();
        for(Long id: categoryDetailsDto.getCategoryList()){
            Ids.add(id);
        }
        categoryDetailsDto.setCategoryList(Ids);
        return categoryDetailsDto;
    }

}
