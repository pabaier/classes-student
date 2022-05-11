//Part 1:: CREATE A METHOD THAT ADDS TWO THINGS TOGETHER
// Just love yourself and KEEP GOING.
/*
        numA = Integer.parseInt(numAStr);
        numB = Integer.parseInt(numBStr) 
        System.out.println(numA);
        
        ^^^CANNOT USE PARSING BECAUSE INTS BECOME A FACTOR^^^
*/
import java.util.Scanner;
public class HW1Part2{
    public static void main(String args[]){
        String numAStr = "345432008838328838";
        String numBStr = "454265238923728727";
        int numA = 0;
        int numB = 0;
        int x = 5;
        int y = 7;
        int total;
        
        total = sumOfTwo(x,y);
        
        System.out.println(total);
        
        
    }
    
    static int sumOfTwo(int x, int y){
        int sum;
        sum = x + y;
        
        return sum;
    }
    
   
}
