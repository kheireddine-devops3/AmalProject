package com.amal.amalproject.controllers;

import com.amal.amalproject.entities.Beneficier;
import com.amal.amalproject.entities.Compte;
import com.amal.amalproject.entities.Organization;
import com.amal.amalproject.models.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddOrganizationController extends SharedController implements Initializable {

    @FXML
    public TextField matriculeID;
    @FXML
    public Label errorMatriculeID;
    @FXML
    private ComboBox<String> formJuridiqueID;
    @FXML
    private Label errorFormJuridiqueID;
    @FXML
    private Label errorLoginID;
    @FXML
    private Label errorPasswordID;
    @FXML
    private Label errorNameID;
    @FXML
    private Label errorEmailID;
    @FXML
    private Label errorTelephoneID;
    @FXML
    private Label errorAdresseID;
    @FXML
    private TextField nameID;
    @FXML
    private TextField loginID;
    @FXML
    private PasswordField passwordID;
    @FXML
    private TextField emailID;
    @FXML
    private TextField telephoneID;
    @FXML
    private TextField adresseID;

    private UserModel userModel = new UserModel();


    @FXML
    protected void onAddOrganizationClick() {

        if (isValidOrganization()) {
            /******************************** Start Entity Compte ********************************/
            Compte compte = new Compte();
            compte.setLogin(loginID.getText());
            compte.setPassword(passwordID.getText());
            compte.setRole("ROLE_ORGANIZATION");
            compte.setStatus("ACTIVE");
            System.out.println(compte);
            /******************************** End Entity Compte ********************************/
            /******************************** Start Entity Organization ********************************/

            Organization organization = new Organization();
            organization.setNom(nameID.getText());
            organization.setEmail(emailID.getText());
            organization.setAdresse(adresseID.getText());
            organization.setFormJuridique(formJuridiqueID.getValue());
            organization.setMatriculeFiscale(matriculeID.getText());
            organization.setNumPhone(telephoneID.getText());
            organization.setCompte(compte);

            System.out.println(organization);

            Organization savedOrganization = userModel.addOrganization(organization);

            if (savedOrganization != null) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vous avez terminé avec succès le processus d'inscription\ncliquer sur ok puis s'authentifiez par votre login et mot de passe", ButtonType.OK);
                alert.setTitle("Inscription");
                alert.setHeaderText("Inscription effectuée avec succès");
                alert.showAndWait();

                if (alert.getResult() == ButtonType.OK) {
                    System.out.println("OK");
                    this.switchView("login-view");
                }

            }
            /******************************** End Entity Organization ********************************/
        } else {
            System.out.println("INVALIDE");
        }
    }

    private boolean isValidOrganization() {
        boolean isValidLogin = false;
        boolean isValidPassword = false;
        boolean isValidName = false;
        boolean isValidEmail = false;
        boolean isValidTelephone = false;
        boolean isValidAdresse = false;
        boolean isValidFormJuridique = false;
        boolean isValidMatriculeFiscale = false;

        String login = loginID.getText();
        String password = passwordID.getText();
        String name = nameID.getText();
        String email = emailID.getText();
        String telephone = telephoneID.getText();
        String adresse = adresseID.getText();
        String formJuridique = formJuridiqueID.getValue();
        String matricule = matriculeID.getText();


        Pattern loginPattern = Pattern.compile("^(?=[a-zA-Z0-9._]{4,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
        Matcher loginMatcher = loginPattern.matcher(login);
        if (login.isBlank()) {
            errorLoginID.setText("Le nom d'utilisateur est obligatoire");
            isValidLogin = false;
        } else if (!loginMatcher.matches()) {
            errorLoginID.setText("Le nom d'untilisateur doit contenir entre 4 et 20 caractères · doit contenir des chiffres et des lettres");
            isValidLogin = false;
        } else if (userModel.existsCompteByLogin(login)) {
            errorLoginID.setText("Ce nom d'utilisateur est déjà utilisé");
            isValidLogin = false;
        } else {
            errorLoginID.setText("");
            isValidLogin = true;
        }

        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (password.isBlank()) {
            errorPasswordID.setText("Le mot de passe est obligatoire");
            isValidLogin = false;
        } else if(!passwordMatcher.matches()) {
            errorPasswordID.setText("Le mot de passe doit contenir au minimum 8 caractères,\nau moins une lettre minuscule et une lettre majuscule, un caractère spécial et un chiffre.");
            isValidPassword = false;
        } else {
            errorPasswordID.setText("");
            isValidPassword = true;
        }


        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (email.isBlank()) {
            errorEmailID.setText("Email est obligatoire");
            isValidEmail = false;
        } else if (!emailMatcher.matches()) {
            errorEmailID.setText("Email n'est pas valide");
            isValidEmail = false;
        } else if (userModel.existsUserByEmail(email)) {
            errorEmailID.setText("Cette adresse e-mail est déjà utilisée");
            isValidEmail = false;
        } else {
            errorEmailID.setText("");
            isValidEmail = true;
        }

        Pattern telephonePattern = Pattern.compile("^[1-9][0-9]{7}$");
        Matcher telephoneMatcher = telephonePattern.matcher(telephone);
        if (telephone.isBlank()) {
            errorTelephoneID.setText("Numero de telephone est obligatoire");
            isValidTelephone = false;
        } else if (!telephoneMatcher.matches()) {
            errorTelephoneID.setText("Numero de telephone n'est pas valide");
            isValidTelephone = false;
        }  else if (userModel.existsUserByTelephone(telephone)) {
            errorTelephoneID.setText("Ce numéro de téléphone est déjà utilisé");
            isValidTelephone = false;
        } else {
            errorTelephoneID.setText("");
            isValidTelephone = true;
        }

        if (adresse.isBlank()) {
            errorAdresseID.setText("Adresse est obligatoire");
            isValidAdresse = false;
        } else {
            errorAdresseID.setText("");
            isValidAdresse = true;
        }

        if (name.isBlank()) {
            errorNameID.setText("Nom de l'organization est obligatoire");
            isValidName = false;
        } else {
            errorNameID.setText("");
            isValidName = true;
        }

        if (matricule.isBlank()) {
            errorMatriculeID.setText("Matricule est obligatoire");
            isValidMatriculeFiscale = false;
        }
//        else if (userModel.(matricule)) {
//            errorMatriculeID.setText("Ce matricule est déjà utilisé");
//            isValidMatriculeFiscale = false;
//        }
        else {
            errorMatriculeID.setText("");
            isValidMatriculeFiscale = true;
        }

        if (formJuridique == null) {
            errorFormJuridiqueID.setText("Form Juridique est obligatoire");
            isValidFormJuridique = false;
        } else {
            errorFormJuridiqueID.setText("");
            isValidFormJuridique = true;
        }

        System.out.println("isValidLogin : " + isValidLogin);
        System.out.println("isValidPassword : " + isValidPassword);
        System.out.println("isValidName : " + isValidName);
        System.out.println("isValidEmail : " + isValidEmail);
        System.out.println("isValidTelephone : " + isValidTelephone);
        System.out.println("isValidAdresse : " + isValidAdresse);
        System.out.println("isValidFormJuridique : " + isValidFormJuridique);
        System.out.println("isValidMatriculeFiscale : " + isValidMatriculeFiscale);


        return  (isValidLogin && isValidPassword &&  isValidName &&  isValidEmail && isValidTelephone && isValidAdresse && isValidFormJuridique && isValidMatriculeFiscale);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("AddOrganizationController.initialize()");
    }

    public void onRetourClick(ActionEvent actionEvent) {
        this.switchView("choose-inscription-view");
    }

}

