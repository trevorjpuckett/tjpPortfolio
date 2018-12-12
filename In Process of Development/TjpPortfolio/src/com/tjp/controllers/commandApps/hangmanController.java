package com.tjp.controllers.commandApps;

import com.tjp.consolePrograms.Hangman.Game;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class hangmanController {


    private List<String> consoleViewHistory;

    private int homeWidth ;
    private int homeHeight;
    private String homeUrl;

    private Game game = new Game("Test");

    @FXML
    private TextField consoleUserSide;

    public hangmanController(){

        homeWidth = 1080;
        homeHeight = 920;
        homeUrl = "/fxml/home.fxml";
        consoleViewHistory = new ArrayList<>();



    }

    public void textFieldAction(){

    }

    public void handleHome(ActionEvent actionEvent) throws Exception{
        changeScene(actionEvent,homeUrl, homeWidth,homeHeight);
    }


    private void changeScene(ActionEvent event, String newSceneFile, int homeWidth, int homeHeight) throws Exception{
        Parent newSceneView = FXMLLoader.load(getClass().getResource(newSceneFile));
        Scene newScene = new Scene(newSceneView, homeWidth,homeHeight);

        //get stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }
}
