package com.example;

import jakarta.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
public class DataService {

    @Inject
    OperationRepository repository;

    @Transactional
    public void addOperation(float amount) {
        float balance = repository.getBalance().orElse(new Operation(0.00f)).getBalance();
        repository.addOperation(new Date(), amount, balance + amount);
    }

    public List<Operation> get10LastOperation() {
        return repository.get10Last();
    }


}
