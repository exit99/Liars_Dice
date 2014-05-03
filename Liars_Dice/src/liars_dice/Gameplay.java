/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package liars_dice;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Big Z
 */
public class Gameplay {
    //current players and guess stored here b/c it is easier than passing vars
    //to multiple functions.
    ArrayList<Player> players = new ArrayList<>();
    int currentTurn = 1;
    int lastTurn = 1;
    int[] currentGuess = new int[2];
    boolean firstTurn = true;

    public boolean makePlayers(int num){
        //creates player up to 4 down to 2.  Returns valid, if valid is false
        // one should invoke makePlayers again.  (use a while loop in main).
        boolean valid = false;
        
        //Player Null is a placeholder for index 0 in players array so it is 
        // easier to understand current and last turn.
        Player playerNull = new Player();
        players.add(playerNull);
        
        switch (num) {
            case 4:
                Player player4 = new Player();
                players.add(player4);
            case 3:
                Player player3 = new Player();
                players.add(player3);
            case 2:
                Player player2 = new Player();
                players.add(player2);
                Player player1 = new Player();
                players.add(player1);
                valid = true;
                return valid;
            default:
                System.out.println("Must be 2-4.");
                return valid;
        }
    }
    
    public void startTurn(){
        //Checks to make sure not first turn, b/c no currentGuess on first turn
        // Use this function to start the game in main().
        allRoll(); //rolls everyones dice to start the turn
        if (firstTurn) {
            firstTurn = false;
            getPlayerGuess();
        }
        else getLiarDecision();
    }
    
    public void allRoll(){
        //rolls every players individual dice
        for (Player player : players) {
            player.rollDice();
        }
    }
    
    public void getLiarDecision(){
        // if user types in lier invokes checkTotals, else getPlayerGuess
        System.out.println("The previous guess is: " + currentGuess[1] + " " +
                           currentGuess[0] + "'s" );
        System.out.print("Your Dice are: ");
        players.get(currentTurn).displayDice();
        System.out.println("Are they a 'liar'? type 'liar' is yes");
        String answ;
        Scanner input = new Scanner(System.in);
        answ = input.nextLine().toLowerCase();
        if ("liar".equals(answ)) checkTotals();  
        else getPlayerGuess();
    }
    
    public void checkTotals() {
        //checks the total of the current guess value.  Will subtract dice from
        //loser and activate endTurn.
        int numTotal = 0;
        for (Player player : players){
            int playersTot = player.playersDice.getAmount(currentGuess[0]);
            numTotal += playersTot;
        }
        System.out.println("There are " + numTotal + " " + currentGuess[0] + "'s");
        if (numTotal < currentGuess[1]) {
            System.out.println("Liar!!!");
            players.get(lastTurn).playersDice.removeDie();
            
        }
        else {
            System.out.println("You were wrong!");
            players.get(currentTurn).playersDice.removeDie();
            
        }
        endTurn();
    }
    
    public void getPlayerGuess(){
        System.out.println("Enter Player " + currentTurn + "'s guess.");
        players.get(currentTurn).displayDice();
        currentGuess = players.get(currentTurn).getGuess();
        endTurn();
        
    }
    
    public void endTurn(){
        lastTurn = currentTurn;
        if ((currentTurn+1) == players.size()) currentTurn = 1;
        else currentTurn += 1;
        firstTurn = true;
        startTurn();
    }
}
