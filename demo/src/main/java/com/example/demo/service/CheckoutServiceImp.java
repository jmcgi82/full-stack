package com.example.demo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@Service
public class CheckoutServiceImp implements CheckoutService {

    @Override
    @Transactional
    public PurchaseResponseData placeOrder(PurchaseData purchase) {

        //validate order input
        try {
            //ensure there is at least one item in the cart
            BigDecimal testPrice = new BigDecimal(0);

            if (purchase.getCart().getPackage_price().equals(testPrice)) {
                throw new Exception();
            }

            //ensure there is a customer selected for the purchase
            if (purchase.getCart().getCustomer() == null) {throw new Exception();}
        } catch (Exception e) {
            PurchaseResponseData p2 = new PurchaseResponseData();
            p2.setOrderTrackingNumber("PURCHASE UNSUCCESSFUl!");
            return p2;
        }

        String orderTrackingNumber = generateOrderTrackingNumber();

        PurchaseResponseData data = new PurchaseResponseData();
        data.setOrderTrackingNumber(orderTrackingNumber);

        return data;
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
