package com.service.dto.user;

import com.service.dto.EntityDTO;

public class UserDTO extends EntityDTO {
    private String name;
    private String surname;
    private String login;
    private String password;
    private String roles;

    public UserDTO(long id, String name, String surname, String login, String password, String roles) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public UserDTO(String name, String surname, String login, String password, String roles) {
        super(0);
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public UserDTO() {
    }

    public String getRole() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
