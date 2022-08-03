package com.SoulCode.Services.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Called {
    @Id
    private Integer idCalled;

    @Column(nullable = false)
    private String tittle;

    @Column(nullable = true)
    private String description;

    @Column(columnDefinition = "date", nullable = false)
    private Date dateRegister;

    @Enumerated(EnumType.STRING)
    private  StatusCalled status;

    public Integer getIdCalled() {
        return idCalled;
    }

    public void setIdCalled(Integer idCalled) {
        this.idCalled = idCalled;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public StatusCalled getStatus() {
        return status;
    }

    public void setStatus(StatusCalled status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    //Significa que o relacionamento é muitos para um (linkado com Employee)
    @ManyToOne
    @JoinColumn(name = "idEmployee")
    private Employee employee;

    //Significa que o relacionamento é muitos para um (linkado com Client)
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    // Relaciomaneot um para um entre chamado e pagamento
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPayment", unique = true)
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
