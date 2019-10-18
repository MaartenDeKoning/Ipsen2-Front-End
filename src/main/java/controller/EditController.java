package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import model.EditModel;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * EditController.java is the logic behind editing projects in our database
 * @author  Jesse Minneboo
 * @version 1.0
 */

public class EditController implements Initializable {
    @FXML
    private ComboBox<String> taal;
    @FXML
    private ComboBox<String> studierichting;
    @FXML
    private ComboBox<String> vak;
    @FXML
    private Label errorMessage;
    @FXML
    private TextField titleTextField;
    @FXML
    private ToggleGroup radioToggle;
    @FXML
    private RadioButton radioButtonOne;
    @FXML
    private ListView PdfListView;
    @FXML
    private TextField tagsList;

    /**
     * Initializes everything after the FXML file has been read
     * @param location Basic Initialize implementing parameters
     * @param resources Basic Initialize implementing parameters
     */
    public void initialize(URL location, ResourceBundle resources) {
        addElementsToComboBox(taal, studierichting, vak);
        //WE SHOULD CHANGE THIS TO THE SELECT STATE FROM OUR DATABASE
        radioButtonOne.setSelected(true);
    }

    /**
     * Logic for adding all elements to our ComboBoxes
     * @param taal List with all the langueages
     * @param studierichting List with all the fields of study
     * @param vak List with all the subjects
     */
    public void addElementsToComboBox(ComboBox<String>taal, ComboBox<String>studierichting, ComboBox<String>vak){
        ObservableList<String> talen = FXCollections.observableArrayList("Nederlands", "Engels");
        ObservableList<String> studierichtingen = FXCollections.observableArrayList("Psychologie", "Bouwkunde");
        ObservableList<String> vakken = FXCollections.observableArrayList("Wiskunde","Biologie");

        taal.setItems(talen);
        studierichting.setItems(studierichtingen);
        vak.setItems(vakken);
    }

    /**
     * Logic for the "go back" button
     * @param actionEvent Basic FXML parameter
     */
    public void backButtonCLick(ActionEvent actionEvent) {
        System.out.println("Back button has been clicked!");
    }


    /**
     * Method for all the edit logic. Also catches all mistakes a person can make within the form
     * @param actionEvent Basic FXML parameter
     */
    public void finishButtonClick(ActionEvent actionEvent) {
        EditModel model = new EditModel();
        boolean isTalenEmpty, isStudierichtingenEmpty, isVakkenEmpty, isTitleEmpty;
        isTalenEmpty = taal.getSelectionModel().isEmpty();
        isStudierichtingenEmpty = studierichting.getSelectionModel().isEmpty();
        isVakkenEmpty = vak.getSelectionModel().isEmpty();
        isTitleEmpty = titleTextField.getText().trim().isEmpty();

        /**
         * Checking if the user doesn't upload something without information
         */
        if(!(isTalenEmpty || isStudierichtingenEmpty || isVakkenEmpty || isTitleEmpty)){
            //Testing purposes
            errorMessage.setText("Alles is nu goed ingevuld! Een moment A.U.B.");
            errorMessage.setTextFill(Paint.valueOf("#00ff00"));

            //Actual saving
            String title = titleTextField.getText();
            String langauge = taal.getSelectionModel().getSelectedItem();
            String subject = vak.getSelectionModel().getSelectedItem();
            String fieldOfStudy = studierichting.getSelectionModel().getSelectedItem();
            String tags = tagsList.getText();

            //getting the name from a radio button
            RadioButton selectedRadioButton = (RadioButton) radioToggle.getSelectedToggle();
            String category = selectedRadioButton.getText();
            if(!PdfListView.getItems().isEmpty()) {
                String pathForFile = PdfListView.getItems().get(0).toString();
                model.saveAllElements(title, langauge, subject, fieldOfStudy, tags, category, pathForFile);
            }else {
                model.saveAllElements(title, langauge, subject, fieldOfStudy, tags, category, null);
            }

        }else{
            errorMessage.setText("Een van de invoervelden is NIET ingevuld. Probeer het opniew.");
            errorMessage.setTextFill(Paint.valueOf("#ff0000"));
        }
    }


    /**
     * Logic for uploading a file
     * @param actionEvent Basic FXML parameter
     */
    public void uploadFileButtonClick(ActionEvent actionEvent) {
        System.out.println("Upload button has been clicked!");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null && PdfListView.getItems().size() < 1){
            PdfListView.getItems().add(selectedFile.getAbsolutePath());
            System.out.println(selectedFile.getAbsolutePath());
        }else if(PdfListView.getItems().size() == 1){
            PdfListView.getItems().remove(0);
            PdfListView.getItems().add(selectedFile.getAbsolutePath());
            errorMessage.setText("Uw bestand is vervangen door: " + selectedFile.getName());
            errorMessage.setTextFill(Paint.valueOf("#00ff00"));
        }else{
            errorMessage.setText("Er is iets fout met uw Pdf. Probeer het opnieuw.");
        }
    }

    /**
     * Logix for deleting a file
     * @param actionEvent Basic FXML parameter
     */
    public void deleteFileButtonClick(ActionEvent actionEvent) {
        System.out.println("Delete button has been clicked!");
    }
}
