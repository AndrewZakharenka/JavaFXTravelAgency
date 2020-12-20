package com;

import com.dao.impl.mysql.init.MySqlDAOInitializer;
import com.dao.init.DAOInitializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Main extends Application {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final DAOInitializer DAO_INITIALIZER = new MySqlDAOInitializer();
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/forms/authentication.fxml"));
        primaryStage.setTitle("Авторизация");
        primaryStage.setScene(new Scene(root, 700, 400));
        runStage(primaryStage);
//        primaryStage.show();
    }

    public static void runStage(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        DAO_INITIALIZER.init();
        LOGGER.info("Initialized");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
