package com.dao.entity.user;

import com.dao.entity.Entity;
import com.dao.entity.role.RoleEntity;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "users")
public class UserEntity extends Entity {

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "IdRoles", referencedColumnName = "id")
    private RoleEntity roleEntity;

    public UserEntity(String name, String surname, String login, String password, RoleEntity roleEntity) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roleEntity = roleEntity;
    }

    public UserEntity(long id, String name, String surname, String login, String password, RoleEntity roleEntity) {
        super.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roleEntity = roleEntity;
    }

    public UserEntity() {
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
