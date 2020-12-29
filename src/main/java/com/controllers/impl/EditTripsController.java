package com.controllers.impl;

import com.Main;
import com.controllers.AbstractController;
import com.service.dto.clients.ClientDTO;
import com.service.dto.tours.TourDTO;
import com.service.dto.user.UserDTO;
import com.service.user.TourService;
import com.service.user.impl.TourServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditTripsController extends AbstractController implements Initializable {
    private TourDTO tourDTO;

    @FXML
    private TextField departureField;

    @FXML
    private TextField arriveField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField hotelField;

    @FXML
    private DatePicker departureDateField;

    @FXML
    private DatePicker arriveDateField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField serialPassportField;

    @FXML
    private TextField numberPassportField;

    @FXML
    private TextField addressField;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    public void setTourDTO(TourDTO tourDTO) {
        this.tourDTO = tourDTO;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveButton.setOnAction(event -> {
            createTourDto();
            TOUR_SERVICE.createTour(tourDTO);
        });

        backButton.setOnAction(event -> {
            openViewTripsForm();
        });
    }

    private void createTourDto(){
        tourDTO.setDeparture(departureField.getText());
        tourDTO.setArrive(arriveField.getText());
        tourDTO.setArriveDate(arriveDateField.getValue());
        tourDTO.setDepartureDate(departureDateField.getValue());
        tourDTO.setHotel(hotelField.getText());
        tourDTO.setPrice(Double.parseDouble(priceField.getText()));
        tourDTO.getClientDTO().setName(nameField.getText());
        tourDTO.getClientDTO().setSurname(surnameField.getText());
        tourDTO.getClientDTO().setSerialPassport(serialPassportField.getText());
        tourDTO.getClientDTO().setNumberPassport(numberPassportField.getText());
        tourDTO.getClientDTO().setAddress(addressField.getText());
        tourDTO.setUserDTO(Main.userDTO);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационное сообщение!");
        alert.setHeaderText(null);
        alert.setContentText("Сохранение выполнено успешно!");
        alert.showAndWait();
        openViewTripsForm();
    }

    private void openViewTripsForm(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/forms/viewTrips.fxml"));

        try {
            Parent root = loader.load();
            Main.primaryStage.setScene(new Scene(root, 1200, 600));
            Main.primaryStage.show();
        } catch (IOException e) {
            LOGGER.error("Error when opening the form {}", e.getMessage(), e);
        }
    }

    public void fillAllFieldsOnForm(TourDTO tourDTO){
        setTourDTO(tourDTO);
        departureField.setText(tourDTO.getDeparture());
        arriveField.setText(tourDTO.getArrive());
        priceField.setText(String.valueOf(tourDTO.getPrice()));
        departureDateField.setValue(tourDTO.getDepartureDate());
        arriveDateField.setValue(tourDTO.getArriveDate());
        hotelField.setText(tourDTO.getHotel());
        nameField.setText(tourDTO.getClientDTO().getName());
        surnameField.setText(tourDTO.getClientDTO().getSurname());
        serialPassportField.setText(tourDTO.getClientDTO().getSerialPassport());
        numberPassportField.setText(tourDTO.getClientDTO().getNumberPassport());
        addressField.setText(tourDTO.getClientDTO().getAddress());
    }
}

