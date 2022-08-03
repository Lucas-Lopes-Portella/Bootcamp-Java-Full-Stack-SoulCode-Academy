package com.SoulCode.Services.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Column(nullable = false, length=100)
    private String name;
    @Column(nullable = false, length=100, unique = true)
    private String email;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    // Relacionamento de um para muitos (linkado com Called)
    private List<Called> called = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddress", unique = true)
    private Address address;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Called> getCalled() {
        return called;
    }

    public void setCalled(List<Called> called) {
        this.called = called;
    }
}
