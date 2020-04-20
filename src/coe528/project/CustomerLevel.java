/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author sdhru
 */
public abstract class CustomerLevel {
    String level;
 
    public String getLevel(){
        return level;
    }
    
    public abstract void upgrade(BankAccount lvl);
    public abstract void degrade(BankAccount lvl);
}

