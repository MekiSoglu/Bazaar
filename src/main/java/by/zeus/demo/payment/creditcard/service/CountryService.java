package by.zeus.demo.payment.creditcard.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.payment.creditcard.domain.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService extends BaseService<CountryEntity> {
    public CountryService(BaseRepository<CountryEntity> repository) {
        super(repository);
    }
    public List<CountryEntity> getAllCountry() {
      return findAll();
    }

    public CountryEntity createCountry(CountryEntity countryEntity){
        create(countryEntity);
        return countryEntity;
    }
}
