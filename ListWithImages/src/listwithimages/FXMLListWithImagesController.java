/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listwithimages;

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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author davidalarcon
 */
public class FXMLListWithImagesController implements Initializable {
    
    @FXML
    private Button modifyButton;
    @FXML
    private Button removeButton;
    @FXML
    private TableView<Person> dataTable;
    @FXML
    private TableColumn<Person, Integer> idColumn;
    @FXML
    private TableColumn<Person, String> fullNameColumn;
    @FXML
    private TableColumn<Person, Residence> cityColumn;
    @FXML
    private TableColumn<Person, String> imageColumn;
    private Stage primaryStage;

    
    private final ObservableList<Person> observablePersons = FXCollections.observableArrayList(
                 new Person (777, "John Doe", new Residence("jol","val"), "resources/images-1-1/Sonriente.png")
             
    );
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        dataTable.setItems(observablePersons);
        
        // We initialize the columns
        idColumn.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("fullName"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Person,Residence>("residence"));
        imageColumn.setCellValueFactory(c -> c.getValue().pathImageProperty());
        
        idColumn.setCellFactory(v -> new TableCell<Person, Integer>(){
            @Override
            protected void updateItem(Integer item, boolean empty){
                super.updateItem(item, empty);
                if(item == null || empty){
                    setText(null);
                }else{
                    setText(String.valueOf(item));
                }
            }
        });
        
        fullNameColumn.setCellFactory(v -> new TableCell<Person, String>(){
            @Override
            protected void updateItem(String item, boolean empty){
                super.updateItem(item, empty);
                if(item == null || empty){
                    setText(null);
                }else{
                    System.out.println(item);
                    setText(item);
                }
            }
        });
        
        cityColumn.setCellFactory(v -> new TableCell<Person, Residence>(){
            @Override
            protected void updateItem(Residence item, boolean empty){
                super.updateItem(item, empty);
                if(item == null || empty){
                    setText(null);
                }else{
                    
                    setText(item.getCity().toUpperCase());
                }
            }
        });
        
 
        imageColumn.setCellFactory(v -> new TableCell<Person, String>(){
            private final ImageView view  = new ImageView();
            @Override
            protected void updateItem(String item, boolean empty){
                super.updateItem(item, empty);
                if(item == null || empty){
                    setGraphic(null);
                }else{
                    System.out.println(item);
                    javafx.scene.image.Image avatar;
                    avatar = new javafx.scene.image.Image(item,40,40,false,true);                                   
                    view.setImage(avatar);
                    setGraphic(view);
                    
                }
            }
        });
        
        
        // Remove and modify buttonsonly enabled when there is a selected item
        removeButton.disableProperty().bind(Bindings.equal(-1,dataTable.getSelectionModel().selectedIndexProperty()));
        modifyButton.disableProperty().bind(Bindings.equal(-1,dataTable.getSelectionModel().selectedIndexProperty()));
        
                
    } 

    public void initMainWindow(Stage stage){
        primaryStage = stage;
    }
    
   
    @FXML
    private void handleAdd(ActionEvent event) throws IOException {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLModifyAPerson.fxml"));
            Parent root = (Parent) myLoader.load();
            myLoader.<FXMLModifyAPersonController>getController().initWindow1(primaryStage,observablePersons);
            
            Stage aNewStage = new Stage();
            Scene scene = new Scene(root);
            aNewStage.setScene(scene);
            aNewStage.setTitle("Modify a person");
            //Show the stage window
            aNewStage.setResizable(false);
            aNewStage.initModality(Modality.APPLICATION_MODAL);
            aNewStage.show();
            
        
    }

    @FXML
    private void handleModify(ActionEvent event) throws IOException{
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXMLModifyAPerson.fxml"));
            Parent root = (Parent) myLoader.load();
            myLoader.<FXMLModifyAPersonController>getController().initWindow2(primaryStage,observablePersons);
            
            Stage aNewStage = new Stage();
            Scene scene = new Scene(root);
            aNewStage.setScene(scene);
            aNewStage.setTitle("Modify a person");
            aNewStage.setResizable(false);
            aNewStage.initModality(Modality.APPLICATION_MODAL);
            aNewStage.show();
    }

    @FXML
    private void handleRemove(ActionEvent event) {
         int pos = dataTable.getSelectionModel().selectedIndexProperty().getValue();
        if(pos>=0) observablePersons.remove(pos); //In case ther is no selection
    }
    
}
