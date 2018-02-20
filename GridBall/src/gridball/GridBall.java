/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridball;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author davidalarcon
 */
public class GridBall extends Application {
   

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        System.out.println(GridPane.getRowIndex(scene.lookup("#circle")));
        scene.setOnKeyPressed((KeyEvent ke) -> {
            String s = ke.getCode().getName();
            int posR = GridPane.getRowIndex(scene.lookup("#circle"));
            int posC = GridPane.getColumnIndex(scene.lookup("#circle"));
            switch (s){
           case"Up":if( posR != 0) GridPane.setRowIndex(scene.lookup("#circle"),(posR-1));
               break;
           case"Down":if(posR != 4) GridPane.setRowIndex(scene.lookup("#circle"),(posR+1));
               break;
           case"Right":if(posC != 4) GridPane.setColumnIndex(scene.lookup("#circle"),(posC+1));
               break;
           case"Left":if(posC != 0) GridPane.setColumnIndex(scene.lookup("#circle"),(posC-1));
               break;
           default: 
               break;
            }
        });    
        stage.setScene(scene);
        stage.show();
    }    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
