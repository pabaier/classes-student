/*
    Class stores a random integer and changes it to a new one each time increment method is called

    author: Adam Dzierzko
 */
import java.util.Random;

public class RandomIncrementer implements Incrementable {

    private int number;
    private Random random = new Random();

    public RandomIncrementer() {
        this.number = random.nextInt();
    }

    @Override
    public void increment() {
        this.number = random.nextInt();
    }

    @Override
    public int getValue() {
        return this.number;
    }
}
