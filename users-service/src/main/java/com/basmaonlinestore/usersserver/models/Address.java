package com.basmaonlinestore.usersserver.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address", nullable = false)
    private Long idAddress;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private Integer postalCode;
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    public Address() {
    }
    public Address(String street, String city, Integer postalCode, Timestamp createdAt) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.createdAt = createdAt;
    }
    public Address(Long idAddress, String street, String city, Integer postalCode, Timestamp createdAt) {
        this.idAddress = idAddress;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.createdAt = createdAt;
    }
    public Long getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Integer getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", createdAt=" + createdAt +
                '}';
    }
}
