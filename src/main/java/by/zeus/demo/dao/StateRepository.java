package by.zeus.demo.dao;

import by.zeus.demo.entity.State;

import java.util.List;

public interface StateRepository extends BaseRepository<State>{
    List<State> findByCountry_Id(Long countryId);
    List<State> findByCountry_Code(String countryCode);
}
