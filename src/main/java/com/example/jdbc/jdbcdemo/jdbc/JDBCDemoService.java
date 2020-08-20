package com.example.jdbc.jdbcdemo.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JDBCDemoService {

    private final JdbcTemplate jdbcTemplate;

    public JDBCDemoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        log.info("Initialize the database...");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        List<Object[]> names = Arrays.asList("Darshana Welikala","Hasaru Welikala","Piumine Wijekurrup","Vninitha Rupasinhe")
                .stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name,last_name) VALUES (?,?)",names);

    }

    public Optional<Customer> findCustomerByFirstName(String firstName){
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { firstName },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).stream().findAny();
    }

}
