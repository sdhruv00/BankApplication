/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.io.*;
import static java.lang.System.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;
import java.io.File;
import java.nio.file.Files;


/**
 *
 * @author sdhru
 */
public class CustomerFiles {
    private String filename;
    private String password;
    int k;
    int l = 0;
    public String check[] = new String[40];
    
    private int arrLength = check.length;
    

    
    public CustomerFiles(String n) {
        filename = n;

    }
    
    private static CustomerFiles instance;
    
        public void read() {
        // Write the code here
        try {
            
            FileInputStream included = new FileInputStream(filename);
            Scanner input = new Scanner(included); 
            while(input.hasNextLine()){
                out.println(input.nextLine());
          }
          input.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
        public String readBalance() {
            
      try {
       FileInputStream included = new FileInputStream(filename);
       Scanner input = new Scanner(included);
       
       input.nextLine();
       
       return input.nextLine();
      
    } catch (IOException e) {
        
        System.out.println("An error occurred.");
        e.printStackTrace();

    }
      return null;
        }
        
        public String readPassword() {
            
      try {
       FileInputStream included = new FileInputStream(filename);
       Scanner input = new Scanner(included);
       
       
       return input.nextLine();
      
    } catch (IOException e) {
        
        System.out.println("An error occurred.");
        e.printStackTrace();

    }
      return null;
        }
        
      public void arraysOfUsernames(){
          try {
       int counter = 0;
       FileInputStream included = new FileInputStream(filename);
       Scanner input = new Scanner(included);
       
       while(input.hasNextLine()){
       String lol = input.nextLine();
       check[counter] = lol;
       l ++;
       counter ++;
       }
      
    } catch (IOException e) {
        
        System.out.println("An error occurred.");
        e.printStackTrace();

    }
         
  }
      
      
      public void clearFile() throws IOException{
      FileWriter data = new FileWriter(filename);
      PrintWriter fill = new PrintWriter(data);
      
      fill.print("");
      fill.close();
      }
      
        public void write(String msg) {
        // Write the code here
        try {
            FileWriter d = new FileWriter(filename, true); //class is used to write character-oriented data to a file
            PrintWriter p = new PrintWriter(d);
            p.println(msg);
            p.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
        public void deleteFile(){
        try {
            Files.deleteIfExists(Paths.get(filename));
        }
        catch(IOException e){
            System.out.println("ERROR, such file does not exist");
        }
        }
        
        
        
    public static CustomerFiles getInstance(){
        if (instance == null) {
            instance = new CustomerFiles("usernames.txt");
            return instance;
        }
        else
            return null;
    }
    
    
    
}
