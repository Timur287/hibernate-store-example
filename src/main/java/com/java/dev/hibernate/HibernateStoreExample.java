package com.java.dev.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateStoreExample {

    @Autowired
    private SessionFactory sessionFactory; // TODO: почему нужно автовайрдить через сеттеры? Из-за циклической/круговой зависимости?

    public static void main(String[] args) {
        SpringApplication.run(HibernateStoreExample.class, args);

    }
}
