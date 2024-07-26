package by.zeus.demo.service;

import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService extends BaseService<Country> {
    public CountryService(BaseRepository<Country> repository) {
        super(repository);
    }
    public List<Country> getAllCountry() {
      return findAll();
    }

    public Country createCountry(Country country){
        create(country);
        return country;
    }
}
