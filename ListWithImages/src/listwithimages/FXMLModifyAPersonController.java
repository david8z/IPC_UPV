/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listwithimages;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author davidalarcon
 */
public class FXMLModifyAPersonController implements Initializable {

    @FXML
    private TextField idText;
    @FXML
    private TextField fullNameText;
    @FXML
    private TextField cityText;
    @FXML
    private TextField provinceText;
    @FXML
    private ComboBox<String> imageComboBox;
    @FXML
    private Button okButton;

    private Stage primaryStage;
    private Scene primaryScene;
    private String primaryTitle;
    private ObservableList<Person> observableNames;
    // To differnece modify and add
    private int action;
    private final ObservableList<String> observablePaths = FXCollections.observableArrayList(
                 "resources/images-1-1/Sonriente.png","resources/images-1-1/Lloroso.png","resources/images-1-1/Pregunta.png"
             
    );
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageComboBox.setItems(observablePaths);
              
    }    
    
    
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
        Person modifiedPerson = (((TableView<Person>)primaryScene.lookup("#dataTable")).getSelectionModel().getSelectedItem());
        idText.setText(String.valueOf(modifiedPerson.getId()));
        fullNameText.setText(modifiedPerson.getFullName());
        cityText.setText(modifiedPerson.getResidence().getCity());
        provinceText.setText(modifiedPerson.getResidence().getProvince());
        imageComboBox.setValue(modifiedPerson.getPathImage());
        
    }

    @FXML
    private void handleOk(ActionEvent event) {
            
            if(action == 1){ 
                int index = (((TableView<Person>)primaryScene.lookup("#dataTable")).getSelectionModel().getSelectedIndex());
                observableNames.set(index, new Person(Integer.parseInt(idText.getText()), fullNameText.getText(), new Residence(cityText.getText(),provinceText.getText()), imageComboBox.getValue()));
            } 
            else {
                observableNames.add(new Person(Integer.parseInt(idText.getText()), fullNameText.getText(), new Residence(cityText.getText(),provinceText.getText()), imageComboBox.getValue()));
            }
            primaryStage.setScene(primaryScene);
            primaryStage.setTitle(primaryTitle);
            Node n = (Node) event.getSource();
            n.getScene().getWindow().hide();
    }

    @FXML
    private void handleCancel(ActionEvent event) {
            primaryStage.setScene(primaryScene);
            primaryStage.setTitle(primaryTitle);    
            Node n = (Node) event.getSource();
            n.getScene().getWindow().hide();
    }
    
}
