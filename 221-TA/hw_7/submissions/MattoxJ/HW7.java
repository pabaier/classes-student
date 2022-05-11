import java.util.Deque;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
/**
 * Write a description of class HW7 here.
 *
 * @author Jacob Mattox
 * @version 12/2/17
 */
public class HW7
{
   public static void main(String[] args){
        //taking in the file name and building the scanners needed to process it
        String filename;
        FileInputStream readFile;
        Scanner fileScnr = null;
        Scanner scnr = new Scanner(System.in);
        //making the stack
        Deque<String> stack = new ArrayDeque<>();
        
        System.out.println("Please enter a valid filename");
        filename = scnr.nextLine();
        
        //try catch to check for valid file
        try{
            readFile = new FileInputStream(filename);
            fileScnr = new Scanner(readFile);
        }
        catch(IOException excpt){
            System.out.println("Sorry! Your file doesn't seem to exist. Please restart.");
            return;
        }
        String fileLine = null;
        //Part 1: processing file and reversing strings
        System.out.printf("\nPart 1: \n");
        while(fileScnr.hasNext()){
            fileLine = fileScnr.nextLine();
            scnr = new Scanner(fileLine);
            System.out.print("The reverse \"" + fileLine + "\" is: ");
            while(scnr.hasNext()){
                stack.push(scnr.next());
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop() + " ");
            }
            System.out.println("");
        }
        System.out.printf("\n\nPart 2: \n");
        
        //resetting the file
        try{
            readFile = new FileInputStream(filename);
            fileScnr = new Scanner(readFile);
        }
        catch(IOException excpt){
            System.out.println("Sorry! Your file doesn't seem to exist. Please restart.");
            return;
        }
        //creating the queue and a boolean for a while loop
        Deque<String> queue = new ArrayDeque<>();
        Boolean done = false;
        
        //Part 2: processing the file and checking for a palindrome at the character level per line
        while(fileScnr.hasNext()){
            fileLine = fileScnr.nextLine().trim();
            queue.addLast(fileLine);
            done = false;
            while(!done){
                String queueFirst = queue.removeFirst();
                queueFirst = queueFirst.toLowerCase().trim();
                if(queueFirst.length() < 2){
                    System.out.println("\"" + fileLine + "\" is a palindrome");
                    done = true;
                }
                else if(queueFirst.charAt(0) == queueFirst.charAt(queueFirst.length() - 1)){
                    queue.addLast(queueFirst.substring(1, queueFirst.length() - 1));
                }
                else{
                    System.out.println("\"" + fileLine + "\" is not a palindrome");
                    done = true;
                }
            }
        }
        System.out.printf("\n\nPart 3: \n");
        
        //resetting the file
        try{
            readFile = new FileInputStream(filename);
            fileScnr = new Scanner(readFile);
        }
        catch(IOException excpt){
            System.out.println("Sorry! Your file doesn't seem to exist. Please restart.");
            return;
        }
        
        //resetting queue and stack
        queue = new ArrayDeque<>();
        stack = new ArrayDeque<>();
        
        //processing file and checking for a palindrome at the word level by comparing the stack pop to the queue remove
        while(fileScnr.hasNext()){
            fileLine = fileScnr.nextLine();
            scnr = new Scanner(fileLine.toLowerCase());
            done = false;
            while(scnr.hasNext()){
                String word = scnr.next();
                stack.push(word);
                queue.addLast(word);
            }
            while(!done){
                if(stack.isEmpty() && queue.isEmpty()){
                    done = true;
                    System.out.println("\"" + fileLine + "\" is a palindrome");
                }
                else if(stack.pop().equals(queue.removeFirst())){
                    done = false;
                }
                else{
                    done = true;
                    System.out.println("\"" + fileLine + "\" is not a palindrome");
                }
            }
            //have to clear the stack and queue each time through to get ready for the next line
            stack.clear();
            queue.clear();
        }
   }
}
