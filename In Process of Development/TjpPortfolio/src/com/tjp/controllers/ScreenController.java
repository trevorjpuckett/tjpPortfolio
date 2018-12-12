package com.tjp.controllers;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenController {

    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    public ScreenController(Scene main){
        this.main = main;
    }
    protected void addScreen(String name, Pane pane){
        screenMap.put(name,pane);
    }
    protected void removeScreen(String name, Pane pane){
        screenMap.remove(name, pane);
    }
    protected void activate(String name){
        main.setRoot(screenMap.get(name));
    }
}