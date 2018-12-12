package com.tjp.controllers.KaraokeControllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class karaokeFullScreenController implements Initializable {

    private MediaPlayer player;


    public karaokeFullScreenController(){

    }

    @FXML
    private MediaView karaokeFullScreenView;

    public void  initialize(URL location, ResourceBundle resources){
        String VUrl = "file:/D:/Downloads/VideoDownloads/mjBJ.mp4";
        player = new MediaPlayer(new Media(VUrl));

        karaokeFullScreenView.setFitHeight(1000);
        karaokeFullScreenView.setFitWidth(1900);
        karaokeFullScreenView.setMediaPlayer(player);
    }
    @FXML
    public void handlePause(ActionEvent event){
        player.pause();
    }

    @FXML
    public void handlePlay(ActionEvent event){
        player.play();
    }

    @FXML
    public void handleRestart(ActionEvent event){
        player.stop();
        player.play();
    }

    @FXML
    public void handleExitFullScreen(ActionEvent event) throws Exception{
        player.stop();
        changeScene(event, "/fxml/karaoke/karaokeHome.fxml");
    }
    private void changeScene(ActionEvent event, String newSceneFile) throws Exception{
        Parent newSceneView = FXMLLoader.load(getClass().getResource(newSceneFile));
        Scene newScene = new Scene(newSceneView, 1080,920);

        //get stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.centerOnScreen();
        window.show();
    }

}
