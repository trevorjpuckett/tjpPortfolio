package com.tjp.controllers;

import javafx.event.ActionEvent;

public class RegisterController {

    private ScreenController screenController;

    public RegisterController(){

        screenController = new ScreenController();

    }

    public void handleBack(ActionEvent actionEvent) throws Exception{
        screenController.changeScene(actionEvent,"/fxml/login.fxml");
    }


}
