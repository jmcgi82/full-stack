package com.example.demo.dao;

import com.example.demo.domain.Cart;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Division;

import java.util.Set;

public interface CustomerDao {

    Customer getCustomerById(Long id);
    Set<Customer> getAllCustomers();
    Customer addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);

    Division getDivisionForCustomer(Customer customer);
    Set<Cart> getCartForCustomer(Customer customer);
}
