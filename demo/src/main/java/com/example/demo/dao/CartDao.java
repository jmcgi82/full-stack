package com.example.demo.dao;

import com.example.demo.domain.Cart;
import com.example.demo.domain.CartItem;
import com.example.demo.domain.Customer;

import java.util.List;
import java.util.Set;

public interface CartDao {

    Cart getCartById(Long id);
    Set<Cart> getAllCarts();
    Cart addCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCartById(Long id);

    Set<CartItem> getCartItemsForCart(Cart cart);
    Customer getCustomerForCart(Cart cart);
}
