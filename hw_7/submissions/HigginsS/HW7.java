
/**
 * Write a description of class HW7 here.
 *
 * Steven Higgins
 * 
 */
import java.util.*;
import java.io.*;
public class HW7
{
    
   public static void main(String args[]){
       Deque<String> stack1 = new ArrayDeque<>();
       
       try{
            System.out.println("Enter a file name. ");
            Scanner scnr = new Scanner(System.in);
            FileInputStream file = new FileInputStream(scnr.nextLine());
            Scanner importer = new Scanner(file);
            while(importer.hasNextLine()){
                String a = importer.nextLine();
                Scanner word = new Scanner(a);
                while(word.hasNext()){
                    stack1.addLast(word.next());
                }
                while(!stack1.isEmpty()){
                    System.out.print(stack1.removeLast() + " ");
                }
                System.out.println("");
            }
        }
        catch (IOException ex) {
            System.out.println("File Name does not exist");
            System.exit(0);
        }
   }
}
