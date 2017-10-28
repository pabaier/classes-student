import java.util.ArrayList;
 
public class MyEvenOddTest {
 
   public static void main(String[] args) {
       ArrayList<MyEvenOdd> meo = new ArrayList<>();
       meo.add(new MyEvenOdd());
       meo.add(new MyEvenOdd());
       meo.add(new MyEvenOdd());
       meo.add(new MyEvenOdd());

        for(int i = 0; i < meo.size(); i ++) {
            if(meo.get(i).isEvenNumber(i))
                System.out.println(i);
        }
   }
}