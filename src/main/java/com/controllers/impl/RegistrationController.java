package com.controllers.impl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.Main;
import com.service.dto.user.UserDTO;
import com.service.user.UserService;
import com.service.user.impl.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationController{
    private static final UserService USER_SERVICE = new UserServiceImpl();
    private static final Logger LOGGER = LogManager.getLogger(AuthenticationController.class);

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
    private TextField surnameField;

    @FXML
    private TextField nameField;

    @FXML
    private Label errorLabel;

    @FXML
    void initialize() {
        loginButton.setOnAction(event -> {
            if (nameField.getText().isEmpty() || surnameField.getText().isEmpty() ||
                    loginField.getText().isEmpty() || passwordField.getText().isEmpty()) {

                errorLabel.setText("Все поля должны быть заполнены!");
            } else {
                if (loginField.getText().equals(USER_SERVICE.getUserByLogin(loginField.getText()).getLogin())) {
                    errorLabel.setText("Такой логин уже существует!");
                } else {
                    UserDTO userDTO = USER_SERVICE.createUser(new UserDTO(nameField.getText(), surnameField.getText(),
                            loginField.getText(), passwordField.getText(), "user"));


                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/forms/authentication.fxml"));

                    try {
                        Parent root = loader.load();
                        Main.primaryStage.setScene(new Scene(root, 700, 400));
                        AuthenticationController authenticationController = loader.getController();
                        authenticationController.setLogin(userDTO.getLogin());
                        Main.primaryStage.show();
//                        loginButton.getScene().getWindow().hide();
                    } catch (IOException e) {
                        LOGGER.error("Error when opening the form {}", e.getMessage(), e);
                    }
                }
            }
        });
    }
}
