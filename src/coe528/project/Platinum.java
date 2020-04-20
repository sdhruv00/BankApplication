/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *Overview: This class is immutable as an object of this class doesn't change anything in this class, and changes the state based on if it's upgraded or degraded, it also returns the current state it's in. 
 * 
 * Abstraction Function: 
 * 
 * AF(lv) = abstract level such that: 
 * 
 * lv.level = "Platinum";
 * 
 * rep invariant
 * 
 * RI(lv) is false if the input type is not of BankAccount. Must be of type BankAccount 
 * 
 * repOk() is shown below and in this class: 
 * 
 * public boolean repOk(BankAccount lv){
 *  if(lv instanceof BankAccount){
 *      return true; 
 *      }
 * else {
 * 
 * return false;
 * }
 * }
 * 
 * I already have a toString() method, it is called getLevel(), so please use that for when you are marking the overview for this class! Thank You!
 * 
 * 
 * @author Dhruv Sharma
 */
public class Platinum extends CustomerLevel{
    
    /**
     *Effects: Returns the state which it is currently in
     *
     * @return
     */
    @Override
    public String getLevel(){ //this is the toString() method!
        level = "Platinum";
        return level;
    }
    
    /**
     *Effects: Changes from the current state to the next, which in this case is platinum as that is the highest state a user can reach. 
     *Modifies: Modifies the level variable to display the pervious state. 
     *Requires: A variable from the class, BankAccount to determine whether to use the upgrade method in the platinum class. 
     * @param lvl
     */
    public void upgrade(BankAccount lvl){
        lvl.setState(new Platinum());
    }
    
    /**
     *Effects: Changes from the current state to the previous state, which in this case is the gold state.
     *Modifies: Modifies the level variable to display the pervious state.
     *Requires: A variable from the class, BankAccount to determine whether or not to use the degrade method in the platinum class to change the current state to the previous one. 
     * @param lvl
     */
    public void degrade(BankAccount lvl){
       lvl.setState(new Gold());
    }

public boolean repOk(BankAccount lv){
   if(lv instanceof BankAccount){
       return true; 
       }
  else {
  
  return false;
  }
  }
}
