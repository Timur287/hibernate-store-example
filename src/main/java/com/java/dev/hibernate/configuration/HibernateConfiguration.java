package com.java.dev.hibernate.configuration;

import com.java.dev.hibernate.customer.domain.Client;
import com.java.dev.hibernate.permission.domain.Permission;
import com.java.dev.hibernate.product.domain.Product;
import com.java.dev.hibernate.role.domain.Role;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        configuration.configure().addAnnotatedClass(Client.class);
        configuration.configure().addAnnotatedClass(Role.class);
        configuration.configure().addAnnotatedClass(Permission.class);
        configuration.configure().addAnnotatedClass(Product.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
