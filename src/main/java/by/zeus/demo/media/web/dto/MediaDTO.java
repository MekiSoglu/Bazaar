package by.zeus.demo.media.web.dto;
import by.zeus.demo.media.enumaration.MediaContentType;
import java.time.ZonedDateTime;

public class MediaDTO {

    private String fileName;

    private String url;

    private Long size;

    private String description;

    private ZonedDateTime uploadDate;

    private Long uploadedByUserId;

    private MediaContentType contentType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(final Long size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public ZonedDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(final ZonedDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Long getUploadedByUserId() {
        return uploadedByUserId;
    }

    public void setUploadedByUserId(final Long uploadedByUserId) {
        this.uploadedByUserId = uploadedByUserId;
    }

    public MediaContentType getContentType() {
        return contentType;
    }

    public void setContentType(final MediaContentType contentType) {
        this.contentType = contentType;
    }
}
