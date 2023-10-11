package com.example.demo.dao;

import com.example.demo.domain.Excursion;
import com.example.demo.domain.Vacation;

import java.util.Set;

public interface VacationDao {

    Vacation getVacationById(Long id);
    Set<Vacation> getAllVacations();
    Vacation addVacation(Vacation vacation);
    void updateVacation(Vacation vacation);
    void deleteVacationById(Long id);

    Set<Excursion> getExcursionsForVacation(Vacation vacation);
}
