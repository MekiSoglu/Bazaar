package by.zeus.demo.service;

import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class BaseService <E extends BaseEntity>{

    private final BaseRepository <E> repository;

    private final Logger logger= LoggerFactory.getLogger(BaseService.class);

    public BaseService(BaseRepository<E> repository) {
        this.repository=repository;
    }

    @Cacheable
    public Optional<E> findOne(Long id){
        return repository.findById(id);
    }

    @CacheEvict
    public E create(E model){
        if(model.getId()==null){
        }
        logger.debug("Request to save",getEntityClassName());
        return repository.save(model);
    }

    @CacheEvict
    public E Update(E model){
        if(model.getId()==null){

        }
        logger.debug("Request to update",getEntityClassName());
        return repository.save(model);
    }

    public List<E> findAll(){
        return repository.findAll();
    }

    @Transactional
    @CacheEvict
    public void delete(Long id){
        logger.debug("Request to delete",getEntityClassName(),id);
        repository.deleteById(id);
    }

    public  BaseRepository<E> getRepository(){
        return repository;
    }
    public String getEntityClassName(){
        return getRepository().GetDomainClass().getName();
    }
}
