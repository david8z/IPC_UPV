/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridball;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author davidalarcon
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
     public Circle circle; 
     
     @FXML
     public GridPane pane;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
         pane.widthProperty().addListener((observable, oldValue, newValue)-> {
            
                 circle.setRadius((Math.min(pane.getHeight(),(double) newValue)/10));
         });
         pane.heightProperty().addListener((observable, oldValue, newValue)-> {
             circle.setRadius((Math.min(pane.getWidth(),(double) newValue)/10));
         });
    
    }    
    
}
