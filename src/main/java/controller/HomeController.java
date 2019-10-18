package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class HomeController {
    @FXML
    private AnchorPane topbar;

    @FXML
    private AnchorPane bottombar;

    @FXML
    private AnchorPane LoginOverlay;

    @FXML
    private AnchorPane RegisterOverlay;

    @FXML
    private AnchorPane SearchOverlay;

    public void loginLink() {
        LoginOverlay.setVisible(true);
        LoginOverlay.setDisable(false);
        topbar.setDisable(true);
        bottombar.setDisable(true);
    }

    public void loginBackButton() {
        LoginOverlay.setVisible(false);
        LoginOverlay.setDisable(true);
        topbar.setDisable(false);
        bottombar.setDisable(false);
    }

    public void registerLink() {
        RegisterOverlay.setVisible(true);
        RegisterOverlay.setDisable(false);
        topbar.setDisable(true);
        bottombar.setDisable(true);
    }

    public void registerBackButton() {
        RegisterOverlay.setVisible(false);
        RegisterOverlay.setDisable(true);
        topbar.setDisable(false);
        bottombar.setDisable(false);
    }

    public void searchButton(){
        SearchOverlay.setVisible(true);
        SearchOverlay.setDisable(false);
        topbar.setDisable(true);
        bottombar.setDisable(true);
    }

    public void searchBackButton(){
        SearchOverlay.setVisible(false);
        SearchOverlay.setDisable(true);
        topbar.setDisable(false);
        bottombar.setDisable(false);
    }

}
