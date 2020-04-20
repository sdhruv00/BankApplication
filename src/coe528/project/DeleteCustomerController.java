/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sdhru
 */

public class DeleteCustomerController {
    
        boolean tf;
        public void checkUsernames(String username) {
        CustomerFiles file = new CustomerFiles ("usernames.txt"); 
        file.arraysOfUsernames();
        
        for (int i = 0; i < file.l; i++){
            if(file.check[i].equals(username)){
            tf = true;
            }
        }
    }
        
    @FXML
    private TextField usernameDelete;

    @FXML
    private Button deletecustomerButton;

    @FXML
    private Button backDelete;
    
    @FXML
    private Label successMsgDelete;

    @FXML
    private Label errorMsgDelete;
    

    @FXML
    void backDelete(javafx.event.ActionEvent event) throws IOException {
        Parent firstPage = FXMLLoader.load(getClass().getResource("Manager.fxml"));
        
        Scene Scenehome = new Scene(firstPage);
        Stage appHome = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        appHome.setScene(Scenehome);
        appHome.show();

    }

    @FXML
    void buttonDelete(javafx.event.ActionEvent event) throws IOException { //to delete the actual file, user must close the app and relogin as a manager! then delete to remove the file! 
        
        CustomerFiles deleteCust = new CustomerFiles (usernameDelete.getText() + ".txt");
        deleteCust.deleteFile();
        tf = false; 
        checkUsernames(usernameDelete.getText());
        
    if(tf == true){
        
        successMsgDelete.setText("Deleted Customer!");
        CustomerFiles file = new CustomerFiles ("usernames.txt"); 
        deleteCust.deleteFile();
        file.arraysOfUsernames();
        file.clearFile();
        
        for (int i = 0; i < file.l; i++){
            if(file.check[i].equals(usernameDelete.getText())){
                file.check[i] = null; //delete from the list
                
            }
            if(file.check[i] != null) {
            file.write(file.check[i]); //write evrything but the null ones in the username txt file.
            }
        }
        }
    else if(tf ==false){
        successMsgDelete.setText("");
        errorMsgDelete.setText("Error, customer doesn't exist!");
        }
    }
}
