package com.example;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import java.util.Date;

@MappedEntity(value = "operation")
public class Operation {

    @Id
    @GeneratedValue
    private long id;

    private final Date date;
    private final float amount;
    private final float balance;

    public Operation(long id, Date date, float amount, float balance) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }


    public Operation(float balance) {
        this.balance = balance;
        amount = 0.00f;
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public float getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
