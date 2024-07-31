package by.zeus.demo.media.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.media.domain.MediaEntity;
import by.zeus.demo.media.repository.MediaRepository;
import org.springframework.stereotype.Service;

@Service
public class MediaService extends BaseService<MediaEntity> {

    public MediaService(final BaseRepository<MediaEntity> repository) {
        super(repository);
    }


    @Override
    public MediaRepository getRepository() {
        return (MediaRepository) super.getRepository();
    }
}
