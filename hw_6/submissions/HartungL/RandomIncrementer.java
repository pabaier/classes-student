
/**
 * class RandomIncrementer - An implementation of Incrementable 
 * that randomly changes the number
 *
 * @author Lexus Hartung
 */
import java.util.*;
public class RandomIncrementer implements Incrementable{
    private int rand;
    private Random rad = new Random();

    //Constructor for objects of class RandomIncrementer
    public RandomIncrementer(){
        this.rand = rad.nextInt();
    }
    
    //Randomly changes the stored number
    public void increment(){
        rand = rad.nextInt();
    }
    
    //Returns the stored value
    public int getValue(){
        return rand;
    }
}
