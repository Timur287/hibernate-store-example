package com.java.dev.hibernate.customer.domain;

import com.java.dev.hibernate.product.domain.Product;
import com.java.dev.hibernate.role.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data // TODO: можно ли использовать к энтити? Есть ли проблема с equals/hash code
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "customer_id_gen")
    @SequenceGenerator(name = "customer_id_gen", sequenceName = "customer_id_seq")
    private Long id;

    private String name;
    private String lastname;
    private String email;
    private String phone;
    private int balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany
    private Set<Product> products = new HashSet<>();
}
