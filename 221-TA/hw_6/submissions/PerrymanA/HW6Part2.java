//Asa Perryman

public class HW6Part2{
    public static void main(String[] args){
        SequentialIncrementer seqTest = new SequentialIncrementer();
        
        RandomIncrementer randTest = new RandomIncrementer();
        
        System.out.println("Incrementing 5 times with the sequential incrementer");
        seqTest.increment();
        System.out.println(seqTest.getValue());
        
        seqTest.increment();
        System.out.println(seqTest.getValue());
        
        seqTest.increment();
        System.out.println(seqTest.getValue());
        
        seqTest.increment();
        System.out.println(seqTest.getValue());
        
        seqTest.increment();
        System.out.println(seqTest.getValue());
        
        System.out.println();
        System.out.println("Incrementing 5 times with the random incrementer");
        randTest.increment();
        System.out.println(randTest.getValue());
        
        randTest.increment();
        System.out.println(randTest.getValue());
        
        randTest.increment();
        System.out.println(randTest.getValue());
        
        randTest.increment();
        System.out.println(randTest.getValue());
        
        randTest.increment();
        System.out.println(randTest.getValue());
        
    }
}