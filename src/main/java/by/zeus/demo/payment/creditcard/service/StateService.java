package by.zeus.demo.payment.creditcard.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.payment.creditcard.domain.StateEntity;
import by.zeus.demo.payment.creditcard.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StateService extends BaseService<StateEntity> {
    private final CountryService  countryService;
    private final StateRepository stateRepository;
    public StateService(BaseRepository<StateEntity> repository, CountryService countryService, StateRepository stateRepository) {
        super(repository);
        this.countryService = countryService;
        this.stateRepository = stateRepository;
    }
    public List<StateEntity> getAllState() {
        return   getAllState();
    }

    public List<StateEntity> getAllState(Long countryId){
        return stateRepository.findByCountryEntity_Id(countryId);
    }

    public List<StateEntity> getAllState(String code){
        return stateRepository.findByCountryEntity_Code(code);
    }
    /*
    public State createState(StateDto stateDto){
        State state=new State();
        state.setName(stateDto.getName());
        Country country=countryService.getOne(stateDto.getId()).get();
        state.setCountry(country);
        create(state);
        return state;
    }

     */
}
