package by.zeus.demo.payment.creditcard.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.payment.creditcard.domain.Country;
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
