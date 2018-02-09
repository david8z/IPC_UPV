/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author davidalarcon
 */
public class Calculator2Controller implements Initializable {
String m = "";
double res = 0;
int op = 1;
String in;
    @FXML
    private TextField text;
    
    @FXML
    private void writeNum(ActionEvent event) {
        in = ((Button)event.getSource()).getText();
    switch (in) {
        case "=":{
            switch(op){
                case 1: m = String.valueOf(res + Double.parseDouble(m));
                    break;
                case 2: m = String.valueOf(res - Double.parseDouble(m));
                    break;
                case 3: m = String.valueOf(res / Double.parseDouble(m));
                    break;
                case 4: m = String.valueOf(res * Double.parseDouble(m));
                    break;
            }
            }
            break;
        case "+": res = Double.parseDouble(m);op = 1; m="";
            break;
        case "-": res = Double.parseDouble(m);op = 2; m="";
            break;
        case "/": res = Double.parseDouble(m);op = 3; m="";
            break;
        case "X": res = Double.parseDouble(m);op = 4; m="";
            break;
        case "C": m = "";
            break;
        default: m = m + in;  
            break;
    }
        
        text.setText(m);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
