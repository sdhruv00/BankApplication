/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.util.ArrayList;
import java.io.*;
import static java.lang.System.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.io.File;

/**
 *
 * @author sdhru
 */
public class Manager {
    public void addCustomer(String username, String password, double accountBalance){
        BankAccount customer = new BankAccount(username, password, accountBalance);
        String balance = String.valueOf(accountBalance);
        CustomerFiles customerFile = new CustomerFiles(username + ".txt");
        CustomerFiles addUsername = new CustomerFiles("usernames.txt");
        addUsername.write(username);
        
        customerFile.write(password);
        customerFile.write(balance);
        
         
    }
    //Delete customer is done in the GUI
    
    public void deleteCustomer(String username){
        //Delete customer is done in the GUI as it made more sense for me to do it there...
        //to delete the actual file, user must close the app and relogin as a manager! then delete to remove the file!
        
    }
        
}
