/*
 * Sydney Jackson
 * RandomIncrementer generates a new random integer everytime the methods
 * increment() is called
 * Methods: increment() and getValue()
 */
import java.lang.Math;
public class RandomIncrementer implements Incrementable{
    
    int val;
    
    public void increment(){
        val = (int)(Math.random()*10000);
        
    }
    
    public int getValue(){
        return val;
    }
}
    