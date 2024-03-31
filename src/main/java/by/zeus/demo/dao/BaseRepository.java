package by.zeus.demo.dao;

import by.zeus.demo.entity.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Set;

@NoRepositoryBean
public interface BaseRepository <T extends BaseEntity> extends SolidRepository<T,Long>{
    Set<T> findAllByIdIn(Set<Long> ids);

}
