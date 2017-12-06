//Gabe Jurecki
public class SequentialIncrementer implements Incrementable {
    int increase = 0;

    public SequentialIncrementer(int increase) {
        this.increase = increase;
    }

    public int getValue(int increase) {
        return increase;
    }


    public int increment(int increase) {
        return increase++;
    }
}
