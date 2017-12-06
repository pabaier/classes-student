import java.util.Random;
public class RandomIncrementer implements Incrementable{
    Random rand = new Random();
    int inc = rand.nextInt();
    public void increment(){
        inc = rand.nextInt();
    }
    public int getValue(){
        return inc;
    }
}