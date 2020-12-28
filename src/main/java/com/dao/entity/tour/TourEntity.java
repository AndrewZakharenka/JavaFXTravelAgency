package com.dao.entity.tour;

import com.dao.entity.Entity;
import com.dao.entity.IEntity;
import com.dao.entity.client.ClientEntity;
import com.dao.entity.user.UserEntity;

import javax.persistence.*;
import java.util.Date;

@javax.persistence.Entity
@Table(name = "tours")
public class TourEntity extends Entity{

    @Column(name = "Departure")
    private String departure;

    @Column(name = "Arive")
    private String arrive;

    @Column(name = "Price")
    private double price;

    @Column(name = "DepartureDate")
    private Date departureDate;

    @Column(name = "AriveDate")
    private Date arriveDate;

    @Column(name = "Hotel")
    private String hotel;


    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "IdUsers", referencedColumnName = "id")
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "IdClients", referencedColumnName = "id")
    private ClientEntity clientEntity;

    public TourEntity(String departure, String arrive, Date departureDate, Date arriveDate, String hotel, double price,
                      UserEntity userEntity, ClientEntity clientEntity) {
        this.departure = departure;
        this.arrive = arrive;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.hotel = hotel;
        this.price = price;
        this.userEntity = userEntity;
        this.clientEntity = clientEntity;
    }


    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public TourEntity() {
    }

}
