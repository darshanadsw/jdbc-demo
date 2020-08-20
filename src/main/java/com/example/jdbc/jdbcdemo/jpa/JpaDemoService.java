package com.example.jdbc.jdbcdemo.jpa;

import com.example.jdbc.jdbcdemo.jdbc.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Service
public class JpaDemoService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveCustomer(Customer c){
        em.persist(c);
    }

    public Customer findCustomer(long id){
        return em.find(Customer.class,id);
    }

}
