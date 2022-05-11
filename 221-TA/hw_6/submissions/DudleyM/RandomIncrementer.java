import java.util.Random;
public class RandomIncrementer implements Incrementable{

    private int value;

    public RandomIncrementer(){
        Random randValue = new Random();
        value = randValue.nextInt();
    }

    public int getValue() {
        return value;
    }

    public void increment(){
        Random randValue = new Random();
        value = randValue.nextInt();
    }
}
