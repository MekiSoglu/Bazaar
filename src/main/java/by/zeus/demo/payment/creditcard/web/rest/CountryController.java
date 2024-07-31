package by.zeus.demo.payment.creditcard.web.rest;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.base.web.rest.BaseResource;
import by.zeus.demo.payment.creditcard.domain.Country;
import by.zeus.demo.payment.creditcard.facade.CountryFacade;
import by.zeus.demo.payment.creditcard.service.CountryService;
import by.zeus.demo.payment.creditcard.web.dto.CountryDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )
public class CountryController extends BaseResource<CountryDTO,Country> {


    public CountryController(final CountryFacade facade) {
        super(facade);
    }

    @Override
    public Class<?> getLoggerClass() {
        return this.getClass();
    }
}
