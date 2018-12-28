package com.tjp.controllers.homeControllers;

import com.tjp.controllers.ScreenController;
import javafx.event.ActionEvent;

public class TeacherHomeController {

    private ScreenController screenController;

    public TeacherHomeController(){
        screenController = new ScreenController();

    }

    public void handleLogOut(ActionEvent actionEvent) throws Exception{
        screenController.changeScene(actionEvent,"/fxml/login.fxml");
    }
}
