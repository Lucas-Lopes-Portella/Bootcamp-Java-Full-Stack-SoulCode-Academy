package com.SoulCode.Services.Models;

public enum StatusPayment {

    SENT("Sent"),
    PAID("Paid");


    private String stringStatusPayment;


   private StatusPayment(String stringStatusPayment){
        this.stringStatusPayment = stringStatusPayment;
    }

    public String getStringStatusPayment() {
        return stringStatusPayment;
    }
}
