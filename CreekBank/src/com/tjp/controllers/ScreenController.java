package com.tjp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Map;

public class ScreenController {

    private int width;
    private int height;
    private Map<String, String> sceneMap;

    public ScreenController(){
        width = 1080;
        height = 920;

        //sceneMap.put("login","/fxml/login.fxml");
        //sceneMap.put("adminHome","/fxml/adminHome.fxml");
    }

    public void changeScene(ActionEvent event, String newSceneFile) throws Exception{
        //String newSceneFile = sceneMap.get(newSceneName);
        Parent newSceneView = FXMLLoader.load(getClass().getResource(newSceneFile));
        Scene newScene = new Scene(newSceneView, width,height);

        //get stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    public void closeWindow(ActionEvent event){
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

}
