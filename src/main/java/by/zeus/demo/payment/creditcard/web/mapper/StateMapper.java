package by.zeus.demo.payment.creditcard.web.mapper;

import by.zeus.demo.base.web.mapper.BaseMapper;
import by.zeus.demo.payment.creditcard.domain.StateEntity;
import by.zeus.demo.payment.creditcard.web.dto.StateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface StateMapper extends BaseMapper<StateDTO, StateEntity> {
}
