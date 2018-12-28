package com.tjp.controllers;

import com.tjp.DatabaseConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class LoginController {

    private DatabaseConnection dbc;
    private ScreenController screenController;

    private StringProperty usernameStatus;
    private StringProperty passwordStatus;

    private boolean usernameVerified;
    private boolean passwordVerified;

    private String mUsername;
    private String mPassword;

    private String mAuthorization;

    private String mColumnName;
    private String mTableName;

    @FXML
    private TextField usernamePrompt;

    @FXML
    private TextField passwordPrompt;

    public LoginController(){
        dbc = new DatabaseConnection();
        screenController = new ScreenController();

        usernameStatus = new SimpleStringProperty();
        passwordStatus = new SimpleStringProperty();
        setUsernameStatus("");
        setPasswordStatus("");
        usernameVerified = false;
        passwordVerified = false;

    }

    public void handleLogin(ActionEvent actionEvent) throws Exception {
        mColumnName = "username";
        mTableName = "accounts";
        mUsername = usernamePrompt.getText();
        usernameVerified = dbc.verifyUsername(mUsername,mColumnName,mTableName);
        mPassword = passwordPrompt.getText();
        passwordVerified = dbc.verifyPassword(mPassword, mUsername);

        if(usernameVerified && passwordVerified){
            mAuthorization = dbc.getAuthorization(mUsername);
            switch (mAuthorization) {
                case "admin":
                    screenController.changeScene(actionEvent, "/fxml/homeScreen/adminHome.fxml");
                    break;
                case "teacher":
                    screenController.changeScene(actionEvent, "/fxml/homeScreen/teacherHome.fxml");
                    break;
                case "student":
                    screenController.changeScene(actionEvent, "/fxml/homeScreen/studentHome.fxml");
                    break;
            }

        } else {
            if(!usernameVerified)
                setUsernameStatus("Username is incorrect");
                else
                    setUsernameStatus(" ");
            if(!passwordVerified)
                setPasswordStatus("Password is incorrect");
                else
                    setPasswordStatus(" ");
        }

    }



    public void handleExit(ActionEvent actionEvent){
        screenController.closeWindow(actionEvent);
    }




    public String getUsernameStatus() {
        return usernameStatus.get();
    }

    public StringProperty usernameStatusProperty() {
        return usernameStatus;
    }

    public void setUsernameStatus(String usernameStatusText) {
        usernameStatus.set(usernameStatusText);
    }

    public String getPasswordStatus() {
        return passwordStatus.get();
    }

    public StringProperty passwordStatusProperty() {
        return passwordStatus;
    }

    public void setPasswordStatus(String passwordStatusText) {
        passwordStatus.set(passwordStatusText);
    }



}
