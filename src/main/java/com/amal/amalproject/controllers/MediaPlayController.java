package com.amal.amalproject.controllers;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.amal.amalproject.MainApplication;
import com.amal.amalproject.entities.Formation;
import com.amal.amalproject.entities.Video;
import com.amal.amalproject.models.FormationModel;
import com.amal.amalproject.models.TutorielModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.stage.*;
import javafx.stage.FileChooser.ExtensionFilter;

public class MediaPlayController implements Initializable {

	@FXML
	private Button btnImpor;
	@FXML
	private Button btn2;

	@FXML
	private Button back;
	
	@FXML
	private MediaView mediaView;
	private File file;
	private Media media;
	private MediaPlayer mediaPlayer;
	@FXML
	private Stage stage;

	TutorielModel tutorielModel = new TutorielModel();
	int ID;


	
	@FXML
	public void backCLICK(ActionEvent event) {

		try {

			if (event.getSource() == back) {
				stage = (Stage) back.getScene().getWindow();

				FXMLLoader fxmlLoader = new FXMLLoader(
						MainApplication.class.getResource("GestionTutorielFormationView.fxml"));
				Scene scene = new Scene(fxmlLoader.load(), 800, 600);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.initStyle(StageStyle.UTILITY);
				stage.show();
			}
		} catch (IOException ex) {
			Logger.getLogger(ProfilFormation.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	@FXML
	public void close(ActionEvent event) {
		System.exit(0);

	}
	
	@FXML
	public void play(ActionEvent event) {
		mediaPlayer.play();
	}
	
	

	@FXML
	public void pause(ActionEvent event) {

		mediaPlayer.pause();
	}

	@FXML
	public void stop(ActionEvent event) {
		mediaPlayer.seek(mediaPlayer.getStopTime());
		mediaPlayer.stop();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		// TODO Auto-generated method stub

		String path = new File("src/main/resources/com/amal/amalproject/videos/handicapetscolarité.mp4")
				.getAbsolutePath();
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.setAutoPlay(false);

	};

}
