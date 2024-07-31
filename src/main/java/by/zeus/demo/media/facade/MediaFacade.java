package by.zeus.demo.media.facade;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.media.domain.MediaEntity;
import by.zeus.demo.media.service.MediaService;
import by.zeus.demo.media.web.dto.MediaDTO;
import by.zeus.demo.media.web.mapper.MediaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MediaFacade extends BaseFacade<MediaDTO, MediaEntity> {
    public MediaFacade(final MediaService service,
                       final MediaMapper mapper) {
        super(service, mapper);
    }

    @Override
    public Class<MediaDTO> getDtoClass() {
        return MediaDTO.class;
    }
}
