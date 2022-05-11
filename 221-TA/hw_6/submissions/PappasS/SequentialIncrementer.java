/*
* Stephen Pappas
*
* This class is an implementation of Incrementable. It's increment method increases the class variable by one.
*
 */

public class SequentialIncrementer implements Incrementable {
    private int inc;

    public SequentialIncrementer(){
        inc = 0;
    }

    public void increment(){
        inc++;
    }

    public int getValue(){
        return inc;
    }
}
