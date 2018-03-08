
package listofpeople;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author davidalarcon
 */
public class ListOfPeople extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {        
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLListOfPeople.fxml"));
        Parent root = myLoader.load();
        // Creation  the controller object
        FXMLListOfPeopleController mainWinController = myLoader.<FXMLListOfPeopleController>getController();        
        mainWinController.initMainWindow(stage);
        
        // Creation of the main stage
        Scene scene = new Scene(root);
        stage.setTitle("Demo of ListView");
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
