package by.zeus.demo.payment.creditcard.facade;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.payment.creditcard.domain.State;
import by.zeus.demo.payment.creditcard.service.StateService;
import by.zeus.demo.payment.creditcard.web.dto.StateDto;
import by.zeus.demo.payment.creditcard.web.mapper.StateMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StateFacade extends BaseFacade<StateDto, State> {
    public StateFacade(final StateService service, final StateMapper mapper) {
        super(service, mapper);
    }

    @Override
    public Class<StateDto> getDtoClass() {
        return StateDto.class;
    }
}
