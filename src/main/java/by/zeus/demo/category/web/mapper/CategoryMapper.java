package by.zeus.demo.category.web.mapper;

import by.zeus.demo.category.web.dto.CategoryDto;
import by.zeus.demo.category.domain.Category;
import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.product.domain.Product;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Mapper
public class CategoryMapper {
    private static Set<Long> product_Id;
    private static List<Long> categoryDetaislId;



    public static Category toCategory(CategoryDto categoryDto, Category parentCategorys, List<CategoryDetails> categoryDetails){
        Category category=new Category();
        category.setId(categoryDto.getId());
        category.setVersion(categoryDto.getVersion());
        category.setCategoryName(categoryDto.getCategoryName());
        Category parentCategory=parentCategorys;
        category.setParent(parentCategory);
        category.setCategoryDetailsList(categoryDetails);
        return category;
    }


    public static CategoryDto toDto(Category category){
        product_Id=new HashSet<>();
        categoryDetaislId=new ArrayList<>();
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setId(category.getId());
        if(category.getParent()!=null&&category.getParent().getId()!=null){
            categoryDto.setParent_id(category.getParent().getId());

        }else{
            categoryDto.setParent_id(null);
        }
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setVersion(category.getVersion());
        for(CategoryDetails categoryDetails:category.getCategoryDetailsList()){
            categoryDetaislId.add(categoryDetails.getId());
        }
        for(Product product: category.getProductSet()){
            product_Id.add(product.getId());
        }
        categoryDto.setProduct_Id(product_Id);
        categoryDto.setCategoryDetailsId(categoryDetaislId);

        return categoryDto;
    }


}
