import java.util.Random;
public class RandomIncrementer implements Incrementable {
    Random rand = new Random();
    int val = Math.abs(rand.nextInt());

    public RandomIncrementer(){
        //this.val = val;
    }


    @Override
    public void increment(int val) {
        val = Math.abs(rand.nextInt());
        this.val = val;

    }

    @Override
    public int getValue() {
        return this.val;
    }
}
