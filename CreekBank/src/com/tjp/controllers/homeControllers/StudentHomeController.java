package com.tjp.controllers.homeControllers;

import com.tjp.controllers.ScreenController;
import javafx.event.ActionEvent;

public class StudentHomeController {

    private ScreenController screenController;

    public StudentHomeController(){
        screenController = new ScreenController();

    }

    public void handleLogOut(ActionEvent actionEvent) throws Exception{
        screenController.changeScene(actionEvent,"/fxml/login.fxml");
    }
}
