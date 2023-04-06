package com.java.dev.hibernate.product.domain;

import com.java.dev.hibernate.customer.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "product_id_gen")
    @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_seq")
    private Long id;

    private String name;
    private int price;
    private String description;

    @ManyToMany
    private Set<Customer> clients = new HashSet<>();
}
