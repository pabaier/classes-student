/*
* Stephen Pappas
*
* This class is an implementation of Incrementable. It's increment method sets the class variable equal to a number 1-100.
*
 */

public class RandomIncrementer implements Incrementable {
    private int inc;

    public RandomIncrementer(){
        inc = (int)Math.floor(Math.random() * 101);
    }

    public void increment(){
        inc = (int)Math.floor(Math.random() * 101);
    }

    public int getValue(){
        return inc;
    }
}
