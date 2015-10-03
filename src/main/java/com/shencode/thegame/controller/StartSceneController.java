package com.shencode.thegame.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shencode.thegame.model.Player;

import java.io.IOException;

public class StartSceneController extends Controller implements Initializable {

	private static final Logger logger = LoggerFactory.getLogger(StartSceneController.class);
    private Player player;

	@FXML
	private Button startButton, exitButton;

	@FXML
	private TextField usernameField;

	public void startEvent(ActionEvent event) throws IOException {
        final String nextScene = "Lobby.fxml";

        logger.info("Start Event Handler");
        logger.debug(String.format("Switching to scene: %s", nextScene));

        player = new Player(usernameField.getText());
		switchScene(Main.FXML_LOCATION + nextScene);
	}

	public void exitEvent(ActionEvent event) {
		Platform.exit();
		logger.info("Exiting Application");
	}
}
