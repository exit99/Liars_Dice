/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package liars_dice;

import java.util.Scanner;
/**
 *
 * @author Big Z
 */
public class Player {
    
    public Dice playersDice = new Dice();
    
    public int[] getGuess() {
        //getGuess would be better implemented in Gameplay.java since it
        //is independent of a player. 
          int[] guess = new int[2];
          guess[1] = getTotal();
          guess[0] = getVal();
          return guess;
          
    }
    private int getVal() {
        System.out.print("Number: ");
        int val;
        Scanner input = new Scanner(System.in); 
        val = input.nextInt();
        return val;
    }
    
    private int getTotal(){
        System.out.print("Amount: ");
        int total;
        Scanner input = new Scanner(System.in); 
        total = input.nextInt();
        return total;
    }
    public void rollDice(){
        playersDice.roll();
        }
    
    public void displayDice(){
        System.out.println("Your Dice:");
        for (int val : playersDice.diceHand){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
