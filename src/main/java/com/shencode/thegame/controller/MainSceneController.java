package com.shencode.thegame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainSceneController extends Controller implements Initializable {

	private static final Logger logger = LoggerFactory.getLogger(MainSceneController.class);

	@FXML
	private TabPane tabPane;
	
	@FXML
	private Tab mapTab;
	
	public void switchToMap(ActionEvent event) {
		tabPane.getSelectionModel().select(mapTab);
	}
}
