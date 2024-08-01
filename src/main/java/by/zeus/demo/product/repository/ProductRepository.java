package by.zeus.demo.product.repository;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.product.domain.ProductEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin ( "http://localhost:4200" )
public interface ProductRepository extends BaseRepository<ProductEntity> {
    List<ProductEntity> findByCategoryId(@Param("id") Long id);

    List<ProductEntity> findByNameContaining(@Param("name") String name);
}
