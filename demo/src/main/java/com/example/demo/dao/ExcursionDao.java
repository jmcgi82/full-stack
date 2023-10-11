package com.example.demo.dao;

import com.example.demo.domain.CartItem;
import com.example.demo.domain.Excursion;
import com.example.demo.domain.Vacation;

import java.util.Set;

public interface ExcursionDao {

    Excursion getExcursionById(Long id);
    Set<Excursion> getAllExcursions();
    Excursion addExcursion(Excursion excursion);
    void updateExcursion(Excursion excursion);
    void deleteExcursionById(Long id);

    Vacation getVacationForExcursion(Excursion excursion);
    Set<CartItem> getCartItemsForExcursion(Excursion excursion);
}
