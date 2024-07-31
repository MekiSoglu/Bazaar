package by.zeus.demo.payment.creditcard.web.mapper;

import by.zeus.demo.base.web.mapper.BaseMapper;
import by.zeus.demo.payment.creditcard.domain.State;
import by.zeus.demo.payment.creditcard.web.dto.StateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface StateMapper extends BaseMapper<StateDto, State> {
}
