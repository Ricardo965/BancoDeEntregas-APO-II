package com.seg14.seg14.model;
import java.util.Date;

public abstract class Register {
    private double amount;
    private String description;
    private Date regDate;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Register(double amount, String description, Date regDate) {
        this.amount = amount;
        this.description = description;
        this.regDate = regDate;
    }
}
