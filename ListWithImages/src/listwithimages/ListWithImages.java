/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listwithimages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author davidalarcon
 */
public class ListWithImages extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLListWithImages.fxml"));
        Parent root = myLoader.load();
        // Creation  the controller object
        myLoader.<FXMLListWithImagesController>getController().initMainWindow(stage);
        
        Scene scene = new Scene(root);
        stage.setTitle("TableView demo");
        stage.setScene(scene);
       
        //Show the stage/window
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
