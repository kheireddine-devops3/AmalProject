package com.amal.amalproject.controllers;

import com.amal.amalproject.MainApplication3;
import com.amal.amalproject.entities.Dons;
import com.amal.amalproject.models.DonsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AjouterController implements Initializable {

        @FXML
        private Parent root;

        @FXML
        private Stage stage;

        @FXML
        public Button btnretour;

        @FXML
        protected Button BAjouter2,BAccueil2,BModifier2,BSupprimer2;

        @FXML
        protected TextField libelleDonID;

        @FXML
        protected TextArea descDonsId;

        @FXML
        protected TextField photoDonID;

        @FXML
        protected TextField typeDonsID;

        @FXML
        protected TableView TableDons;

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
        private TableColumn<Dons,Integer> id_col;

        @FXML
        private TableColumn <Dons,String> lib_col;

        @FXML
        private TableColumn <Dons,String> desc_col;

        @FXML
        private TableColumn <Dons,String> photo_col;

        @FXML
        private TableColumn <Dons,String> type_col;



        FileChooser fc = new FileChooser();
        @FXML
        public void goToAccueil(ActionEvent event) {

                try {

                        if (event.getSource() == BAccueil2) {
                                stage = (Stage) BAccueil2.getScene().getWindow();

                                FXMLLoader fxmlLoader = new FXMLLoader(
                                        MainApplication3.class.getResource("Accueil.fxml"));
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

                        if (event.getSource() == BAjouter2) {
                                stage = (Stage) BAjouter2.getScene().getWindow();

                                FXMLLoader fxmlLoader = new FXMLLoader(
                                        MainApplication3.class.getResource("Ajouter.fxml"));
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

                        if (event.getSource() == BModifier2) {
                                stage = (Stage) BAccueil2.getScene().getWindow();

                                FXMLLoader fxmlLoader = new FXMLLoader(
                                        MainApplication3.class.getResource("Modifier.fxml"));
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

                        if (event.getSource() == BSupprimer2) {
                                stage = (Stage) BAccueil2.getScene().getWindow();

                                FXMLLoader fxmlLoader = new FXMLLoader(
                                        MainApplication3.class.getResource("Supprimer.fxml"));
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
        public void addImageClicked (ActionEvent event){
                fc.setTitle("Image chooser");

                fc.setInitialDirectory(new File(System.getProperty("user.home")));

                fc.getExtensionFilters().clear();
                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));

                File file = fc.showOpenDialog(null);

                if(file != null) {
                        photoDonID.appendText(file.getAbsolutePath()+"\n");
                }
                else {
                        System.out.println("champ non valide");
                }

        }

        public void btnRetourClicked (ActionEvent event) {

                try {

                        if (event.getSource() == btnretour) {
                                stage = (Stage) btnretour.getScene().getWindow();

                                FXMLLoader fxmlLoader = new FXMLLoader(
                                        MainApplication3.class.getResource("Home.fxml"));
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
