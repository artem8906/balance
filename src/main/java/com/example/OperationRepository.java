package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@io.micronaut.data.annotation.Repository
@JdbcRepository(dialect = Dialect.MYSQL)
public interface OperationRepository extends CrudRepository<Operation, Long> {

     @Query("INSERT into operation (date, amount, balance) values (:date, :amount, :balance)")
     void addOperation(Date date, float amount, float balance);


     @Query("SELECT * FROM operation ORDER BY id DESC LIMIT 10")
     List<Operation> get10Last();


     @Query("SELECT * FROM operation ORDER BY id DESC LIMIT 1")
     Optional<Operation> getBalance();

}
