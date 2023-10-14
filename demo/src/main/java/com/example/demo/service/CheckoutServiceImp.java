package com.example.demo.service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Vacation;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImp implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImp(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    @Override
    @Transactional
    public PurchaseResponseData placeOrder(PurchaseData purchase) {

        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();

        Set<CartItem> cartItems = purchase.getCartItems();
        cart.setCartItems(cartItems);

        Customer customer = cart.getCustomer();

        String phone = customer.getPhone();
        Customer customerFromDB = customerRepository.findByPhone(phone);

        if (customerFromDB != null) {
            customer = customerFromDB;
        }

        customer.getCarts().add(cart);

        customerRepository.save(customer);

        PurchaseResponseData data = new PurchaseResponseData();
        data.setOrderTrackingNumber(orderTrackingNumber);

        return data;
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
