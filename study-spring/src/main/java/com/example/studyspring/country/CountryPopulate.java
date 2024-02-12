package com.example.studyspring.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryPopulate implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Country> countries = List.of(
                Country.builder().name("Brasil").build(),
                Country.builder().name("Argentina").build()
        );
        countryRepository.saveAll(countries);

    }
}
