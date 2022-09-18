/* package com.amal.amalproject.controllers;

import com.amal.amalproject.entities.Dons;

import com.amal.amalproject.models.DonsModel;

import com.amal.amalproject.utils.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class DonsController implements Initializable {

    @FXML
    protected Button addDons;

    @FXML
    protected Button aficherDons;

    @FXML
    protected Button removeDons;

    @FXML
    protected Button modifyDons;


    @FXML
    protected Button listDons;

    @FXML
    protected TextField libelleDonID;

    @FXML
    protected TextArea descDonsId;

    @FXML
    protected TextField photoDonID;

    @FXML
    protected TextField typeDonsID;

    @FXML
    private TableView <Dons> TableDons;



    @FXML
    private TableColumn <Dons,Integer> id_col;

    @FXML
    private TableColumn <Dons,String> lib_col;

    @FXML
    private TableColumn <Dons,String> desc_col;

    @FXML
    private TableColumn <Dons,String> photo_col;

    @FXML
    private TableColumn <Dons,String> type_col;



    DonsModel donsModel = new DonsModel();

    int ID;
    ObservableList<Dons> don = FXCollections.observableArrayList();
    @FXML
    protected void addDonsClicked() {

        String libele_dons = libelleDonID.getText();
        String description_dons = descDonsId.getText();
        String photo_produit_dons = photoDonID.getText();
        String type_dons = typeDonsID.getText();
        TableDons.refresh();

        Dons don = new Dons(libele_dons, description_dons, photo_produit_dons, type_dons);

        donsModel.addDons(don);
        libelleDonID.getText();
        descDonsId.getText();
        photoDonID.getText();
        typeDonsID.getText();
        TableDons.setItems(donsModel.getAllDons());



        for (Object d : donsModel.getAllDons()) {
            System.out.println(d);


        }
    }

    @FXML
    public void afficherDonsClicked( ) {


    }

    @FXML
    public void modifyDonsClicked (ActionEvent event) {


            Dons dn = new Dons();

            if(!libelleDonID.getText().equals("")&&!descDonsId.getText().equals("")&&!typeDonsID.getText().equals("")){

                dn.setLibele_dons(libelleDonID.getText());
                dn.setDescription_dons(descDonsId.getText());
                dn.setPhoto_produit_dons((photoDonID.getText()));
                dn.setType_dons(typeDonsID.getText());
                dn.setId_dons(ID);

                donsModel.modifyDons(dn);
                TableDons.setItems(donsModel.getAllDons());
                TableDons.refresh();

                libelleDonID.setText("");
                descDonsId.setText("");
                photoDonID.setText("");
                typeDonsID.setText("");


                System.out.println("affichage de modification " + donsModel.getAllDons());



            }


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


                                        "Delete  FROM `formation` WHERE `id_formation` = " +

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

    public void start(Stage primaryStage) {

        ListView<Dons> list = new ListView<>();
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<Dons> arr
                = FXCollections.observableArrayList();
        list.setItems(arr);
        FlowPane root = new FlowPane();
        root.getChildren().add(list);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("ListView");
        primaryStage.setScene(scene);
        primaryStage.show();
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
*/