package by.zeus.demo.service;

import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dao.StateRepository;
import by.zeus.demo.dto.StateDto;
import by.zeus.demo.entity.Country;
import by.zeus.demo.entity.State;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StateService extends BaseService<State>{
    private final CountryService countryService;
    private final StateRepository stateRepository;
    public StateService(BaseRepository<State> repository, CountryService countryService, StateRepository stateRepository) {
        super(repository);
        this.countryService = countryService;
        this.stateRepository = stateRepository;
    }
    public List<State> getAllState() {
        return   getAllState();
    }

    public List<State> getAllState(Long countryId){
        return stateRepository.findByCountry_Id(countryId);
    }

    public List<State> getAllState(String code){
        return stateRepository.findByCountry_Code(code);
    }
    public State createState(StateDto stateDto){
        State state=new State();
        state.setName(stateDto.getName());
        Country country=countryService.getOne(stateDto.getId()).get();
        state.setCountry(country);
        create(state);
        return state;
    }
}
