package com.example.demo.controller;

import com.example.demo.service.CheckoutService;
import com.example.demo.service.PurchaseData;
import com.example.demo.service.PurchaseResponseData;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {this.checkoutService = checkoutService; }

    @PostMapping ("/purchase")
    public PurchaseResponseData placeOrder(@RequestBody PurchaseData purchaseDto) {
        PurchaseResponseData purchaseResponse = checkoutService.placeOrder(purchaseDto);

        return purchaseResponse;
    }
}
