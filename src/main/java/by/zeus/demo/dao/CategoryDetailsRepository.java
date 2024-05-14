package by.zeus.demo.dao;

import by.zeus.demo.entity.CategoryDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin( "http://localhost:4200" )
public interface CategoryDetailsRepository extends BaseRepository<CategoryDetails>{

    @Query("SELECT c FROM CategoryDetails c WHERE c.id IN (:Ids)")

    List<CategoryDetails> findCategoryDetailsBy(List<Long> Ids);

}
