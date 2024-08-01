package by.zeus.demo.payment.creditcard.repository;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.payment.creditcard.domain.CountryEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin( "http://localhost:4200" )
public interface CountryRepository extends BaseRepository<CountryEntity> {

}
