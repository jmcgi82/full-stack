package com.example.demo.service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.PurchaseData;
import com.example.demo.dto.PurchaseResponseData;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImp implements CheckoutService {

    @Override
    @Transactional
    public PurchaseResponseData placeOrder(PurchaseData purchase) {

        String orderTrackingNumber = generateOrderTrackingNumber();

        PurchaseResponseData data = new PurchaseResponseData();
        data.setOrderTrackingNumber(orderTrackingNumber);

        return data;
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
