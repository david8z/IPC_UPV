/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listviewlanguages;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author davidalarcon
 */
public class FXMLListViewLanguagesController implements Initializable {
    
    
    @FXML
    private TextField valueText;
    @FXML
    private ListView<String> valueList;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Text valueSelected;
    private ObservableList<String> observableLanguage;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Observable List association
        ArrayList<String> language = new ArrayList<String>();
        language.add("Java");
        language.add("Python");
        observableLanguage = FXCollections.observableArrayList(language);
        valueList.setItems(observableLanguage);
        
        //Value selected implementation
        valueList.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue)-> {   
            if((int) newValue>=0) valueSelected.setText(observableLanguage.get((int)newValue));
            else {
                valueSelected.setText("none");
            }
         });
       
        
        //Remove button disable when no items selected 
        removeButton.disableProperty().bind(Bindings.equal(-1,valueList.getSelectionModel().selectedIndexProperty()));
        
        //Add button disabled when TextField is empty
        addButton.disableProperty().bind(valueText.textProperty().isEmpty());

    }    

    @FXML
    private void handleAddAction(ActionEvent event) {
        if(!valueText.getText().equals("")) observableLanguage.add(valueText.getText());
    }

    @FXML
    private void handleRemoveAction(ActionEvent event) {
        int pos = valueList.getSelectionModel().selectedIndexProperty().getValue();
        if(pos>=0) observableLanguage.remove(pos); //In case ther is no selection
    }
    
}
