public class SequentialIncrementer implements Incrementable{

    private int value;

    public SequentialIncrementer(){
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void increment(){
        value++;
    }

}
