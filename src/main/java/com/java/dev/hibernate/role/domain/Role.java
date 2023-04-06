package com.java.dev.hibernate.role.domain;


import com.java.dev.hibernate.customer.domain.Customer;
import com.java.dev.hibernate.permission.domain.Permission;
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
public class Role {

    @Id
    @GeneratedValue(generator = "role_id_gen")
    @SequenceGenerator(name = "role_id_gen", sequenceName = "role_id_seq")
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<Customer> customers = new HashSet<>(); // TODO: почему нужно инициализировать коллекции

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Permission> permissions = new HashSet<>();
}
