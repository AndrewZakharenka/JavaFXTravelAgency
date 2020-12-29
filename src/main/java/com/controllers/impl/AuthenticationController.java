package com.controllers.impl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.Main;
import com.controllers.AbstractController;
import com.dao.impl.mysql.init.MySqlDAOInitializer;
import com.dao.init.DAOInitializer;
import com.service.dto.user.UserDTO;
import com.service.user.UserService;
import com.service.user.impl.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthenticationController extends AbstractController {

    public void setLogin(String login) {
        loginField.setText(login);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        signUpButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/forms/registration.fxml"));

            try {
                Parent root = loader.load();
                Main.primaryStage.setScene(new Scene(root, 700, 500));
                Main.primaryStage.show();
            } catch (IOException e) {
                LOGGER.error("Error when opening the form {}", e.getMessage(), e);
            }

        });

        loginButton.setOnAction(event -> {
            List<UserDTO> users = USER_SERVICE.getAllUsers();
            Optional<UserDTO> user = users.stream().filter(u -> u.getLogin().equals(loginField.getText()) &&
                    u.getPassword().equals(passwordField.getText())).findAny();
            if (user.isPresent()){
                Main.userDTO = user.get();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/forms/viewTrips.fxml"));

                try {
                    Parent root = loader.load();
                    Main.primaryStage.setScene(new Scene(root, 1200, 600));
                    Main.primaryStage.setTitle("Просмотр туров");
                    Main.primaryStage.show();
                } catch (IOException e) {
                    LOGGER.error("Error when opening the form {}", e.getMessage(), e);
                }

                LOGGER.info("User is present! {}", user.getClass().getName());
            }
        });
    }

}
