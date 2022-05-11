
/**
 * Prob2 determines if a string is a palindrome	at the letter-level
 *
 * Lexus Hartung
 */
import java.io.*;
import java.util.*;
public class Prob2{
    public static void problem2(String file){
        //Inicial variables
        Deque<String> prob2 = new ArrayDeque<>();
        String helper = "";
        String temp = "";
        
        File input = new File(file + ".txt");
        
        //Reopening file to reset it
        try{
            Scanner scnrF2 = new Scanner(input);
            while (scnrF2.hasNextLine()){
                helper = scnrF2.nextLine();
                System.out.print(helper);
                prob2.add(helper);
                while(!prob2.isEmpty()){
                    temp = prob2.pop();
                    
                    //Making the base case
                    if (temp.length() < 2){
                        System.out.println(" is a palindrome");
                    }
                    else{
                        //A letter pair passed
                        if (temp.charAt(0) == temp.charAt(temp.length() - 1)){
                            prob2.push(temp.substring(1,temp.length() - 1));
                        }
                        //A letter pair failed
                        else{
                            System.out.println(" isn't a palindrome");
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}
