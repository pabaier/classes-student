//Gabe Jurecki
import java.util.Random;

public class RandomIncrementer implements Incrementable {
    Random randomNumber = new Random();
    @Override
    public int getValue(int increase) {
        return increase;
    }

    @Override
    public int increment(int increase) {
        return randomNumber.nextInt(Integer.MAX_VALUE);
    }
}
