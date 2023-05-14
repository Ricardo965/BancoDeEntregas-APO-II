package com.seg14.seg14.model;
import java.util.Date;

public class Income extends Register implements Registrable{
    public Income(double amount, String description, Date regDate) {
        super(amount, description, regDate);
    }
}
