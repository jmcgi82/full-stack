package com.example.demo.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name="excursions")
public class Excursion {

    @Id
    Long id;
    String excursion_title;
    BigDecimal excursion_price;
    String image_URL;
    Date create_date;
    Date last_update;

    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false)
    Vacation vacation;
    @ManyToMany
    @JoinTable(
            name="cartItem_excursions",
            joinColumns = @JoinColumn(name="cartitem_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    Set<CartItem> cartitems = new HashSet<CartItem>();

    public Excursion() {
    }

    public Excursion(Long id, String excursion_title, BigDecimal excursion_price, String image_URL, Date create_date, Date last_update, Vacation vacation) {
        this.id = id;
        this.excursion_title = excursion_title;
        this.excursion_price = excursion_price;
        //set scale and rounding
        this.excursion_price.setScale(2, RoundingMode.HALF_UP);
        this.image_URL = image_URL;
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

    public String getExcursion_title() {
        return excursion_title;
    }

    public void setExcursion_title(String excursion_title) {
        this.excursion_title = excursion_title;
    }

    public BigDecimal getExcursion_price() {
        return excursion_price;
    }

    public void setExcursion_price(BigDecimal excursion_price) {
        this.excursion_price = excursion_price;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
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

    public Set<CartItem> getCartitems() {
        return cartitems;
    }

    public void setCartitems(Set<CartItem> cartitems) {
        this.cartitems = cartitems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Excursion excursion = (Excursion) o;
        return Objects.equals(id, excursion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
