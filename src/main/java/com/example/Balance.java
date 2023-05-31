package com.example;

import io.micronaut.aop.InterceptorBindingDefinitions;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import java.util.Date;

@MappedEntity(value = "balance")
public class Balance {

    @Id
    @GeneratedValue
    private long id;
    private final Date day;
    private final float balance;

    public Balance(float balance) {
        this.day = new Date();
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Balance(long id, Date day, float balance) {
        this.id = id;
        this.day = day;
        this.balance = balance;
    }

    public Date getDate() {
        return day;
    }

    public float getBalance() {
        return balance;
    }
}
