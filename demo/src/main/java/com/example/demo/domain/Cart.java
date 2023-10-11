package com.example.demo.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Carts")
public class Cart {

    @Id
    Long id;
    String orderTrackingNumber;
    BigDecimal package_price;
    int part_size;
    StatusType Status;
    Date create_date;
    Date last_update;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    Customer customer;

    @OneToMany(mappedBy="cartitem")
    Set<CartItem> cartItem = new HashSet<CartItem>();

    public Cart() {
    }

    public Cart(Long id, String orderTrackingNumber, BigDecimal package_price, int part_size, StatusType status, Date create_date, Date last_update, Customer customer) {
        this.id = id;
        this.orderTrackingNumber = orderTrackingNumber;
        this.package_price = package_price;
        //set scale and rounding
        this.package_price.setScale(2, RoundingMode.HALF_UP);
        this.part_size = part_size;
        Status = status;
        this.create_date = create_date;
        this.last_update = last_update;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public BigDecimal getPackage_price() {
        return package_price;
    }

    public void setPackage_price(BigDecimal package_price) {
        this.package_price = package_price;
    }

    public int getPart_size() {
        return part_size;
    }

    public void setPart_size(int part_size) {
        this.part_size = part_size;
    }

    public StatusType getStatus() {
        return Status;
    }

    public void setStatus(StatusType status) {
        Status = status;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
