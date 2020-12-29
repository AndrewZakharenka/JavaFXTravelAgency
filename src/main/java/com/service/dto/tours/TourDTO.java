package com.service.dto.tours;

import com.service.dto.EntityDTO;
import com.service.dto.clients.ClientDTO;
import com.service.dto.user.UserDTO;

import java.time.LocalDate;
import java.util.Date;

public class TourDTO extends EntityDTO {
    private String departure;
    private String arrive;
    private LocalDate departureDate;
    private LocalDate arriveDate;
    private String hotel;
    private double price;

    private UserDTO userDTO;

    private ClientDTO clientDTO;

    public TourDTO(String departure, String arrive, LocalDate departureDate, LocalDate arriveDate, String hotel, double price,
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

    public TourDTO(long id,String departure, String arrive, LocalDate departureDate, LocalDate arriveDate, String hotel, double price,
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(LocalDate arriveDate) {
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public TourDTO(UserDTO userDTO, ClientDTO clientDTO) {
        this.userDTO = userDTO;
        this.clientDTO = clientDTO;
    }

    public TourDTO() {
    }

}
