package com.service.dto.user;

import com.service.dto.EntityDTO;
import com.service.dto.roles.RoleDTO;

public class UserDTO extends EntityDTO {
    private String name;
    private String surname;
    private String login;
    private String password;
    private RoleDTO roleDTO;

    public UserDTO(long id, String name, String surname, String login, String password, RoleDTO roleDTO) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roleDTO = roleDTO;
    }

    public UserDTO(String name, String surname, String login, String password, RoleDTO roleDTO) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.roleDTO = roleDTO;
    }

    public UserDTO() {
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
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
