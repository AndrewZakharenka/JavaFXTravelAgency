package com.service.dto.clients;

import com.service.dto.EntityDTO;

public class ClientDTO extends EntityDTO {
    private String name;
    private String surname;
    private String serialPassport;
    private String numberPassport;
    private String address;

    public ClientDTO() {
    }

    public ClientDTO(long id, String name, String surname, String serialPassport, String numberPassport, String address) {
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

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", serialPassport='" + serialPassport + '\'' +
                ", numberPassport='" + numberPassport + '\'' +
                ", address='" + address ;
    }
}
