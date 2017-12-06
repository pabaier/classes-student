public class HW6Part2 {

    public static void main(String[] args){
        SequentialIncrementer s = new SequentialIncrementer();
        for(int i = 0; i < 10; ++i){
            s.increment(i);
            System.out.println(s.getValue());
        }
        System.out.println();
        RandomIncrementer r = new RandomIncrementer();
        for(int i = 0; i < 11; ++i){
            System.out.print(r.getValue() + " ");
            r.increment(i);
            System.out.println(r.getValue());
        }


    }
}
