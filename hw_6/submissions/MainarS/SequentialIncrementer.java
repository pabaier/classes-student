public class SequentialIncrementer implements Incrementable {
    private int val = 0;
    public SequentialIncrementer(){
        //this.val = val;
    }
    @Override
    public void increment(int val) {
        val++;
        this.val = val;
    }

    @Override
    public int getValue() {
        return this.val;
    }
}
