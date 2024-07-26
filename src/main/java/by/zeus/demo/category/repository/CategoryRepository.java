package by.zeus.demo.dao;

import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.CategoryDetails;
import by.zeus.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin ( "http://localhost:4200" )
public interface CategoryRepository extends BaseRepository<Category>{

    @Query("SELECT c FROM Category c WHERE c.id IN (:Ids)")
    List<Category> findCategoriesBy(List<Long> Ids);

    Category findCategoryByProductSet(List<Product> productList);
    @Query("SELECT c.categoryDetailsList FROM Category c WHERE c.id = :id")
    List<CategoryDetails> findCategoryDetailsByCategoryId(Long id);

}
