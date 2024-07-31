package by.zeus.demo.payment.creditcard.facade;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.base.web.mapper.BaseMapper;
import by.zeus.demo.payment.creditcard.domain.Country;
import by.zeus.demo.payment.creditcard.web.dto.CountryDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryFacade extends BaseFacade<CountryDTO, Country> {
    public CountryFacade(final BaseService<Country> service, final BaseMapper<CountryDTO, Country> mapper) {
        super(service, mapper);
    }

    @Override
    public Class<CountryDTO> getDtoClass() {
        return CountryDTO.class;
    }
}
