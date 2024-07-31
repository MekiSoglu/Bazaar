package by.zeus.demo.category.web.rest;

import by.zeus.demo.base.web.rest.BaseResource;
import by.zeus.demo.category.domain.Category;
import by.zeus.demo.category.facade.CategoryFacade;
import by.zeus.demo.category.web.dto.CategoryDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin( {"http://localhost:4401", "http://localhost:4200"} )

public class CategoryController extends BaseResource<CategoryDto,Category> {

    public CategoryController(final CategoryFacade facade) {
        super(facade);
    }

    @Override
    public Class<?> getLoggerClass() {
        return this.getClass();
    }
    @Override
    public CategoryFacade getFacade() {
        return (CategoryFacade) super.getFacade();
    }
}
