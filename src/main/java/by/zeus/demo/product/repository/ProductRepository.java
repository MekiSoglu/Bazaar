package by.zeus.demo.product.repository;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.product.domain.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin ( "http://localhost:4200" )
public interface ProductRepository extends BaseRepository<Product> {
    List<Product> findByCategoryId(@Param("id") Long id);

    List<Product> findByNameContaining(@Param("name") String name);
}
