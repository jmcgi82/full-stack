package com.example.demo.service;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CheckoutServiceImp implements CheckoutService {

    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

    private final CustomerRepository customerRepository;

    public CheckoutServiceImp(CartRepository cartRepository, CartItemRepository cartItemRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.customerRepository = customerRepository;
    }

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

        } catch (Exception e) {
            PurchaseResponseData p2 = new PurchaseResponseData();
            p2.setOrderTrackingNumber("PURCHASE UNSUCCESSFUl!");
            return p2;
        }


        //get cart object
        Cart cart = purchase.getCart();
        cart.setCart_items(purchase.getCartItems());

        //generate order tracking number and update properties
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrder_tracking_number(orderTrackingNumber);
        cart.setId(this.cartRepository.count() + 1);
        cart.setStatus(StatusType.ordered);

        //get all cart items
        Set<CartItem> cartitems = cart.getCart_items();
        cartitems.forEach(cart::add);

        //get the current customer
        Customer customer = purchase.getCart().getCustomer();

        //get customers current carts
        Set<Cart> tempCarts = customer.getCarts();

        //check if customer has any carts, and add our new cart to temp carts
        if (tempCarts != null) {
            tempCarts.add(cart);
        } else {
            tempCarts = new HashSet<Cart>();
            tempCarts.add(cart);
        }

        //set customer carts
        customer.setCarts(tempCarts);

        List<CartItem> tempItems = new ArrayList<CartItem>(cart.getCart_items());
        //update cart item fields
        Long index = 1L;
        Long id = cartItemRepository.count() + 1;
        for (CartItem ci: cartitems) {
            ci.setCart(cart);

        }

        this.cartRepository.save(cart);
        this.cartItemRepository.saveAll(cartitems);

        PurchaseResponseData response = new PurchaseResponseData();
        response.setOrderTrackingNumber(orderTrackingNumber);

        return response;
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
