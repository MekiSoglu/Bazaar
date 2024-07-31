package by.zeus.demo.payment.creditcard.web.rest;

import by.zeus.demo.base.web.rest.BaseResource;
import by.zeus.demo.payment.creditcard.facade.StateFacade;
import by.zeus.demo.payment.creditcard.web.dto.StateDto;
import by.zeus.demo.payment.creditcard.domain.State;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/state")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )
public class StateController extends BaseResource<StateDto,State> {

    public StateController(final StateFacade facade) {
        super(facade);
    }

    @Override
    public Class<?> getLoggerClass() {
        return this.getClass();
    }
}
