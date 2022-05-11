
/**
 * class SequentialIncrementer - An implementation of Incrementable 
 * that adds one everytime it is run 
 *
 * @author Lexus Hartung
 */
public class SequentialIncrementer implements Incrementable{
    private int start;

    //Constructor for objects of class SequentialIncrementer    
    public SequentialIncrementer(){
        this.start = 0;
    }
    
    //Adds one to the stored value
    public void increment(){
        start += 1;
    }
    
    //Returns the stored value
    public int getValue(){
        return start;
    }
}
