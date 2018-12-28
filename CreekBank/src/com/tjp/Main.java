package com.tjp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;


// colors are brown and green
public class Main extends Application{

     @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.setTitle("Creek Bank");
        primaryStage.setScene(new Scene(root, 1080, 920));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
