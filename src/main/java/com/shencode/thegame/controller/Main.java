package com.shencode.thegame.controller;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main extends Application {

	public static final String FXML_LOCATION = "../view/";
	
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    
	private final String STARTING_FXML = "Start.fxml";

	@Override
	public void start(Stage primaryStage) throws IOException{

		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(FXML_LOCATION + STARTING_FXML));
    	Parent page = loader.load();
    	Stage stage = new Stage();
    	Scene scene = new Scene(page);
    	stage.setScene(scene);
    	stage.setResizable(false);
    	((Controller) loader.getController()).setStage(stage);;
    	stage.show();
		
	} 

	public static void main(String[] args) {
		logger.info("Main launched.");
		launch(args);
	}
}
