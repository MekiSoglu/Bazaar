package by.zeus.demo.category.web.mapper;

import by.zeus.demo.base.web.mapper.BaseMapper;
import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.category.web.dto.CategoryDetailsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryDetailsMapper extends BaseMapper<CategoryDetailsDto, CategoryDetails> {

}
