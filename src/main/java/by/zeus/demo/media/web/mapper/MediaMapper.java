package by.zeus.demo.media.web.mapper;

import by.zeus.demo.media.domain.MediaEntity;
import by.zeus.demo.media.web.dto.MediaDTO;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MediaMapper {


    public static MediaEntity toEntity(MediaDTO mediaDTO){
        MediaEntity media=new MediaEntity();
        media.setDescription(mediaDTO.getDescription());
        //media.setAdminEntity();
        media.setSize(mediaDTO.getSize());
        media.setUrl(mediaDTO.getUrl());
        media.setFileName(mediaDTO.getFileName());
        media.setContentType(mediaDTO.getContentType());
        media.setUploadedByUserId(mediaDTO.getUploadedByUserId());
        media.setUploadDate(mediaDTO.getUploadDate());
        return media;
    }

    public static MediaDTO toDto(MediaEntity media){
        MediaDTO mediaDTO=new MediaDTO();
        mediaDTO.setContentType(media.getContentType());
        mediaDTO.setSize(media.getSize());
        mediaDTO.setUrl(media.getUrl());
        mediaDTO.setUploadDate(media.getUploadDate());
        mediaDTO.setUploadedByUserId(media.getUploadedByUserId());
        mediaDTO.setSize(media.getSize());
        mediaDTO.setUploadedByUserId(media.getUploadedByUserId());
        return mediaDTO;
    }
}
