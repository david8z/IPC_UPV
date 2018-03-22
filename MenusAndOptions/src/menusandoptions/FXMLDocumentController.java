/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusandoptions;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author davidalarcon
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private RadioMenuItem amazonMenu;
    @FXML
    private ToggleGroup webSite;
    @FXML
    private RadioMenuItem bloggerMenu;
    @FXML
    private RadioMenuItem ebayMenu;
    @FXML
    private RadioMenuItem facebookMenu;
    @FXML
    private RadioMenuItem googleMenu;
    @FXML
    private RadioMenuItem shopMenuAmazon;
    @FXML
    private ToggleGroup shops;
    @FXML
    private RadioMenuItem shopMenuEbay;
    @FXML
    private Label label;
    @FXML
    private Button amazonButton;
    @FXML
    private Button bloggerButton;
    @FXML
    private Button ebayButton;
    @FXML
    private Button facebookButton;
    @FXML
    private Button googleButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void handleExit(ActionEvent event) {
        Stage stage = (Stage) label.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleAmazon(ActionEvent event) {
        
        if(shopMenuAmazon.isSelected()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("You have completed your purchase");
            alert.setContentText("You have bought in Amazon");
            alert.getButtonTypes().setAll(new ButtonType("OK"));
            alert.showAndWait();
            
        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Selection Error");
            alert.setHeaderText("You cannot buy in Amazon");
            alert.setContentText("Please, change the current selection in the Options menu");
            alert.getButtonTypes().setAll(new ButtonType("OK"));
            alert.showAndWait();
        }
        label.setText("");
        amazonButton.requestFocus();
        amazonMenu.setSelected(true);
    
    }
    
    @FXML
    private void handleEbay(ActionEvent event) {
        if(shopMenuEbay.isSelected()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("You have completed your purchase");
            alert.setContentText("You have bought in Ebay");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.OK_DONE));
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Selection Error");
            alert.setHeaderText("You cannot buy in Ebay");
            alert.setContentText("Please, change the current selection in the Options menu");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.OK_DONE));
            alert.showAndWait();
        }
        label.setText("");
        ebayButton.requestFocus(); 
        ebayMenu.setSelected(true);
    }
    
    @FXML
    private void handleBlogger(ActionEvent event) {
        
            List<String> choices = new ArrayList<>();
            choices.add("Athos' blog");
            choices.add("Porthos' blog");
            choices.add("Aramis' blog");
            
            ChoiceDialog<String> alert = new ChoiceDialog<>("Athos blog", choices);
            alert.setTitle("Select a blog");
            alert.setHeaderText("Which blog do you want to visit?");
            alert.setContentText("Choose:");
            alert.getDialogPane().getButtonTypes().setAll(new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE),
                                                          new ButtonType("OK", ButtonBar.ButtonData.OK_DONE) );
            
            Optional<String> result = alert.showAndWait();
            if (result.isPresent()){
                label.setText("Visiting " + result.get());
               
            }
             bloggerButton.requestFocus();
             bloggerMenu.setSelected(true);
    }

    @FXML
    private void handleFacebook(ActionEvent event) {
        
        TextInputDialog dialog = new TextInputDialog("John"); 
        
        dialog.setTitle("Introduce your name");
        dialog.setHeaderText("Which user do you want to write on Facebook?");
        dialog.setContentText("Enter your name:");
        dialog.getDialogPane().getButtonTypes().setAll(new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE),
                                                          new ButtonType("OK", ButtonBar.ButtonData.OK_DONE) );
        
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            label.setText("Message sent as "+ result.get());
            
        }
        facebookButton.requestFocus();
        facebookMenu.setSelected(true);
        }

    @FXML
    private void handleGoogle(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("John"); 
        
        dialog.setTitle("Introduce your name");
        dialog.setHeaderText("Which user do you want to write on Google+?");
        dialog.setContentText("Enter your name:");
        dialog.getDialogPane().getButtonTypes().setAll(new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE),
                                                          new ButtonType("OK", ButtonBar.ButtonData.OK_DONE) );
        
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            label.setText("Message sent as "+ result.get());      
        }
         googleButton.requestFocus();
         googleMenu.setSelected(true);
    }
    
}
