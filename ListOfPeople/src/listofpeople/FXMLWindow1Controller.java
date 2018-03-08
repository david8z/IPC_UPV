/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listofpeople;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author davidalarcon
 */
public class FXMLWindow1Controller implements Initializable {
    
    
    @FXML
    private TextField firstNameId;
    @FXML
    private TextField lastNameId;
     @FXML
    private Button okButton;
    
    private Stage primaryStage;
    private Scene primaryScene;
    private String primaryTitle;
    // To differnece modify and add
    private int action;
    private ObservableList<Person> observableNames;
  
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // To disable the Ok button when lastName or firstName are empty
        okButton.disableProperty().setValue(Boolean.TRUE);
        firstNameId.textProperty().addListener((observable, oldValue, newValue)-> {
             if (((String) newValue).equals("") || lastNameId.textProperty().isEmpty().get()){
                 okButton.disableProperty().setValue(Boolean.TRUE);
             }
             else okButton.disableProperty().setValue(Boolean.FALSE);}
        );
        lastNameId.textProperty().addListener((observable, oldValue, newValue)-> {
             if (((String) newValue).equals("") || firstNameId.textProperty().isEmpty().get()){
                 okButton.disableProperty().setValue(Boolean.TRUE);
             }
             else okButton.disableProperty().setValue(Boolean.FALSE);}
        );
       
    }    

 
    //For adding
    public void initWindow1(Stage stage, ObservableList<Person> o){
        action = 0;
        primaryStage = stage;
        primaryScene = primaryStage.getScene();
        primaryTitle = primaryStage.getTitle(); 
        observableNames = o;
        
    }
  
    //For modyfing
   public void initWindow2(Stage stage, ObservableList<Person> o){
        action = 1;
        primaryStage = stage;
        primaryScene = primaryStage.getScene();
        primaryTitle = primaryStage.getTitle();
        observableNames = o;
        
        //Introduce the current names to modify
        Person modifiedName = (((ListView<Person>)primaryScene.lookup("#nameList")).getSelectionModel().getSelectedItem());
        firstNameId.setText(modifiedName.getFirstName());
        lastNameId.setText(modifiedName.getLastName());
    }

    @FXML
    private void okAction(ActionEvent event) throws IOException{
             //action = 1 means its a modification
            if(action == 1){ 
                int index = (((ListView<Person>)primaryScene.lookup("#nameList")).getSelectionModel().getSelectedIndex());
                observableNames.set(index, new Person(firstNameId.getText(),lastNameId.getText()));
            } 
            else {
                observableNames.add(new Person(firstNameId.getText(),lastNameId.getText()));
            }
            primaryStage.setScene(primaryScene);
            primaryStage.setTitle(primaryTitle);
            Node n = (Node) event.getSource();
            n.getScene().getWindow().hide();
                   
    }

    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
            primaryStage.setScene(primaryScene);
            primaryStage.setTitle(primaryTitle);    
            Node n = (Node) event.getSource();
            n.getScene().getWindow().hide();
    }
}
