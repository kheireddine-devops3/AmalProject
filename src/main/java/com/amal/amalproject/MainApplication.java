package com.amal.amalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {

    	/* FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("AddEmploi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Amal Application");
        stage.setScene(scene);
        stage.show();*/
        
        
        
        Parent root=FXMLLoader.load(getClass().getResource("ListEmploi.fxml"));
        
        Scene scene = new Scene(root,800,600);
        //scene.getStylesheets().add(getClass().getResource("stylessabrine.css").toExternalForm());
        
        primaryStage.setTitle("Ajout offre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}