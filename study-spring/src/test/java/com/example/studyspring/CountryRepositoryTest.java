package com.example.studyspring;

import com.example.studyspring.country.Country;
import com.example.studyspring.country.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CountryRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void testSave() {
        List<Country> countries = List.of(
                Country.builder().name("Brasil").build()
        );
        countries.forEach(c -> testEntityManager.persist(c));

        Country country = countryRepository.findById(1L).get();
        assertEquals(1L, country.getId());

    }

    @Test
    void findByNameStartingWith() {
        List<Country> countries = List.of(
                Country.builder().name("Argentina").build(),
                Country.builder().name("Alemanha").build(),
                Country.builder().name("Equador").build()
        );
        countries.forEach(c -> testEntityManager.persist(c));

        List<Country> countriesFromDatabase = countryRepository.findByNameStartingWith("A");
        assertEquals(2, countriesFromDatabase.size());

    }

}
