package by.zeus.demo.payment.creditcard.web.rest;

import by.zeus.demo.payment.creditcard.service.StateService;
import by.zeus.demo.payment.creditcard.web.dto.StateDto;
import by.zeus.demo.payment.creditcard.domain.State;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )
public class StateController {
    private final StateService service;

    public StateController(StateService service) {
        this.service = service;
    }

    @GetMapping
    public List<State> getAllStates() {
        return service.getAllState();
    }

    @GetMapping("/{countryId}")
    public List<State>getAllStates(@PathVariable Long countryId){
      return   service.getAllState(countryId);
    }

    @GetMapping("/code/{countryCode}")
    public List<State>getAllStates(@PathVariable String countryCode){
        return   service.getAllState(countryCode);
    }
    @PostMapping
    public State create(@RequestBody StateDto stateDto){
        return service.createState(stateDto);
    }
}
