package com.SoulCode.Services.Models;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    private Integer idAddress;

    @Column(nullable = true, length=100, unique = false)
    private String road;

    @Column(nullable = true, length=50, unique = false)
    private String district;

    @Column(nullable = true, length=50, unique = false)
    private String city;

    @Column(nullable = true, length=50, unique = false)
    private String state;






    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
