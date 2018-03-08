
package listofpeople;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author davidalarcon
 */
public class FXMLListOfPeopleController implements Initializable {
    
    @FXML
    private ListView<Person> nameList;
    @FXML
    private Button removeButton;
    @FXML
    private Button modifyButton;
    private Stage primaryStage;
    
   

    private final ObservableList<Person> observableNames = FXCollections.observableArrayList(
             new Person ("John", "Doe")
             
    );
    
    public void initMainWindow(Stage stage){
        primaryStage = stage;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //Observable List association 
        nameList.setItems(observableNames);
 
        //Remove button disabled when no items selected 
        removeButton.disableProperty().bind(Bindings.equal(-1,nameList.getSelectionModel().selectedIndexProperty()));
        
        //Modify button disabled when no items selected 
        modifyButton.disableProperty().bind(Bindings.equal(-1,nameList.getSelectionModel().selectedIndexProperty()));
    }    

    @FXML
    private void addAction(ActionEvent event) throws IOException {
            
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLAddingName.fxml"));
            Parent root = (Parent) myLoader.load();
            myLoader.<FXMLWindow1Controller>getController().initWindow1(primaryStage, observableNames);
            
            
            Stage aNewStage = new Stage();
            //Creation of the Window1 stage
            Scene scene = new Scene(root);
            aNewStage.setScene(scene);
            aNewStage.setTitle("Modify a person");
            //Show the stage window
            aNewStage.setResizable(false);
            aNewStage.initModality(Modality.APPLICATION_MODAL);
            aNewStage.show();                  
    }

    @FXML
    private void modifyAction(ActionEvent event) throws IOException {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLAddingName.fxml"));
            Parent root = (Parent) myLoader.load();
            myLoader.<FXMLWindow1Controller>getController().initWindow2(primaryStage,observableNames);
            
            Stage aNewStage = new Stage();
            //Creation of the Window1 stage
            Scene scene = new Scene(root);
            aNewStage.setScene(scene);
            aNewStage.setTitle("Modify a person");
            //Show the stage window
            aNewStage.setResizable(false);
            aNewStage.initModality(Modality.APPLICATION_MODAL);
            aNewStage.show();
    }
        
    @FXML
    private void removeAction(ActionEvent event) {
        int pos = nameList.getSelectionModel().selectedIndexProperty().getValue();
        if(pos>=0) observableNames.remove(pos); //In case ther is no selection
    }
    
}
