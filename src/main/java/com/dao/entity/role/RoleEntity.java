package com.dao.entity.role;

import com.dao.entity.Entity;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "roles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(name = "Name")
    private String name;

    public RoleEntity() {

    }

    public RoleEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
