/** 
 * 
 * Jonathan E. Anderson
 * Homework 7
 * 
 */
import java.util.*;
import java.io.*;

public class HW7  {
    public static void main(String[] args)throws IOException{
        Deque<String> stack1 = new ArrayDeque<>();
        Scanner name = new Scanner(System.in);
        
        System.out.print("Enter the file name: ");
        String fileName = name.nextLine(); 
        
        Scanner file1 = new Scanner(new File(fileName));
        Scanner file2 = new Scanner(new File(fileName));
        Scanner file3 = new Scanner(new File(fileName));
        //solution to problem 1 begins here
        while(file1.hasNext()){
            stack1.push(file1.next());
        }
        while(!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }
        // end of solution to problem 1
        
        // begining of solution to problem 2
       // while(file2.hasNext()){
          //  stack1.push(file2.next());
        //}
    }
}