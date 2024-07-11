package by.zeus.demo.controller;

import by.zeus.demo.entity.Country;
import by.zeus.demo.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountryList() {
        return countryService.getAllCountry();
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

}
