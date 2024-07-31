package by.zeus.demo.category.web.rest;

import by.zeus.demo.base.web.rest.BaseResource;
import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.category.facade.CategoryDetailsFacade;
import by.zeus.demo.category.web.dto.CategoryDetailsDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/catDetails")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )

public class CategoryDetailsController extends BaseResource<CategoryDetailsDto,CategoryDetails> {


    public CategoryDetailsController(final CategoryDetailsFacade facade) {
        super(facade);
    }

    @Override
    public Class<?> getLoggerClass() {
        return this.getClass();
    }
}
