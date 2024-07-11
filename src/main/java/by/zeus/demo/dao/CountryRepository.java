package by.zeus.demo.dao;

import by.zeus.demo.entity.Country;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin( "http://localhost:4200" )
public interface CountryRepository extends BaseRepository<Country> {

}
