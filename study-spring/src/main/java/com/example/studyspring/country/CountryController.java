package com.example.studyspring.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        return new ResponseEntity<Country>(countryRepository.save(country),
                HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable(value = "id") Long id) {
       countryRepository.deleteById(id);

       return ResponseEntity.noContent().build();


    }
    @GetMapping(path = "/name")
    public ResponseEntity<Country> findByName(@RequestParam(name = "countryName") String name) {
        return new ResponseEntity<Country>(countryRepository.findByName(name), HttpStatus.OK);
    }
}
