package by.zeus.demo.login.admin.domain;

import by.zeus.demo.base.domain.BaseEntity;
import by.zeus.demo.media.domain.MediaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class AdminEntity extends BaseEntity {
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "profile_image_id", updatable = false, insertable = false)
    private MediaEntity profileImage;
}
