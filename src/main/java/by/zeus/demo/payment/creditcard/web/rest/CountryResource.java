package by.zeus.demo.payment.creditcard.web.rest;

import by.zeus.demo.base.web.rest.BaseResource;
import by.zeus.demo.payment.creditcard.domain.CountryEntity;
import by.zeus.demo.payment.creditcard.facade.CountryFacade;
import by.zeus.demo.payment.creditcard.web.dto.CountryDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )
public class CountryResource extends BaseResource<CountryDTO, CountryEntity> {


    public CountryResource(final CountryFacade facade) {
        super(facade);
    }

    @Override
    public Class<?> getLoggerClass() {
        return this.getClass();
    }
}
