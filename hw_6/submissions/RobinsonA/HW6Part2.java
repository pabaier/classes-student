
/**
 * Ariel Robinson
 * the test driver for the incrementer classes that has the incrementer interface
 * 
 */
public class HW6Part2
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        System.out.println("Sequentital Incrementer Tests" );
        SequentialIncrementer add = new SequentialIncrementer(2);
        System.out.println("Test 1 Before: " + add.getValue());
        add.increment();
        System.out.println("Test 1 After: " + add.getValue());

        SequentialIncrementer add1 = new SequentialIncrementer(100);
        System.out.println("Test 2 Before: " + add1.getValue());
        add1.increment();
        System.out.println("Test 2 After: " + add1.getValue());

        SequentialIncrementer add2 = new SequentialIncrementer(50);
        System.out.println("Test 3 Before: "+ add2.getValue());
        add2.increment();
        System.out.println("Test 3 After: " + add2.getValue());

        SequentialIncrementer add3 = new SequentialIncrementer(657);
        System.out.println("Test 4 Before: " + add3.getValue());
        add3.increment();
        System.out.println("Test 4 After: " + add3.getValue());

        SequentialIncrementer add4 = new SequentialIncrementer(90000);
        System.out.println("Test 5 Before: " + add4.getValue());
        add4.increment();
        System.out.println("Test 5 After: " + add4.getValue());
        System.out.println();

        System.out.println("Random Incrementer Tests" );
        RandomIncrementer random= new RandomIncrementer();
        System.out.println("Test 1 Before " + random.getValue());
        random.increment();
        System.out.println("Test 1 After " + random.getValue());
        System.out.println();

        RandomIncrementer rand2= new RandomIncrementer();
        System.out.println("Test 2 Before " + rand2.getValue());
        rand2.increment();
        System.out.println("Test 2 After " + rand2.getValue());
        System.out.println();

        RandomIncrementer rand3= new RandomIncrementer();
        System.out.println("Test 3 Before " + rand3.getValue());
        rand3.increment();
        System.out.println("Test 3 After " + rand3.getValue());
        System.out.println();

        RandomIncrementer rand4= new RandomIncrementer();
        System.out.println("Test 4 Before " + rand4.getValue());
        rand4.increment();
        System.out.println("Test 4 After " + rand4.getValue());
        System.out.println();        System.out.println();

        RandomIncrementer rand5= new RandomIncrementer();
        System.out.println("Test 5 Before " + rand5.getValue());
        rand5.increment();
        System.out.println("Test 5 After " + rand5.getValue());
        System.out.println();

    }
}
