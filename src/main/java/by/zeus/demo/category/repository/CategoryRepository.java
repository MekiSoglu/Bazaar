package by.zeus.demo.category.repository;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.category.domain.CategoryEntity;
import by.zeus.demo.category.domain.CategoryDetailsEntity;
import by.zeus.demo.product.domain.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin ( "http://localhost:4200" )
public interface CategoryRepository extends BaseRepository<CategoryEntity> {

    @Query("SELECT c FROM CategoryEntity c WHERE c.id IN (:Ids)")
    List<CategoryEntity> findCategoriesBy(List<Long> Ids);

    CategoryEntity findCategoryByProductSet(List<ProductEntity> productEntityList);

    @Query("SELECT c.categoryDetailsEntityList FROM CategoryEntity c WHERE c.id = :id")
    List<CategoryDetailsEntity> findCategoryDetailsByCategoryId(Long id);

}
