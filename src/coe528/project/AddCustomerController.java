/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author sdhru
 */


public class AddCustomerController {
        
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
    private TextField usernameAdd;

    @FXML
    private Button addcustomerButton;

    @FXML
    private TextField passwordAdd;

    @FXML
    private Button back;
    
    @FXML
    private Label sucessMsg;
    
    @FXML
    private Label errorMsg;

    @FXML
    void backAdd(javafx.event.ActionEvent event) throws IOException {
        Parent firstPage = FXMLLoader.load(getClass().getResource("Manager.fxml"));
        
        Scene Scenehome = new Scene(firstPage);
        Stage appHome = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        appHome.setScene(Scenehome);
        appHome.show();

    }

    @FXML
    void buttonAdd(javafx.event.ActionEvent event) {
        tf = false; 
        
        checkUsernames(usernameAdd.getText());
        
        if(tf == true){
            errorMsg.setText("Invalid, customer already exists!");
        }
        else if(tf == false){
        Manager addCust = new Manager();
        addCust.addCustomer(usernameAdd.getText(), passwordAdd.getText(), 100.00);
        sucessMsg.setText("Added Customer!");
        }
        

    }

}

