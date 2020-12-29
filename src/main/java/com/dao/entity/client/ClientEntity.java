package com.dao.entity.client;

import com.dao.entity.Entity;

import javax.persistence.Column;

import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "clients")
public class ClientEntity extends Entity {

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "SerialPassport")
    private String serialPassport;

    @Column(name = "NumberPassport")
    private String numberPassport;

    @Column(name = "Address")
    private String address;

    public ClientEntity() {
    }

    public ClientEntity(long id, String name, String surname, String serialPassport, String numberPassport,
                        String address) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.serialPassport = serialPassport;
        this.numberPassport = numberPassport;
        this.address = address;
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

    public String getSerialPassport() {
        return serialPassport;
    }

    public void setSerialPassport(String serialPassport) {
        this.serialPassport = serialPassport;
    }

    public String getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(String numberPassport) {
        this.numberPassport = numberPassport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
