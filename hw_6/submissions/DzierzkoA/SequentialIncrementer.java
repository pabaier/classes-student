/*
    Class stores a integer (starting at 0) and increments it by one each time increment method is called

    author: Adam Dzierzko
 */
public class SequentialIncrementer implements Incrementable {

    private int number;

    public SequentialIncrementer() {
        this.number = 0;
    }

    @Override
    public void increment() {
        this.number++;
    }

    @Override
    public int getValue() {
        return this.number;
    }
}
