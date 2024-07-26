package by.zeus.demo.base.repository;

import by.zeus.demo.base.domain.BaseEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface SolidRepository <T extends BaseEntity,ID> extends JpaRepository<T,ID> {
    @Override
    <S extends T> Optional<S> findOne(Example<S> example);
    default Class<T> GetDomainClass(){
        return (Class<T>) BaseEntity.class;
    }
}
