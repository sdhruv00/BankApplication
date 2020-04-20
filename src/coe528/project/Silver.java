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
public class Silver extends CustomerLevel{
    
    @Override
    public String getLevel(){
        level = "Silver";
        return level;
    }
    
    public void upgrade(BankAccount lvl){
        lvl.setState(new Gold());
    }
    
    public void degrade(BankAccount lvl){
       lvl.setState(new Silver());
    }
}
