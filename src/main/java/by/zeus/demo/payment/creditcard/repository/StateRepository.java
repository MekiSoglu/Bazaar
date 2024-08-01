package by.zeus.demo.payment.creditcard.repository;


import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.payment.creditcard.domain.StateEntity;

import java.util.List;

public interface StateRepository extends BaseRepository<StateEntity> {
    List<StateEntity> findByCountry_Id(Long countryId);
    List<StateEntity> findByCountry_Code(String countryCode);
}
