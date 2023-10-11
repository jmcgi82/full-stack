package com.example.demo.dao;

import com.example.demo.domain.Country;
import com.example.demo.domain.Division;

import java.util.Set;

public interface DivisionDao {

    Division getDivisionById(Long id);
    Set<Division> getAllDivisions();
    Division addDivision(Division division);
    void updateDivision(Division division);
    void deleteDivisionById(Long id);

    Long getCountryIdForDivision(Division division);
    Country getCountryForDivision(Division division);
}
