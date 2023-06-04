package com.example;

import io.micronaut.aop.InterceptorBindingDefinitions;
import io.micronaut.data.annotation.DataTransformer;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.jdbc.annotation.ColumnTransformer;

import java.util.Date;

@MappedEntity(value = "balance")
public class Balance {

    @Id
    @GeneratedValue
    private long id;

    private final Date date;
    private final float balance;


    public Date getDay() {
        return date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Balance(long id, Date date, float balance) {
        this.id = id;
        this.date = date;
        this.balance = balance;
    }

    public Balance(Date date, float balance) {
        this.date = date;
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public float getBalance() {
        return balance;
    }
}
