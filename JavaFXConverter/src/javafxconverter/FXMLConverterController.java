/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxconverter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author davidalarcon
 */
public class FXMLConverterController implements Initializable {
    
    
    @FXML
    private Slider slider;
    @FXML
    private Text conversionRateIdentifier;
    @FXML
    private TextField InputText;
    @FXML
    private TextField OutputText;
    @FXML
    private CheckBox AutomaticConversion;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
         slider.valueProperty().addListener((observable, oldValue, newValue)-> {
             conversionRateIdentifier.setText("Conversion Rate: " + String.valueOf(newValue));});
        /* AutomaticConversion.selectedProperty().addListener((observable, oldValue, newValue)-> {
             if(newValue == true){
                InputText. 
             }
         });*/
         
    }    

    @FXML
    private void ConverterMethod(ActionEvent event) {
        OutputText.setText(
                String.valueOf((slider.valueProperty().doubleValue())
                        * Double.parseDouble(InputText.getText()))
        );
    }

    @FXML
    private void ClearMethod(ActionEvent event) {
        OutputText.clear();
        InputText.clear();
        slider.setValue(0.0);
    }
    
}
