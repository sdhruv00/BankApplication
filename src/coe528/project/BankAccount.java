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
public class BankAccount {
    

    private String username; 
    private String password;
    private double accountBalance; 
    private CustomerLevel customerLevel = new Silver();
    
    public BankAccount(String username, String password, double accountBalance){ 
        this.username = username;
        this.password = password;
        this.accountBalance = accountBalance; 
    }
    
    public void setName(String name){
        
        this.username = username; 
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getName(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void deposit(double depositValue){
        this.accountBalance = accountBalance + depositValue;
    }
    
    public void withdraw (double withdrawValue){
        this.accountBalance = accountBalance - withdrawValue;
        
    }
    
    public double getBalance(){
        return accountBalance; 
    }
    public void upgrade() {
        customerLevel.upgrade(this);
    }
    
    public void degrade(){
        customerLevel.degrade(this);
    }
    
    public CustomerLevel getLevel() {return customerLevel;}
    public void setState(CustomerLevel lvl){ customerLevel = lvl;}
    
    public String checkLevel(){
        if(accountBalance < 10000.00){
        return customerLevel.getLevel();
        }
        else if(accountBalance >= 10000.00 && accountBalance < 20000.00){
        customerLevel.upgrade(this);
        return customerLevel.getLevel();
        }
        else if(accountBalance >= 20000.00){
        customerLevel.upgrade(this);
        customerLevel.upgrade(this);
        return customerLevel.getLevel();
        }
        return null;
    }
    
    public void onlinePurchases(double purchaseAmount, String custLevel){ 
        if(purchaseAmount >= 50.00){
        
        if(custLevel.equals("Silver")){
        this.accountBalance = accountBalance - (purchaseAmount + 20.00); 
        }
        
        else if(custLevel.equals("Gold")){
        this.accountBalance = accountBalance - (purchaseAmount + 10.00);
        }
        
        else if(custLevel.equals("Platinum")){
        this.accountBalance = accountBalance - (purchaseAmount);
        }
        
        }
        
        else {
        System.out.println("Error, Purchase must be above 50 dollars!");
        }

        
    }

    

    
   
    
    /*public int deposit(int depositAmount){
        return (accountBalance + depositAmount);
    }
    
    public int withdraw(int withdrawAmount){
        return(accountBalance - withdrawAmount);
    }
*/
}
