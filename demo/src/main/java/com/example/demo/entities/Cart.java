package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="carts")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name="package_price")
    private BigDecimal packagePrice;

    @Column(name="part_size")
    private int partySize;

    @Column(name="status")
    private StatusType status;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;

    public Cart() {
    }

    public void add(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }
}
