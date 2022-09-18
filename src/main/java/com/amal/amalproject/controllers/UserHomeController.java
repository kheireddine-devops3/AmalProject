package com.amal.amalproject.controllers;

import com.amal.amalproject.MainApplication3;
import com.amal.amalproject.entities.Compte;
import com.amal.amalproject.models.UserModel;
import com.amal.amalproject.utils.SessionUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.amal.amalproject.utils.MenuEnum;

public class UserHomeController extends SharedController implements Initializable {

    private UserModel userModel = new UserModel();
    @FXML
    public ScrollPane viewsID;
    @FXML
    public Label fullnameID;
    @FXML
    public VBox sidebarID;

    public void onMenuItemAction(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        MenuEnum data = MenuEnum.valueOf((String) node.getUserData());

        switch (data) {
            case MENU_RENDEZ_VOUS_VIEW :
                System.out.println("MENU_RENDEZ_VOUS_VIEW");
                this.viewsID.setContent(MainApplication3.includeView("rendez-vous-view"));
                break;
            case MENU_CHOOSE_INSCRIPTION_VIEW:
                System.out.println("MENU_CHOOSE_INSCRIPTION_VIEW");
                this.viewsID.setContent(MainApplication3.includeView("choose-inscription-view"));
                break;
            case MENU_INSCRIPTION_DOCTOR_VIEW:
                System.out.println("MENU_INSCRIPTION_DOCTOR_VIEW");
                this.viewsID.setContent(MainApplication3.includeView("add-medecin-view"));
                break;
            case MENU_LOGIN_VIEW:
                System.out.println("MENU_ILOGIN_VIEW");
                this.viewsID.setContent(MainApplication3.includeView("login-view"));
                break;
            case MENU_EDIT_USER_VIEW:
                System.out.println(MenuEnum.MENU_EDIT_USER_VIEW);
                this.viewsID.setContent(MainApplication3.includeView("edit-user-view"));
                break;
            case MENU_SHOW_AIDES_VIEW:
                System.out.println(MenuEnum.MENU_SHOW_AIDES_VIEW);
                this.viewsID.setContent(MainApplication3.includeView("show-aides-view"));
                break;
            case MENU_ADMIN_DASHBOARD_VIEW:
                System.out.println(MenuEnum.MENU_ADMIN_DASHBOARD_VIEW);
                this.viewsID.setContent(MainApplication3.includeView("admin-dashboard-view"));
                break;
            default:
                System.out.println("MENU : PROBLEM");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Compte compte = SessionUtils.getCurrentUser();
        System.out.println(compte);

        if(compte == null) {
            compte = userModel.login("raja_mechergui","mkd.dev.1993.JS*");
            SessionUtils.addCurrentUser(compte);
        }

        if(compte != null) {
            this.fullnameID.setText(compte.getLogin());
            List<MenuItemButton> menuItemButtons = new ArrayList<>();

            switch (compte.getRole()) {
                case "ROLE_BENEFICIER":
                    menuItemButtons.addAll( List.of(
                            new MenuItemButton("Profile Management",MenuEnum.MENU_EDIT_USER_VIEW.toString())
                    ));
                    break;
                case "ROLE_DOCTOR":
                    menuItemButtons.addAll( List.of(
                            new MenuItemButton("Rendez-vous",MenuEnum.MENU_RENDEZ_VOUS_VIEW.toString()),
                            new MenuItemButton("Aides Management",MenuEnum.MENU_SHOW_AIDES_VIEW.toString()),
                            new MenuItemButton("Profile Management",MenuEnum.MENU_EDIT_USER_VIEW.toString())
                    ));
                    break;
                case "ROLE_ADMIN":
                    menuItemButtons.addAll( List.of(
                            new MenuItemButton("Dashboard",MenuEnum.MENU_ADMIN_DASHBOARD_VIEW.toString()),
                            new MenuItemButton("Rendez-vous Management",MenuEnum.MENU_RENDEZ_VOUS_VIEW.toString()),
                            new MenuItemButton("Aides Management",MenuEnum.MENU_SHOW_AIDES_VIEW.toString()),
                            new MenuItemButton("Profile Management",MenuEnum.MENU_EDIT_USER_VIEW.toString())
                    ));
                    break;
            }

            menuItemButtons.forEach(menuItemButton -> {
                Button button = new Button();
                button.setStyle("");
                button.setAlignment(Pos.CENTER_LEFT);
                button.setMaxWidth(Double.POSITIVE_INFINITY);
                button.setUserData(menuItemButton.getUserDate());
                button.setText(menuItemButton.getText());
                button.setOnAction(actionEvent -> {
                    try {
                        this.onMenuItemAction(actionEvent);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                this.sidebarID.getChildren().add(button);
            });
        }


    }

    @FXML
    public void OnLogOutAction(ActionEvent actionEvent) {
        SessionUtils.clearSession();
        this.switchView("login-view");
    }
}

class MenuItemButton {
    private String text;
    private String userDate;

    public MenuItemButton(String text, String userDate) {
        this.setText(text);
        this.setUserDate(userDate);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }
}
