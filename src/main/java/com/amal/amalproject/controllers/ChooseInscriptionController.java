package com.amal.amalproject.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class ChooseInscriptionController extends SharedController {

    public void onInscriptionAction(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        String data = (String) node.getUserData();

        switch (data) {
            case "USER_MEDECIN" :
                System.out.println("REGISTER : USER_MEDECIN");
                this.switchView("add-medecin-view");
                break;
            case "USER_ORGANIZATION" :
                System.out.println("REGISTER : USER_ORGANIZATION");
                this.switchView("add-organization-view");
                break;
            case "USER_BENEVOLE" :
                System.out.println("REGISTER : USER_BENEVOLE");
                this.switchView("add-benevole-view");
                break;
            case "USER_BENEFICIER" :
                System.out.println("REGISTER : USER_BENEFICIER");
                this.switchView("add-beneficier-view");
                break;
            default:
                System.out.println("unknown register account");
        }
    }

    public void OnLogInAction(ActionEvent actionEvent) {
        this.switchView("login-view");
    }
}
