package by.zeus.demo.category.web.mapper;

import by.zeus.demo.base.web.mapper.BaseMapper;
import by.zeus.demo.category.web.dto.CategoryDto;
import by.zeus.demo.category.domain.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<CategoryDto,Category> {

    //@Mapping(target = "productSet", conditionExpression = "java(entity.getProductSet())")
   // public abstract CategoryDto toDto(Category entity);



}
