package com.example.jdbc.jdbcdemo.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class JDBCDemoServiceTest {

    @Autowired
    private JDBCDemoService jdbcDemoService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void findCustomerByFirstName() {

        Optional<Customer> c = jdbcDemoService.findCustomerByFirstName("Darshana");
        assertTrue(c.isPresent());

    }
}