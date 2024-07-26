package by.zeus.demo.category.repository;

import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin( "http://localhost:4200" )
public interface CategoryDetailsRepository extends BaseRepository<CategoryDetails> {

    @Query("SELECT c FROM CategoryDetails c WHERE c.id IN (:Ids)")
    List<CategoryDetails> findCategoryDetailsBy(List<Long> Ids);

}
