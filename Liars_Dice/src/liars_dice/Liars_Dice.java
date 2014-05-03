/*
* Known Bugs:
*               When player runs out of dice they are not deleted.  
*               They need to be removed from the player list.
*               And the players list modified
 */

package liars_dice;

import java.util.Scanner;

/**
 *
 * @author Zachary Kazanski
 */
public class Liars_Dice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gameplay mainGame = new Gameplay();
        boolean valid = false;
        while (!valid) {
            System.out.print("How many players? Enter a num 2-4: ");
            int num;
            Scanner input = new Scanner(System.in);
            num = input.nextInt();
            valid = mainGame.makePlayers(num);
        }
        mainGame.startTurn();

        /** Tests for Dice
        Dice dice1 = new Dice();
        System.out.println("Dice:");
        for (int val : dice1.roll()){
            System.out.println(val);
        }
        
        int numOfOnes = dice1.getAmount(1);
        System.out.println("Num of Ones: " + numOfOnes);
                
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Number of Dice: " + dice1.diceHand.length);
            keepGoing = dice1.removeDie();
            }
        System.out.println("Number of Dice should be 0: " + dice1.diceHand.length);
    
    }  */
}
