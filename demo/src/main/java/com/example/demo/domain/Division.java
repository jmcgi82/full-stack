package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Divisions")
public class Division {

    @Id
    Long id;
    String division_name;
    Date create_date;
    Date last_update;

    @ManyToOne
    @JoinColumn(name="country_id", nullable=false)
    Country country;
    Long countryId;

    @OneToMany(mappedBy="division")
    Set<Customer> customers = new HashSet<Customer>();

    public Division() {
    }

    public Division(Long id, String division_name, Date create_date, Date last_update, Country country, Long countryId) {
        this.id = id;
        this.division_name = division_name;
        this.create_date = create_date;
        this.last_update = last_update;
        this.country = country;
        this.countryId = countryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDivision_name() {
        return division_name;
    }

    public void setDivision_name(String division_name) {
        this.division_name = division_name;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return Objects.equals(id, division.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
