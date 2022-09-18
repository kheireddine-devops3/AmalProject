package com.amal.amalproject.controllers;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.amal.amalproject.entities.Candidature;
import com.amal.amalproject.entities.Emploi;
import com.amal.amalproject.models.CandidatureModel;
import com.amal.amalproject.models.EmploiModel;
import com.amal.amalproject.utils.Navigate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class CandidatureController implements Initializable {

    @FXML
    private ComboBox<String> combretude;

    @FXML
    private TextField txtetude;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtmail;

    @FXML
    private Button btnimportcv;

    @FXML
    private TextField txturlcv;

    @FXML
    private Button btnconfirm;

    @FXML
    private Button btnannulerc;
    
    //EmploiModel empModel = new EmploiModel();
    CandidatureModel candModel=new CandidatureModel();
	private Emploi emp ;
	
    @FXML
    void OnAnnuler(ActionEvent event) throws IOException {
    	Navigate.changerScene(event, "ListOffres.fxml", "Liste des offres");
    }

    @FXML
    void OnConfirmer(ActionEvent event) throws IOException {
     if (isInputValid()){

    	 Candidature cand =new Candidature(emp.getId_emploi(),1,emp.getDate_expiration(),txturlcv.getText(),txtetude.getText());
    	
     candModel.add(cand);
     
     Navigate.changerScene(event, "ListOffres.fxml", "Liste des offres");
    }
    }

    @FXML
    void selectChoix(ActionEvent event) {
    	String choix = combretude.getSelectionModel().getSelectedItem().toString();
    	if((choix.equals("Autre")))
		 txtetude.setText("");
    	else {
    		txtetude.setText(choix);
    	}
    }
    @FXML
    void OnImporter(ActionEvent event) {
     FileChooser fc =new FileChooser();
     fc.setInitialDirectory(new File("C:\\Users\\Hasni\\Desktop\\WEB\\HTML\\CV_Sabrine_HASNI _JS\\doc"));
     fc.getExtensionFilters().addAll( new ExtensionFilter("PDF Files","*.pdf"));
     File selectedFile=fc.showOpenDialog(null);
     if(selectedFile!=null) {
    	 txturlcv.setText(selectedFile.getAbsolutePath());
     }
     
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		ObservableList<String> listrech = FXCollections.observableArrayList("Niveau scolair","BTP", "BTS", "BAC+3", "BAC+5",
				"Autre");
		combretude.setItems(listrech);
		
	}
	
	
	
	public void getFields(Emploi e) {
	
		emp =new Emploi(e.getId_emploi(),e.getRef_emploi(),e.getDate_expiration());
		
	}


	public boolean isInputValid(){

		String errorMessage = "";

		if (txtetude.getText() == null || txtetude.getText().length() == 0){
			errorMessage += " Niveau d'etude est obligatoire!\n";
		}

		if (txtnom.getText() == null || txtnom.getText().length() == 0){
			errorMessage += "Nom invalid!\n";
		}
		if (txtprenom.getText() == null || txtprenom.getText().length() == 0){
			errorMessage += "Prenom invalide!\n";
		}
		if (txtmail.getText() == null || txtmail.getText().length() == 0){
			errorMessage += "Adresse mail invalide!\n";
		}
		if (txturlcv.getText() == null || txturlcv.getText().length() == 0){
			errorMessage += " Attachement de cv est  obligatoire!\n";
		}


		if (errorMessage.length() == 0){
			return true;
		}else{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Veuillez corriger les champs invalide");
			alert.setContentText(errorMessage);
			alert.showAndWait();
			return false;
		}

	}


}
