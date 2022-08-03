package com.SoulCode.Services.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aspectj.weaver.ast.Call;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployee;

    @Column(nullable = false, length=100)
    private String name;

    @Column(nullable = false, length=100, unique = true)
    private String email;
    @Column(nullable = true)
    private String photo;

    // Json ignore mostra o funcionário mas não a classe chamados
    @JsonIgnore
    // Relacionamento de um para muitos (linkado com Called)
    @OneToMany(mappedBy = "employee")
    private List<Called> called = new ArrayList<Called>();

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    //Significa que o relacionamento é muitos para um (linkado com Employee)
    @ManyToOne
        @JoinColumn(name = "idCargo")
    private Cargo cargo;


//    //Relacionamento de endereço e funcionário
//    @OneToOne
//    @JoinColumn(name="idAddress", unique = true)
//    private Address address;
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }


    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Called> getCalled() {
        return called;
    }

    public void setCalled(List<Called> called) {
        this.called = called;
    }
}

