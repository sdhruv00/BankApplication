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
public class Gold extends CustomerLevel{
    
    @Override
    public String getLevel(){
        level = "Gold";
        return level;
    }
    
    public void upgrade(BankAccount lvl){
        lvl.setState(new Platinum());
    }
    
    public void degrade(BankAccount lvl){
       lvl.setState(new Silver());
    }
}
