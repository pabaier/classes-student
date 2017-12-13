
/**
 * Prob1 prints a sentence backwards
 *
 * Lexus Hartung
 */
import java.io.*;
import java.util.*;
public class Prob1{
    public static void problem1(String file){
        //Inicial variables
        Deque<String> prob = new ArrayDeque<>();
        String helper = "";
        String temp = "";
        
        //Using file given
        File input = new File(file + ".txt");
        
        //Checking for incorrect files
        try{
            Scanner scnrF = new Scanner(input);
            while (scnrF.hasNextLine()){
                helper = scnrF.nextLine();
                Scanner str = new Scanner(helper);
                
                //Putting a sentence into the stack word by word
                while(str.hasNext()){
                    temp = str.next();
                    prob.push(temp);
                }
                
                //Reading the scentence backwards
                while(!prob.isEmpty()){
                    System.out.print(prob.pop() + " ");
                }
                
                System.out.println();
            }
        }
        //Catching incorrect files
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}