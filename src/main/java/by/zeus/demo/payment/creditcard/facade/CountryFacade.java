package by.zeus.demo.payment.creditcard.facade;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.base.web.mapper.BaseMapper;
import by.zeus.demo.payment.creditcard.domain.CountryEntity;
import by.zeus.demo.payment.creditcard.web.dto.CountryDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryFacade extends BaseFacade<CountryDTO, CountryEntity> {
    public CountryFacade(final BaseService<CountryEntity> service, final BaseMapper<CountryDTO, CountryEntity> mapper) {
        super(service, mapper);
    }

    @Override
    public Class<CountryDTO> getDtoClass() {
        return CountryDTO.class;
    }
}
