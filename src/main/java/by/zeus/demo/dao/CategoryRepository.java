package by.zeus.demo.dao;

import by.zeus.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin ( "http://localhost:4200" )
public interface CategoryRepository extends BaseRepository<Category>{
}
