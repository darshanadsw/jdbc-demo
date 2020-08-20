package com.example.jdbc.jdbcdemo.jpa;

import com.example.jdbc.jdbcdemo.jdbc.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Transactional
class JpaDemoServiceTest {

    @Autowired
    private JpaDemoService jpaDemoService;

    @Autowired
    private EntityManager em;

    @Test
    void saveCustomer() {
        Customer c = new Customer();
        c.setFirstName("Darshana");
        c.setLastName("Welikala");
        jpaDemoService.saveCustomer(c);

        assertNotNull(c.getId());

        Customer customer = em.find(Customer.class,c.getId());
        assertNotNull(customer.getId());
    }

    @Test
    void findCustomer() {
        Customer c = new Customer();
        c.setFirstName("Darshana");
        c.setLastName("Welikala");
        em.persist(c);
        assertNotNull(jpaDemoService.findCustomer(c.getId()));
    }
}