/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package liars_dice;

import java.util.Random;

/**
 *
 * @author Big Z
 */
public class Dice implements DiceInterface {
    private final int maxVal = 6;
    public int diceAmount = 5;
    public int[] diceHand = new int[diceAmount];
    public boolean hasDice = true;
    
    public int[] roll() {
        int[] diceRolls = new int[diceAmount];
        Random rand = new Random();
        for (int i = 1; i <= diceAmount; i++) {
            int dieNum = rand.nextInt(maxVal) + 1;
            diceRolls[i-1] = dieNum;
        }
        diceHand = diceRolls;
        return diceRolls;
    }
    
    public int getAmount (int value) {
        // Check to see if there is list comprehesion (like in python)
        int count = 0;
        for (int die : diceHand ) {   
            if (die == value) count++;
        }
        return count;
    }
    
    public boolean removeDie(){
        /** removes a dice from the count.  If diceAmount == 0 returns boolean 
         * False */
        diceAmount -= 1;
        if (diceAmount == 0) hasDice = false;
        diceHand = new int[diceAmount];
        return hasDice;
        
    }
}
