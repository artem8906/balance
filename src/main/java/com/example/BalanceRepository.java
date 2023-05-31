package com.example;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@io.micronaut.data.annotation.Repository
@JdbcRepository(dialect = Dialect.MYSQL)
public interface BalanceRepository extends CrudRepository<Balance, Long>{

@Query("SELECT * FROM balance ORDER BY day DESC LIMIT 1")
Optional<Balance> getLast();

}
