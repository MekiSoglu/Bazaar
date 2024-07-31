package by.zeus.demo.category.facade;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.category.service.CategoryDetailsService;
import by.zeus.demo.category.web.dto.CategoryDetailsDto;
import by.zeus.demo.category.web.mapper.CategoryDetailsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryDetailsFacade extends BaseFacade<CategoryDetailsDto, CategoryDetails> {
    public CategoryDetailsFacade(final CategoryDetailsService service,
                                 final CategoryDetailsMapper mapper) {
        super(service, mapper);
    }

    @Override
    public Class<CategoryDetailsDto> getDtoClass() {
        return CategoryDetailsDto.class;
    }
}
