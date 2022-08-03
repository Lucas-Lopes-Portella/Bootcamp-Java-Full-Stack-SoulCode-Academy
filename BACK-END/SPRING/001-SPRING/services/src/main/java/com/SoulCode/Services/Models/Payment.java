package com.SoulCode.Services.Models;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Entity
public class Payment {

    @Id
    private Integer idPayment;

    @NumberFormat(pattern = "#.##0,00")
    @Column(nullable = false, length=50, unique = false)
    private double value;

    @Column(nullable = false, length = 50, unique = false)
    private String formOfPayment;

    @Enumerated(EnumType.STRING)
    private  StatusPayment statusPayment;

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(String formOfPayment) {
        this.formOfPayment = formOfPayment;
    }

    public StatusPayment getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(StatusPayment statusPayment) {
        this.statusPayment = statusPayment;
    }
}
