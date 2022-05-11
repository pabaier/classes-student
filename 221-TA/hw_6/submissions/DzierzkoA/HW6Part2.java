/*
    Test class for the second part of Homework

    author: Adam Dzierzko
 */
public class HW6Part2 {

    public static void main(String[] args) {
        SequentialIncrementer sequentialIncrementer = new SequentialIncrementer();
        RandomIncrementer randomIncrementer = new RandomIncrementer();

        System.out.println("SequentialIncrementer value after initialization: " + sequentialIncrementer.getValue());
        sequentialIncrementer.increment();
        System.out.println("SequentialIncrementer value after increment: " + sequentialIncrementer.getValue());

        System.out.println("RandomIncrementer value after initialization: " + randomIncrementer.getValue());
        randomIncrementer.increment();
        System.out.println("RandomIncrementer value after increment: " + randomIncrementer.getValue());

    }
}
