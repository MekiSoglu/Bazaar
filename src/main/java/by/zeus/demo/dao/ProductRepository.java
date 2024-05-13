package by.zeus.demo.dao;

import by.zeus.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin ( "http://localhost:4200" )
public interface ProductRepository extends BaseRepository<Product> {
    List<Product> findByCategoryId(@Param("id") Long id);

    List<Product> findByNameContaining(@Param("name") String name);
}
