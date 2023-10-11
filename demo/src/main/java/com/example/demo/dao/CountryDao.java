package com.example.demo.dao;

import com.example.demo.domain.Country;
import com.example.demo.domain.Division;

import java.util.Set;

public interface CountryDao {

    Country getCountryById(Long id);
    Set<Country> getAllCountries();
    Country addCountry(Country country);
    void updateCountry(Country country);
    void deleteCountryById(Long id);

    Set<Division> getDivisionForCountry(Country country);
}
