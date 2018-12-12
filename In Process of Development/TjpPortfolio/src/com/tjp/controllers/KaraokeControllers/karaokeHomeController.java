package com.tjp.controllers.KaraokeControllers;


import com.tjp.Karaoke.models.SongBook;
import com.tjp.Karaoke.models.SongRequest;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import java.util.Queue;
import java.util.ResourceBundle;


public class karaokeHomeController implements Initializable{

    private SongBook mSongBook;
    private StringProperty mDisplaySongCount;
    private Queue<SongRequest> mSongRequests;
    private MediaPlayer player;
    private String VUrl;
    private int homeWidth = 1080;
    private int homeHeight = 920;
    private int fsWidth = 1920;
    private int fsHeight = 1080;


 /*   @FXML
    private WebView karaokeView; */
    @FXML
    private MediaView karaokeView;

    public karaokeHomeController() {
        mSongBook = new SongBook();
        mSongBook.importFrom("songs.txt");
        mDisplaySongCount = new SimpleStringProperty();
        setDisplaySongCount("Songs Available: " + mSongBook.getSongCountString());
        VUrl = "file:/D:/Downloads/VideoDownloads/mjBJ.mp4";
    }

    public String getDisplaySongCount(){
        return mDisplaySongCount.get();
    }

    public void setDisplaySongCount(String count){
        mDisplaySongCount.set(count);
    }

    public StringProperty displaySongCountProperty(){
        return mDisplaySongCount;
    }


    public void  initialize(URL location, ResourceBundle resources){
        player = new MediaPlayer(new Media(VUrl));

        karaokeView.setFitHeight(600);
        karaokeView.setFitWidth(500);
        karaokeView.setMediaPlayer(player);
    }

    public void handlePlayNext(){
      player.stop();
      VUrl = "file:/D:/Downloads/VideoDownloads/mjMITM.mp4";
      player = new MediaPlayer(new Media(VUrl));
      karaokeView.setMediaPlayer(player);
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
    public void handleFullScreen(ActionEvent event) throws Exception{
        player.stop();
        changeScene(event, "/fxml/karaoke/karaokeFullScreen.fxml",fsWidth,fsHeight);
    }




      public void homeButton(ActionEvent actionEvent) throws Exception{
          player.stop();
         changeScene(actionEvent,"/fxml/home.fxml", homeWidth,homeHeight);
      }

    private void changeScene(ActionEvent event, String newSceneFile, int width, int height) throws Exception{
        Parent newSceneView = FXMLLoader.load(getClass().getResource(newSceneFile));
        Scene newScene = new Scene(newSceneView, width,height);

        //get stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.centerOnScreen();
        window.show();
    }

}
