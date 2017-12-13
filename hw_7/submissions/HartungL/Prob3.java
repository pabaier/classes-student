
/**
 * Prob3 determines if a string is a palindrome	at the word-level
 *
 * Lexus Hartung
 */
import java.io.*;
import java.util.*;
public class Prob3{
    public static void problem3 (String file){
        //Inicial variables
        Deque<String> que = new ArrayDeque<>();
        Deque<String> stack = new ArrayDeque<>();
        String helper = "";
        String temp = "";
        String tempS = "";
        String tempQ = "";
     
        //Using file given
        File input = new File(file + ".txt");
        
        //Reopening file to reset it
        try{
            Scanner scnrF2 = new Scanner(input);
            while (scnrF2.hasNextLine()){
                helper = scnrF2.nextLine();
                System.out.print(helper);
                Scanner str = new Scanner(helper);
               
                //Putting a sentence into the stack and queue word by word
                while(str.hasNext()){
                    temp = str.next();
                    que.addLast(temp);
                    stack.push(temp);
                }
                //Used as a sort of base case. Will figure out what message to print
                //based on contents
                String answer = "";
                while(!que.isEmpty()){
                    tempS = stack.pop();
                    tempQ = que.removeFirst();
                    //If a pair of words fails
                    if (!tempS.equals(tempQ)){
                       answer = " is not a palindrome";
                       System.out.println(answer);
                       stack.clear();
                       que.clear();
                       break;
                    }
                }
                //When all of the words pass
                if (!answer.equals(" is not a palindrome")){
                        answer = " is a palindrome";
                        System.out.println(answer);
                }
            }
        }
        catch (Exception e){
          System.out.println(e.getMessage()); 
        }
    }
}
