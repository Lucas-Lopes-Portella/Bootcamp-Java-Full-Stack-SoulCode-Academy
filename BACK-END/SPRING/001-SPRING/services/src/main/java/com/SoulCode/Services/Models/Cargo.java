package com.SoulCode.Services.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCargo;

    @Column(nullable = false, length=100, unique = false)
    private String name;

    @Column(nullable = false, length=200, unique = false)
    private String descricao;

    @Column(nullable = false, unique = false)
    private double salario;


    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @JsonIgnore
    // Relacionamento de um para muitos (linkado com Funcionario)
    @OneToMany(mappedBy = "cargo")
    private List<Employee> employee = new ArrayList<Employee>();



    public Integer getIdCargo() {

        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
