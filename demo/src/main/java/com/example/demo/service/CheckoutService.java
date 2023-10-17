package com.example.demo.service;

import com.example.demo.dto.PurchaseData;
import com.example.demo.dto.PurchaseResponseData;

public interface CheckoutService {

    PurchaseResponseData placeOrder(PurchaseData purchase);
}
