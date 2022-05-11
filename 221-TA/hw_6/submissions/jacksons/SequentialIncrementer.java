/*
 * Sydney Jackson
 * SequentialIncrementer adds 1 to the initialized value of 0 everytime the 
 * methods increment() is called
 * Methods: increment() and getValue()
 */
public class SequentialIncrementer implements Incrementable{
   
    int val = 0;

    public void increment(){
        val += 1;
    }

    public int getValue(){
        return val;
    }
}