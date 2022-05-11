public class SequentialIncrementer implements Incrementable{
    private int inc = 0;
    public void increment(){
        inc++;
    }
    public int getValue(){
        return inc;
    }
    
}