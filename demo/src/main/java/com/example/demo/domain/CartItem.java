package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="CartItems")
public class CartItem {


    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    Cart cart;
    Date create_date;
    Date last_update;


    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false)
    Vacation vacation;

    @ManyToMany(mappedBy="cartitems")
    Set<Excursion> excursions = new HashSet<Excursion>();

    public CartItem() {
    }

    public CartItem(Long id, Cart cart, Date create_date, Date last_update, Vacation vacation) {
        this.id = id;
        this.cart = cart;
        this.create_date = create_date;
        this.last_update = last_update;
        this.vacation = vacation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public Set<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(id, cartItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
