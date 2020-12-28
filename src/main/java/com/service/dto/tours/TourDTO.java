package com.service.dto.tours;

import com.service.dto.EntityDTO;
import com.service.dto.clients.ClientDTO;
import com.service.dto.user.UserDTO;

import java.util.Date;

public class TourDTO extends EntityDTO {
    private String departure;
    private String arrive;
    private Date departureDate;
    private Date arriveDate;
    private String hotel;
    private double price;

    private UserDTO userDTO;

    private ClientDTO clientDTO;

    public TourDTO(String departure, String arrive, Date departureDate, Date arriveDate, String hotel, double price,
                   UserDTO userDTO, ClientDTO clientDTO) {
        this.departure = departure;
        this.arrive = arrive;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.hotel = hotel;
        this.price = price;
        this.userDTO = userDTO;
        this.clientDTO = clientDTO;
    }

    public TourDTO(long id,String departure, String arrive, Date departureDate, Date arriveDate, String hotel, double price,
                   UserDTO userDTO, ClientDTO clientDTO) {
        super(id);
        this.departure = departure;
        this.arrive = arrive;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.hotel = hotel;
        this.price = price;
        this.userDTO = userDTO;
        this.clientDTO = clientDTO;
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

    public UserDTO getUserEntity() {
        return userDTO;
    }

    public void setUserEntity(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ClientDTO getClientEntity() {
        return clientDTO;
    }

    public void setClientEntity(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public TourDTO() {
    }

}
