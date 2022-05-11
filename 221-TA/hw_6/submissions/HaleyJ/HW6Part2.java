public class HW6Part2{
    public static void main(String[] args){
        Incrementable i1 = new RandomIncrementer();
        System.out.println("RandomIncrementer initial value: " + i1.getValue());
        i1.increment();
        System.out.println("RandomIncrementer value after incrementing: " + i1.getValue());
        i1.increment();
        System.out.println("RandomIncrementer value after incrementing twice: " + i1.getValue());
                
        Incrementable i2 = new SequentialIncrementer();
        System.out.println("SequentialIncrementer initial value: " + i2.getValue());
        i2.increment();
        System.out.println("SequentialIncrementer value after incrementing: " + i2.getValue());
        i2.increment();
        System.out.println("SequentialIncrementer value after incrementing twice: " + i2.getValue());
    }
}