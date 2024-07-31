package by.zeus.demo.payment.creditcard.web.mapper;

import by.zeus.demo.base.web.mapper.BaseMapper;
import by.zeus.demo.payment.creditcard.domain.Country;
import by.zeus.demo.payment.creditcard.web.dto.CountryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CountryMapper extends BaseMapper<CountryDTO, Country> {
}
