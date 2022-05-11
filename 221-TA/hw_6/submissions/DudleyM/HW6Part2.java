public class HW6Part2 {
    public static void main(String[] args) {
        Incrementable item = new SequentialIncrementer();
        item.increment();
        item.increment();
        Incrementable item2 = new RandomIncrementer();
        System.out.println(item.getValue());
        System.out.println(item2.getValue());
        item2.increment();
        System.out.println(item.getValue());
        System.out.println(item2.getValue());

    }
}
