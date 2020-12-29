package com.controllers.model;

import java.time.LocalDate;

public class TourPojo {

    private long idField;

    private String departureField;

    private String arriveField;

    private LocalDate departureDateField;

    private LocalDate arriveDateField;

    private String infoAboutClientField;

    private String infoAboutUserField;

    public TourPojo(long idField, String departureField, String arriveField, LocalDate departureDateField,
                    LocalDate arriveDateField, String infoAboutClientField, String infoAboutUserField) {
        this.idField = idField;
        this.departureField = departureField;
        this.arriveField = arriveField;
        this.departureDateField = departureDateField;
        this.arriveDateField = arriveDateField;
        this.infoAboutClientField = infoAboutClientField;
        this.infoAboutUserField = infoAboutUserField;
    }

    public long getIdField() {
        return idField;
    }

    public void setIdField(long idField) {
        this.idField = idField;
    }

    public String getDepartureField() {
        return departureField;
    }

    public void setDepartureField(String departureField) {
        this.departureField = departureField;
    }

    public String getArriveField() {
        return arriveField;
    }

    public void setArriveField(String arriveField) {
        this.arriveField = arriveField;
    }

    public LocalDate getDepartureDateField() {
        return departureDateField;
    }

    public void setDepartureDateField(LocalDate departureDateField) {
        this.departureDateField = departureDateField;
    }

    public LocalDate getArriveDateField() {
        return arriveDateField;
    }

    public void setArriveDateField(LocalDate arriveDateField) {
        this.arriveDateField = arriveDateField;
    }

    public String getInfoAboutClientField() {
        return infoAboutClientField;
    }

    public void setInfoAboutClientField(String infoAboutClientField) {
        this.infoAboutClientField = infoAboutClientField;
    }

    public String getInfoAboutUserField() {
        return infoAboutUserField;
    }

    public void setInfoAboutUserField(String infoAboutUserField) {
        this.infoAboutUserField = infoAboutUserField;
    }
}
