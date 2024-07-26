package by.zeus.demo.payment.creditcard.repository;


import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.payment.creditcard.domain.State;

import java.util.List;

public interface StateRepository extends BaseRepository<State> {
    List<State> findByCountry_Id(Long countryId);
    List<State> findByCountry_Code(String countryCode);
}
