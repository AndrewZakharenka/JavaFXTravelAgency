package com.controllers.impl;

import com.Main;
import com.controllers.AbstractController;
import com.controllers.model.TourPojo;
import com.service.dto.clients.ClientDTO;
import com.service.dto.tours.TourDTO;
import com.service.dto.user.UserDTO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ViewTripsController extends AbstractController implements Initializable {

    private ObservableList<TourPojo> tourData = FXCollections.observableArrayList();

    @FXML
    private Button addTour;

    @FXML
    private Button editTour;

    @FXML
    private Button deleteTour;

    @FXML
    private TableView<TourPojo> table;

    @FXML
    private TableColumn<TourPojo, Long> idField;

    @FXML
    private TableColumn<TourPojo, String> departureField;

    @FXML
    private TableColumn<TourPojo, String> arriveField;

    @FXML
    private TableColumn<TourPojo, LocalDate> departureDateField;

    @FXML
    private TableColumn<TourPojo, LocalDate> arriveDateField;

    @FXML
    private TableColumn<TourPojo, String> infoAboutClientField;

    @FXML
    private TableColumn<TourPojo, String> infoAboutUserField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       initTable();

        addTour.setOnAction(event -> {
            addTourButtonClick();
        });

        editTour.setOnAction(event -> {
            editTourClick();
        });

        deleteTour.setOnAction(event -> {
            deleteTourClick();
        });
    }

    private void deleteTourClick(){
        TableView.TableViewSelectionModel<TourPojo> selected = table.getSelectionModel();
        TOUR_SERVICE.deleteTourById(selected.getSelectedItem().getIdField());
    }

    private void editTourClick(){
        TableView.TableViewSelectionModel<TourPojo> selected = table.getSelectionModel();
        TourDTO tourDTO = TOUR_SERVICE.getTourById(selected.getSelectedItem().getIdField());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/forms/EditTrips.fxml"));

        try {
            Parent root = loader.load();
            Main.primaryStage.setScene(new Scene(root, 625, 600));
            EditTripsController editTripsController = loader.getController();
            editTripsController.fillAllFieldsOnForm(tourDTO);
            Main.primaryStage.show();
        } catch (IOException e) {
            LOGGER.error("Error when opening the form {}", e.getMessage(), e);
        }
    }

    private void addTourButtonClick(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/forms/EditTrips.fxml"));

        try {
            Parent root = loader.load();
            Main.primaryStage.setScene(new Scene(root, 625, 600));
            EditTripsController editTripsController = loader.getController();
            editTripsController.setTourDTO(new TourDTO(new UserDTO(), new ClientDTO()));
            Main.primaryStage.show();
        } catch (IOException e) {
            LOGGER.error("Error when opening the form {}", e.getMessage(), e);
        }
    }

    private void initTable(){
        fillTourData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idField.setCellValueFactory(new PropertyValueFactory<TourPojo, Long>("idField"));
        departureField.setCellValueFactory(new PropertyValueFactory<TourPojo, String>("departureField"));
        arriveField.setCellValueFactory(new PropertyValueFactory<TourPojo, String>("arriveField"));
        departureDateField.setCellValueFactory(new PropertyValueFactory<TourPojo, LocalDate>("departureDateField"));
        arriveDateField.setCellValueFactory(new PropertyValueFactory<TourPojo, LocalDate>("arriveDateField"));
        infoAboutClientField.setCellValueFactory(new PropertyValueFactory<TourPojo, String>("infoAboutClientField"));
        infoAboutUserField.setCellValueFactory(new PropertyValueFactory<TourPojo, String>("infoAboutUserField"));

        // заполняем таблицу данными
        table.setItems(tourData);
    }

    private void fillTourData(){
        List<TourDTO> tourDTOList = TOUR_SERVICE.getAllTours();
        tourData.clear();

        for (TourDTO tour : tourDTOList) {
            tourData.add(new TourPojo(tour.getId(), tour.getDeparture(), tour.getArrive(),
                    tour.getDepartureDate(), tour.getArriveDate(), tour.getClientDTO().toString(),
                    tour.getUserDTO().toString()));
        }
    }

}
