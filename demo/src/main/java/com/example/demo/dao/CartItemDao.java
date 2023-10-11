package com.example.demo.dao;

import com.example.demo.domain.CartItem;
import com.example.demo.domain.Excursion;
import com.example.demo.domain.Vacation;

import java.util.Set;

public interface CartItemDao {

    CartItem getCartItemById(Long id);
    Set<CartItem> getAllCartItems();
    CartItem addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void deleteCartItemById(Long id);

    Vacation getVacationForCartItem();
    Set<Excursion> getExcursionsForCartItem(CartItem cartItem);
}
