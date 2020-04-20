/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.application.Application;
import java.io.*;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

/**
 *
 * @author sdhru
 */
public class LoginMain extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent first = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Ryerson's Bank App");
        primaryStage.setScene(new Scene(first, 600, 400)); //load fxml, Width, Height
        primaryStage.show(); //Display first with a width of 600 and height of 400
    }
    
    @FXML
    private TextField username;

    @FXML
    private PasswordField pasword;

    @FXML
    private Button login;
    
    @FXML
    private Label errorDisplayMessage;
    
    @FXML
    private TextField role;
    
    boolean tf;

    
    public void checkUsernames(String username) {
        CustomerFiles file = new CustomerFiles ("usernames.txt"); //opens up usernames.txt file and checks each line to see if theres a username match!
        file.arraysOfUsernames();
        
        for (int i = 0; i < file.l; i++){
            if(file.check[i].equals(username)){
            tf = true;
            }
        }
    }

    @FXML
    void loginButton(javafx.event.ActionEvent event) throws IOException {
        tf = false;
        checkUsernames(username.getText());
        
       
        
        
        
        if((username.getText()).equals("admin") && (pasword.getText()).equals("admin") && (role.getText()).equals("manager")){
        Parent firstPage = FXMLLoader.load(getClass().getResource("Manager.fxml"));
        
        Scene sceneHome = new Scene(firstPage);
        Stage appHome = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        appHome.setScene(sceneHome);
        appHome.show();
        }
        
        
        else if((tf == true) && (role.getText()).equals("customer")){
        
        CustomerFiles checc = new CustomerFiles(username.getText() + ".txt");
        
        double bal = (Double.parseDouble(checc.readBalance()));
        
        BankAccount bnk = new BankAccount(username.getText(), checc.readPassword(), bal);
        
        String lvl = bnk.checkLevel();
        
        if(pasword.getText().equals(checc.readPassword())){
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("BankAccount.fxml"));
                
                Parent firstpage = load.load();
                Scene Scenehome = new Scene(firstpage);
                Stage appHome = (Stage)((Node) event.getSource()).getScene().getWindow();
                appHome.setScene(Scenehome);
                appHome.show();
                
                BankAccountController accountInfo = load.getController();
                accountInfo.name.setText(username.getText());
                accountInfo.balance.setText(checc.readBalance());
                accountInfo.status.setText(lvl);
                accountInfo.password.setText(pasword.getText());
                
                }
        
        }
        
       
        
        else {
        errorDisplayMessage.setText("Error, incorrect username or password or role");
               
        }

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
