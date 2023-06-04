package com.example;

import jakarta.inject.Inject;

import java.util.Date;

public class DataService {

    @Inject
    BalanceRepository repository;

    public Balance getLastBalance() {
        Balance lastBalance = null;
        try {
            lastBalance = repository.getLast().orElseThrow(Exception::new);
        }
        catch (Exception e) {
            System.out.println("Nothing to render. Table is empty");
        }

        return lastBalance;
    }

    public void addBalance(float amount) {
        repository.save(new Balance(new Date(), amount));
    }


}
