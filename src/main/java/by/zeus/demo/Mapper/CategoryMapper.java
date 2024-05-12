package by.zeus.demo.Mapper;

import by.zeus.demo.dto.CategoryDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.Product;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.Set;


@Mapper
public class CategoryMapper {
    private static Set<Long> product_Id;



    public static Category toCategory(CategoryDto categoryDto,Category parentCategorys){
        Category category=new Category();
        category.setId(categoryDto.getId());
        category.setVersion(categoryDto.getVersion());
        category.setCategoryName(categoryDto.getCategoryName());
        Category parentCategory=parentCategorys;
        category.setParent(parentCategory);
        return category;
    }


    public static CategoryDto toDto(Category category){
        product_Id=new HashSet<>();
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setId(category.getId());
        if(category.getParent()!=null&&category.getParent().getId()!=null){
            categoryDto.setParent_id(category.getParent().getId());

        }else{
            categoryDto.setParent_id(null);
        }
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setVersion(category.getVersion());
        for(Product product: category.getProductSet()){
            product_Id.add(product.getId());
        }
        categoryDto.setProduct_Id(product_Id);

        return categoryDto;
    }


}
