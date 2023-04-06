package com.java.dev.hibernate.permission.domain;

import com.java.dev.hibernate.role.domain.Role;
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
public class Permission {

    @Id
    @GeneratedValue(generator = "permission_id_gen")
    @SequenceGenerator(name = "permission_id_gen", sequenceName = "permission_id_seq")
    private Long id;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();
}
