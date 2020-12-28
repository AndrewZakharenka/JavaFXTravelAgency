package com.controllers.impl;

import com.controllers.model.TourPojo;
import com.service.dto.tours.TourDTO;
import com.service.user.TourService;
import com.service.user.impl.TourServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ViewTripsController implements Initializable {

    private static final TourService TOUR_SERVICE = new TourServiceImpl();
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
    private TableColumn<TourPojo, Date> departureDateField;

    @FXML
    private TableColumn<TourPojo, Date> arriveDateField;

    @FXML
    private TableColumn<TourPojo, String> infoAboutClientField;

    @FXML
    private TableColumn<TourPojo, String> infoAboutUserField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillTourData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idField.setCellValueFactory(new PropertyValueFactory<TourPojo, Long>("idField"));
        departureField.setCellValueFactory(new PropertyValueFactory<TourPojo, String>("departureField"));
        arriveField.setCellValueFactory(new PropertyValueFactory<TourPojo, String>("arriveField"));
        departureDateField.setCellValueFactory(new PropertyValueFactory<TourPojo, Date>("departureDateField"));
        arriveDateField.setCellValueFactory(new PropertyValueFactory<TourPojo, Date>("arriveDateField"));
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
                    tour.getDepartureDate(), tour.getArriveDate(), tour.getClientEntity().toString(),
                    tour.getUserEntity().toString()));
        }
    }
}
