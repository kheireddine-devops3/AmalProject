package com.amal.amalproject.controllers;

import com.amal.amalproject.MainApplication;
import com.amal.amalproject.entities.Dons;
import com.amal.amalproject.models.DonsModel;
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

public class ModifierController implements Initializable {

    @FXML
    private Parent root;

    @FXML
    private Stage stage;

    @FXML
    protected Button BAjouter3,BAccueil3,BModifier3,BSupprimer3,btnretour;

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
    protected TextField libelleDonID;

    @FXML
    protected TextArea descDonsId;

    @FXML
    protected TextField typeDonsID;

    @FXML
    protected TextField photoDonID;

    @FXML
    private TableColumn<Dons,Integer> id_col;

    @FXML
    private TableColumn <Dons,String> lib_col;

    @FXML
    private TableColumn <Dons,String> desc_col;

    @FXML
    private TableColumn<Dons,String> type_col;
    @FXML
    private TableColumn <Dons,String> photo_col;


    DonsModel donsModel = new DonsModel();
    FileChooser fc = new FileChooser();
    int ID;





    @FXML
    public void goToAccueil(ActionEvent event) {

        try {

            if (event.getSource() == BAccueil3) {
                stage = (Stage) BAccueil3.getScene().getWindow();

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

            if (event.getSource() == BAjouter3) {
                stage = (Stage) BAjouter3.getScene().getWindow();

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

            if (event.getSource() == BModifier3) {
                stage = (Stage) BAccueil3.getScene().getWindow();

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

            if (event.getSource() == BSupprimer3) {
                stage = (Stage) BAccueil3.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(
                        MainApplication.class.getResource("Supprimer.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.  show();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    public void exit(){

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
