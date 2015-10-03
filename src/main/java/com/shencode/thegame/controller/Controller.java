package com.shencode.thegame.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shencode.thegame.model.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@FXML
	private Label versionLabel;

	protected Parent page;
	protected Scene scene;
	protected Stage stage;
	protected Stage prevStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        logger.info("Controller Initialized");
		versionLabel.setText(Data.getVersion());
		// Set Version Label to CENTER
	}

	protected void switchScene(String fxmlLocation) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Controller.class.getResource(Main.FXML_LOCATION + fxmlLocation));
		page = loader.load();
		stage = new Stage();
		scene = new Scene(page);
		stage.setScene(scene);
		((Controller) loader.getController()).setStage(stage);
		stage.show();
		prevStage.close();
	}

	protected void setStage(Stage stage) {
		this.prevStage = stage;
	}
}
