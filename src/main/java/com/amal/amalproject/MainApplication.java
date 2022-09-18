package com.amal.amalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainApplication extends Application {

    private Stage stage;
    private static Scene scene;

    @Override

    public void start(Stage primaryStage) throws IOException {

    	
        Parent root=FXMLLoader.load(getClass().getResource("ListOffres.fxml"));
        
        Scene scene = new Scene(root,800,600);
        //scene.getStylesheets().add(getClass().getResource("stylessabrine.css").toExternalForm());
        
        primaryStage.setTitle("Ajout offre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void loadView(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

        URL url = MainApplication.class.getResource(fxml + ".css");
        if (url != null) {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(url.toExternalForm());
        }
    }

    public static Parent includeView(String fxml) throws IOException {
        return loadFXML(fxml);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        URL urlUserHomeCss = MainApplication.class.getResource("user-home-view.css");
        URL url = MainApplication.class.getResource(fxml + ".css");
        if (url != null) {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(urlUserHomeCss.toExternalForm());
            scene.getStylesheets().add(url.toExternalForm());
        }
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


