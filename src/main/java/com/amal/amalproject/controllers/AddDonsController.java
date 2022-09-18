/* package com.amal.amalproject.controllers;

import com.amal.amalproject.entities.dons;
import com.amal.amalproject.models.DonsModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddDonsController {


    @FXML
    private TextField LibDonsID;
    @FXML
    private TextField DsDonsID;
    @FXML
    private TextField PhotoPrdDonsID;
    @FXML
    private TextField TyDonID;

    private DonsModel donsModel = new DonsModel();


    @FXML
    protected void onAddDonsClick() {
        String libele_dons = LibDonsID.getText();
        String description_dons = DsDonsID.getText();
        String photo_produit_dons = PhotoPrdDonsID.getText();
        String type_dons = TyDonID.getText();

        dons don = new dons(libele_dons, description_dons, photo_produit_dons, type_dons);

        donsModel.addDons(don);

        for (dons d : donsModel.getAllDons()) {
            System.out.println(d);


        }
    }
}
*/
