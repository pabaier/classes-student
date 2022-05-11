//Asa Perryman

public class SequentialIncrementer implements Incrementable{
    
    private int value;
    
    public SequentialIncrementer(){
        this.value = value;
    }
    
    public void increment(){
        value += 1;
    }
    
    public int getValue(){
        return value;
    }
}