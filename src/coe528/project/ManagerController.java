package coe528.project;

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

public class ManagerController {

    @FXML
    private Button addCustomer;

    @FXML
    private Button deleteCustomer;

    @FXML
    private Button logout;

    @FXML
    void addcustomerButton(javafx.event.ActionEvent event) throws IOException {
        
        Parent firstPage = FXMLLoader.load(getClass().getResource("addCustomer.fxml"));
        
        Scene Scenehome = new Scene(firstPage);
        Stage appHome = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        appHome.setScene(Scenehome);
        appHome.show();
        
        
    }

    @FXML
    void deletecustomerButton(javafx.event.ActionEvent event) throws IOException {
        Parent firstPage = FXMLLoader.load(getClass().getResource("deleteCustomerFXML.fxml"));
        
        Scene Scenehome = new Scene(firstPage);
        Stage appHome = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        appHome.setScene(Scenehome);
        appHome.show();
        

    }

    @FXML
    void logoutManager(javafx.event.ActionEvent event)throws IOException  {
        Parent firstPage = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene Scenehome = new Scene(firstPage);
        Stage appHome = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        appHome.setScene(Scenehome);
        appHome.show();

    }

}
