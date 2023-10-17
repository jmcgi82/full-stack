package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @Column(name="create_date")
    private Date create_date;

    @Column(name="last_update")
    private Date last_update;

    @Column(name="vacation_id")
    private Long vacation_id;

    @OneToOne
    private Vacation vacation;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "cart_items")
    private Set<Excursion> excursions;

    public CartItem() {
    }

    public void add() {}

}
