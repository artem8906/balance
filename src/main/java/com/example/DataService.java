package com.example;

import jakarta.inject.Inject;

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

}
