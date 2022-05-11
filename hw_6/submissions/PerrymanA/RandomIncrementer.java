//Asa Perryman
import java.util.Random;

public class RandomIncrementer implements Incrementable{
    
    Random random = new Random();
    private int value;
    
    public RandomIncrementer(){
        this.value = random.nextInt();
    }
    
    public void increment(){
        value = random.nextInt();
    }
    
    public int getValue(){
        return value;
    }
    
}