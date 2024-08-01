package by.zeus.demo.payment.creditcard.repository;


import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.payment.creditcard.domain.StateEntity;

import java.util.List;

public interface StateRepository extends BaseRepository<StateEntity> {
    List<StateEntity> findByCountryEntity_Id(Long countryId);
    List<StateEntity> findByCountryEntity_Code(String countryCode);
}
