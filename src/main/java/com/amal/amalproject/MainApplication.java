package com.amal.amalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import  javafx.scene.*;
import  javafx.stage.Stage;
import  javafx.stage.StageStyle;


import java.io.IOException;

public class MainApplication extends Application {

    private Stage stage;

    double x,y =0;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Amal Application");
        stage.setScene(scene);
        stage.show();

    }




    public static void main(String[] args) {
        launch();

    }
}