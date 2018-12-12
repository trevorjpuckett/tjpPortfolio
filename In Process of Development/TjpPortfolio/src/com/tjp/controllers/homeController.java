package com.tjp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class homeController {

    private String pomodoroSceneLocation;
    private String karaokeSceneLocation;
    private String hangmanLocation;

    @FXML
    private WebView resumeView;

    public homeController(){
        pomodoroSceneLocation = "/fxml/pomodoro/pomodoroHome.fxml";
        karaokeSceneLocation = "/fxml/karaoke/karaokeHome.fxml";
        hangmanLocation = "/fxml/commandApps/hangman.fxml";
    }

    private void changeScene(ActionEvent event, String newSceneFile) throws Exception{
        Parent newSceneView = FXMLLoader.load(getClass().getResource(newSceneFile));
        Scene newScene = new Scene(newSceneView, 1080,920);

        //get stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }
    public void handleKaraoke(ActionEvent actionEvent) throws Exception{
        changeScene(actionEvent, karaokeSceneLocation);
    }

    public void handlePomodoro(ActionEvent actionEvent) throws Exception{
        changeScene(actionEvent, pomodoroSceneLocation);
    }

    public void handleHangman(ActionEvent actionEvent) throws Exception{
        changeScene(actionEvent, hangmanLocation);
    }

    public void initialize(){
        WebEngine webEngine = resumeView.getEngine();
      //  webEngine.load(getClass().getResource("/resume/Resume1.htm").toExternalForm());
       // webEngine.load("https://www.dreamincode.net/forums/topic/396236-displayingshowing-ms-office-files-in-javafx-application/");
        webEngine.load("file:///D:/Documents/Word/Resume1.htm");
    }


}
