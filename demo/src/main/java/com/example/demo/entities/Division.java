package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="divisions")
@Data
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="division_id")
    private Long id;

    @Column(name="division")
    private String divisionName;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(insertable = false, updatable = false, name="country_id")
    private Long countryId;

    @OneToMany(mappedBy = "division")
    private Set<Customer> customers;

    public Division() {
    }

    public void setCountry(Country country) { this.country = country; }

}
