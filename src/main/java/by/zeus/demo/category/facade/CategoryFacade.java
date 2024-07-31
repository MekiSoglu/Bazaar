package by.zeus.demo.category.facade;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.category.domain.Category;
import by.zeus.demo.category.service.CategoryService;
import by.zeus.demo.category.web.dto.CategoryDto;
import by.zeus.demo.category.web.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryFacade extends BaseFacade<CategoryDto, Category> {
    public CategoryFacade(final CategoryService service,
                          final CategoryMapper mapper) {
        super(service, mapper);
    }

    @Override
    public Class<CategoryDto> getDtoClass() {
        return CategoryDto.class;
    }
}
