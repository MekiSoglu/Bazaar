package by.zeus.demo.media.domain;

import by.zeus.demo.base.domain.BaseEntity;
import by.zeus.demo.login.admin.domain.AdminEntity;
import by.zeus.demo.media.enumaration.MediaContentType;
import jakarta.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "media")
public class MediaEntity extends BaseEntity {

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "size", nullable = false)
    private Long size;

    @Column(name = "description")
    private String description;

    @Column(name = "upload_date", nullable = false)
    private ZonedDateTime uploadDate;

    @Column(name = "uploaded_by_user_id")
    private Long uploadedByUserId;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type", nullable = false)
    private MediaContentType contentType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploaded_by_user_id", updatable = false, insertable = false)
    private AdminEntity adminEntity;

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Long getUploadedByUserId() {
        return uploadedByUserId;
    }

    public void setUploadedByUserId(final Long uploadedByUserId) {
        this.uploadedByUserId = uploadedByUserId;
    }

    public AdminEntity getAdminEntity() {
        return adminEntity;
    }

    public void setAdminEntity(final AdminEntity adminEntity) {
        this.adminEntity = adminEntity;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public ZonedDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(ZonedDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public MediaContentType getContentType() {
        return contentType;
    }

    public void setContentType(MediaContentType contentType) {
        this.contentType = contentType;
    }
}
