package by.zeus.demo.media.web.mapper;

import by.zeus.demo.base.web.mapper.BaseMapper;
import by.zeus.demo.login.admin.service.AdminService;
import by.zeus.demo.media.domain.MediaEntity;
import by.zeus.demo.media.web.dto.MediaDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")

public interface MediaMapper  extends BaseMapper<MediaDTO,MediaEntity> {
    //deneme jenkisn

}
