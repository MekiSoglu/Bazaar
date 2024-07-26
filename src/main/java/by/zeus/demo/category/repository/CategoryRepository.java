package by.zeus.demo.category.repository;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.category.domain.Category;
import by.zeus.demo.product.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin ( "http://localhost:4200" )
public interface CategoryRepository extends BaseRepository<Category> {

    @Query("SELECT c FROM Category c WHERE c.id IN (:Ids)")
    List<Category> findCategoriesBy(List<Long> Ids);

    Category findCategoryByProductSet(List<Product> productList);

}
