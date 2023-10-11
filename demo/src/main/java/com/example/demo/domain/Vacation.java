package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Vacations")
public class Vacation {

    @Id
    Long id;
    String vacation_title;
    String description;
    BigDecimal travel_price;
    String image_URL;
    Date create_date;
    Date last_update;

    @OneToMany(mappedBy="vacations")
    Set<Excursion> excursions = new HashSet<Excursion>();

    public Vacation() {
    }

    public Vacation(Long id, String vacation_title, String description, BigDecimal travel_price, String image_URL, Date create_date, Date last_update) {
        this.id = id;
        this.vacation_title = vacation_title;
        this.description = description;
        this.travel_price = travel_price;
        //set scale and rounding
        this.travel_price.setScale(2, RoundingMode.HALF_UP);
        this.image_URL = image_URL;
        this.create_date = create_date;
        this.last_update = last_update;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVacation_title() {
        return vacation_title;
    }

    public void setVacation_title(String vacation_title) {
        this.vacation_title = vacation_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTravel_price() {
        return travel_price;
    }

    public void setTravel_price(BigDecimal travel_price) {
        this.travel_price = travel_price;
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
        Vacation vacation = (Vacation) o;
        return Objects.equals(id, vacation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
