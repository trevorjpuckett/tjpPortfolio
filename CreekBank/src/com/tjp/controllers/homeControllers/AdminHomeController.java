package com.tjp.controllers.homeControllers;

import com.tjp.controllers.ScreenController;
import javafx.event.ActionEvent;


public class AdminHomeController {

        private ScreenController screenController;


        public AdminHomeController(){
            screenController = new ScreenController();

        }

        public void handleLogOut(ActionEvent actionEvent) throws Exception{
            screenController.changeScene(actionEvent,"/fxml/login.fxml");
        }

    public void handleRegister(ActionEvent actionEvent) throws Exception{
        screenController.changeScene(actionEvent,"/fxml/register.fxml");
    }

}
