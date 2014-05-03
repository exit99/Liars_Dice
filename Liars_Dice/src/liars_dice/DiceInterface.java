
package liars_dice;

//Didn't really "NEED" this interface.  But good practice to have it

public interface DiceInterface {
    public int[] roll();
    public int getAmount(int value);
    public boolean removeDie();
}