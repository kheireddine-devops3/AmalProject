package com.amal.amalproject.controllers;

import com.amal.amalproject.entities.Compte;
import com.amal.amalproject.entities.User;
import com.amal.amalproject.models.UserModel;
import com.amal.amalproject.utils.SessionUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends SharedController implements Initializable {

    UserModel userModel = new UserModel();
    @FXML
    private TextField usernameID;
    @FXML
    private PasswordField passwordID;
    @FXML
    private Label usernameErrorMessageID;
    @FXML
    private Label passwordErrorMessageID;

    @FXML
    protected void onLoginClick() {
        boolean isValid = true;
        if (usernameID.getText().isBlank()) {
            usernameErrorMessageID.setText("Username Is Required");
            usernameErrorMessageID.setPrefHeight(40.0);
            usernameID.getStyleClass().add("error");
            isValid = false;
        } else {
            usernameID.getStyleClass().remove("error");
            usernameErrorMessageID.setPrefHeight(0.0);
            usernameErrorMessageID.setText("");
        }

        if (passwordID.getText().isBlank()) {
            passwordErrorMessageID.setText("Password Is Required");
            passwordErrorMessageID.setPrefHeight(40.0);
            passwordID.getStyleClass().add("error");
            isValid = false;
        } else {
            passwordID.getStyleClass().remove("error");
            passwordErrorMessageID.setPrefHeight(0.0);
            passwordErrorMessageID.setText("");
        }

        if (isValid) {
            System.out.println("LOGIN");
            System.out.println("username : "+ usernameID.getText());
            System.out.println("password : "+ passwordID.getText());
            System.out.println("hashed password : "+ DigestUtils.sha256Hex(passwordID.getText()));


            Compte compte = userModel.login(usernameID.getText() , passwordID.getText());
            if (compte == null) {
                System.out.println("ERROR IN LOGIN");
                Alert alert = new Alert(Alert.AlertType.ERROR, "", ButtonType.OK);
                alert.setTitle("Se Connecter");
                alert.setHeaderText("Identifiant ou mot de passe incorrect");
                alert.showAndWait();

                if (alert.getResult() == ButtonType.OK) {
                    System.out.println("OK");
                }

            } else {
                System.out.println("SUCCESS IN LOGIN");
                System.out.println(compte);

                SessionUtils.addCurrentUser(compte);
                this.switchView("user-home-view");
            }
        }
//        this.switchView("add-user-view");

    }

    public void onForgotPasswordClick(ActionEvent actionEvent) {
        this.switchView("forgot-password-view");
    }

    public void onInscriptionClick(ActionEvent actionEvent) {
        this.switchView("choose-inscription-view");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        SessionUtils.clearSession();
    }
}