package coe528.project;

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

public class BankAccountController {

    @FXML
    private TextField depositText;

    @FXML
    private TextField withdrawText;

    @FXML
    private TextField onlinepurchaseText;

    @FXML
    private Button deposit;

    @FXML
    private Button withdraw;

    @FXML
    private Button onlinePurchase;

    @FXML
    public Label name;

    @FXML
    public Label balance;

    @FXML
    public Label status;
    
    @FXML
    public Label password;

    @FXML
    private Button Logout;
    
    @FXML
    private Label errOnlinePurchase;

    @FXML
    void CustomerLogout(javafx.event.ActionEvent event) throws IOException{
        Parent firstPage = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene Scenehome = new Scene(firstPage);
        Stage appHome = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        appHome.setScene(Scenehome);
        appHome.show();

    }

    @FXML
    void depositButton(javafx.event.ActionEvent event) throws IOException {
        double accBal = (Double.parseDouble(depositText.getText()));
        BankAccount depositSomething = new BankAccount(name.getText(), password.getText(), Double.parseDouble(balance.getText())); 
        depositSomething.deposit(accBal);
        String newBalance = String.valueOf(depositSomething.getBalance());
        balance.setText(newBalance);
        status.setText(depositSomething.checkLevel());
        
        CustomerFiles customerFile = new CustomerFiles(name.getText() + ".txt");
        customerFile.clearFile();
        customerFile.write(password.getText());
        customerFile.write(balance.getText());
        
        
    }

    @FXML
    void onlineButton(javafx.event.ActionEvent event) throws IOException{
        
    if(Double.parseDouble(onlinepurchaseText.getText()) >= 50.00){
        double accBalOnline = (Double.parseDouble(onlinepurchaseText.getText()));
        BankAccount onlineSomething = new BankAccount(name.getText(), password.getText(), Double.parseDouble(balance.getText())); 
        onlineSomething.onlinePurchases(accBalOnline, onlineSomething.checkLevel());
        String newBalance = String.valueOf(onlineSomething.getBalance());
        balance.setText(newBalance);
        status.setText(onlineSomething.checkLevel());
        
        CustomerFiles customerFile = new CustomerFiles(name.getText() + ".txt");
        customerFile.clearFile();
        customerFile.write(password.getText());
        customerFile.write(balance.getText());
    }
    
    else {
        errOnlinePurchase.setText("Online Purchases must be above 50 dollars!");
    }
        
    }

    @FXML
    void withdrawButton(javafx.event.ActionEvent event) throws IOException{
        double accBal = (Double.parseDouble(withdrawText.getText()));
        BankAccount withdrawSomething = new BankAccount(name.getText(), password.getText(), Double.parseDouble(balance.getText())); 
        withdrawSomething.withdraw(accBal);
        String newBalance = String.valueOf(withdrawSomething.getBalance());
        balance.setText(newBalance);
        status.setText(withdrawSomething.checkLevel());
        
        CustomerFiles customerFile = new CustomerFiles(name.getText() + ".txt");
        customerFile.clearFile();
        customerFile.write(password.getText());
        customerFile.write(balance.getText());
        
        

    }

}
