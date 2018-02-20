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
    
     /*@FXML
    public void CirclePressed(ActionEvent event) {
     
        circle.setFill(Paint.valueOf("BLACK")); //It changes the ball color
       circle.getParent();
       GridPane.setColumnIndex(circle,GridPane.getColumnIndex(circle)+1);
       System.out.println(GridPane.getColumnIndex(circle));
       System.out.println(GridPane.getRowIndex(circle));
       System.out.println("hola");
    }*/
 
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
         pane.widthProperty().addListener((observable, oldValue, newValue)-> {
             circle.setRadius(((double) newValue)/10);
         });
         pane.heightProperty().addListener((observable, oldValue, newValue)-> {
             circle.setRadius(((double) newValue)/10);
         });
    
    }    
    
}
