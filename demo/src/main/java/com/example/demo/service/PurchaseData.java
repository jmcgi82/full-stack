package com.example.demo.service;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import lombok.Data;

import java.util.Set;

@Data
public class PurchaseData {

    private Cart cart;

    private Set<CartItem> cartItems;

    public PurchaseData() {}

}
