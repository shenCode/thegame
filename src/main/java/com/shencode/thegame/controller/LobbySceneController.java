package com.shencode.thegame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shencode.thegame.multiplayer.LanWrapper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LobbySceneController extends Controller implements Initializable {

	private static final Logger logger = LoggerFactory.getLogger(LobbySceneController.class);

    @FXML
	private Button backButton, startButton, joinServer, createServer;
    
    @FXML
    private TextField ipField;

    private LanWrapper lan;

    public void initialize(URL location, ResourceBundle resources) {
        logger.info("LobbyController Initialized");
        try {
            lan = new LanWrapper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startEvent(ActionEvent event) throws IOException {
        final String nextScene = "517Flow.fxml";

        logger.info("Start Event Handler");
        logger.debug(String.format("Switching to scene: %s", nextScene));
        switchScene(nextScene);
    }

	public void backEvent(ActionEvent event) throws IOException {
        final String nextScene = "Start.fxml";

        logger.info("Start Event Handler");
        logger.debug(String.format("Switching to scene: %s", nextScene));
        switchScene(nextScene);
	}

    public void startServer(ActionEvent event) throws IOException {
    	ipField.setText(lan.getServerIp());
    	ipField.setEditable(false);
    	createServer.setDisable(true);
    	joinServer.setDisable(true);
        lan.startServer();
    }

    public void startClient(ActionEvent event) throws IOException {
    	String serverIp = ipField.getText();
        lan.startClient(serverIp);
    }
}
