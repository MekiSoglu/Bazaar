package by.zeus.demo.media.web.rest;

import by.zeus.demo.base.facade.BaseFacade;
import by.zeus.demo.base.web.rest.BaseResource;
import by.zeus.demo.media.domain.MediaEntity;
import by.zeus.demo.media.facade.MediaFacade;
import by.zeus.demo.media.web.dto.MediaDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/media")
@CrossOrigin( {"http://localhost:4401", "http://localhost:4200"} )
public class MediaResource extends BaseResource<MediaDTO, MediaEntity> {
    public MediaResource(final MediaFacade facade) {
        super(facade);
    }

    @Override
    public Class<?> getLoggerClass() {
        return this.getClass();
    }
}
