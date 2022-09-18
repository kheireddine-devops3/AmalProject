package com.amal.amalproject.controllers;

import com.amal.amalproject.MainApplication;
import com.amal.amalproject.entities.Dons;
import com.amal.amalproject.models.DonsModel;
import com.amal.amalproject.utils.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupprimerController implements Initializable {

    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    @FXML
    private ImageView x;

    @FXML
    private ImageView homeIcon;

    @FXML
    private ImageView addIcon;

    @FXML
    private ImageView modifyIcon;

    @FXML
    private ImageView removeIcon;

    @FXML
    protected Button BAjouter4,BAccueil4,BModifier4,BSupprimer4,btnretour;

    @FXML
    private ImageView imgFile;

    @FXML
    private TableColumn<Dons,Integer> id_col;

    @FXML
    private TableColumn <Dons,String> lib_col;

    @FXML
    private TableColumn <Dons,String> desc_col;

    @FXML
    private TableColumn <Dons,String> photo_col;

    @FXML
    private TableColumn <Dons,String> type_col;

    @FXML
    protected TableView TableDons;

    @FXML
    protected TextArea descDonsId;

    @FXML
    protected TextField photoDonID;

    @FXML
    protected TextField typeDonsID;

    @FXML
    protected TextField libelleDonID;




    int ID;
    DonsModel donsModel = new DonsModel();



    @FXML
    public void goToAccueil(ActionEvent event) {

        try {

            if (event.getSource() == BAccueil4) {
                stage = (Stage) BAccueil4.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication.class.getResource("Accueil.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void goToAjouter (ActionEvent event) {

        try {

            if (event.getSource() == BAjouter4) {
                stage = (Stage) BAjouter4.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication.class.getResource("Ajouter.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void goToModifier (ActionEvent event){

        try {

            if (event.getSource() == BModifier4) {
                stage = (Stage) BAccueil4.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication.class.getResource("Modifier.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void goToSupprimer (ActionEvent event)  {

        try {

            if (event.getSource() == BSupprimer4) {
                stage = (Stage) BAccueil4.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication.class.getResource("Supprimer.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    public void exit(){

    }
    @FXML
    public void removeDonsClicked( ) {
        Dons don =(Dons)  TableDons.getSelectionModel().getSelectedItem();
        if (don == null) {
            System.out.println("aucune dons a supprimer !");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supression d'un don !");
        alert.setContentText("Etes vous totalement sur de supprimer ce don <" + don.getId_dons()+ "-" + don.getDescription_dons() +"> ??\n");
        alert.getDialogPane().setMinHeight(ID);
        alert.setHeight(400);
        Optional<ButtonType> reponse = alert.showAndWait();
        if (reponse.get().equals(ButtonType.OK)) {
            try {
                Connection connection = DBConnection.getConnection();
                Statement sqlCommand = connection.createStatement();
                sqlCommand.execute
                        (


                                "Delete  FROM `dons` WHERE `id_dons` = " +

                                        don.getId_dons()

                        );

                TableDons.getItems().remove(TableDons.getSelectionModel().getSelectedItem());
                TableDons.refresh();
                libelleDonID.setText("");
                descDonsId.setText("");
                photoDonID.setText("");
                typeDonsID.setText("");



            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public void btnRetourClicked (ActionEvent event) {

        try {

            if (event.getSource() == btnretour) {
                stage = (Stage) btnretour.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication.class.getResource("Home.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_col.setCellValueFactory(new PropertyValueFactory<Dons,Integer>("id_dons"));
        lib_col.setCellValueFactory(new PropertyValueFactory<Dons,String>("libele_dons"));
        desc_col.setCellValueFactory(new PropertyValueFactory<Dons,String>("description_dons"));
        photo_col.setCellValueFactory(new PropertyValueFactory<Dons,String>("photo_produit_dons"));
        type_col.setCellValueFactory(new PropertyValueFactory<Dons,String>("type_dons"));


        TableDons.setItems(donsModel.getAllDons());


        donsModel.getAllDons().forEach(System.out::println);

    }
}
