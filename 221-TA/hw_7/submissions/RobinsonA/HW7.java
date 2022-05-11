
/**
 * Ariel Robinson
 * HW7
 * Has two three methods
 * First method determines if word is palidrome
 * Second method determines if line is palidrome
 * Third method gives the reverse of the word 
 */
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.io.File;
import java.util.Deque;
public class HW7 
{

    //determines if a word is a palidrome
    public static boolean palidrome(String str){
        boolean isPalidrome=true;

        Deque<String> stack = new ArrayDeque<String>();
        str=str.toLowerCase();

        stack.push(str);
        String item="";
        //loop stops when stack is empty

        while(!stack.isEmpty()){
            str=stack.pop();

            if(str.length()<2){
                isPalidrome=true;

            }
            else
            //compares the word until it first and last letter does not match
            {
                if ((str.charAt(0))==(str.charAt(str.length()-1))){

                    item=str.substring(1,str.length()-1);
                    stack.push(item);

                }
                else
                    isPalidrome=false; 

            }

        }
        return isPalidrome;
    }
    // pops of the stack and removes from queue
    public static boolean stackCompareQueue(String str){
        Deque<String> stack = new ArrayDeque<String>();
        Deque<String> queue = new ArrayDeque<>();
        Scanner lineScanner;
        String item;
        str=str.toLowerCase();
        lineScanner = new Scanner(str);

        boolean isPalidrome=true;
        while (lineScanner.hasNext()) {    
            item= lineScanner.next();
            stack.push(item);
            queue.addLast(item);

        }

        while(!stack.isEmpty() || !queue.isEmpty()){
            //compares the words on stack and peek

            if(stack.peek().equals(queue.peekFirst())){
                stack.pop();
                queue.removeFirst();

                isPalidrome=true;

            }
            else{
                isPalidrome=false;
                break;
            }
        }
        return isPalidrome;

    }
    //reverses a string 
      
    /**
     * reverse a string
     */


    public static void reverseString(String str){
        Deque<String> stack = new ArrayDeque<String>();
        Scanner lineScanner = new Scanner(str);
        String item="";
        String word="";
        //uses scanner to read through string
        while (lineScanner.hasNext()) {    
            item= lineScanner.next();

            stack.push(item);

        }
        //prints out the reverse
        System.out.print("The reverse of " + "\""+ str+ "\""+" is " + "\"");
        //while stack is empty
        while(!stack.isEmpty()){
            //removes each word off stack
            System.out.print(stack.pop()+ " ");
        }

        System.out.print("\"");
        System.out.println();

    }
  
    /**
     * main method
     *
     */

    public static void main(String [] args)
    {
        Deque<String> stack = new ArrayDeque<String>();
        Scanner scnr=new Scanner(System.in);
        String fileName;
        System.out.println("Enter file name: ");
        fileName=scnr.next();

        try{
            Scanner reader = new Scanner(new File(fileName));
            Scanner lineScanner;
            String word="";

            String line;

            System.out.println("Problem 1: ");
            //reads each line
            while(reader.hasNextLine()){
                line=reader.nextLine();
                lineScanner = new Scanner(line);
                reverseString(line);

            }
            reader.reset();
            reader = new Scanner (new File(fileName));
            System.out.println();

            System.out.println("Problem 2: ");
            while(reader.hasNextLine()){
                line=reader.nextLine();
                lineScanner = new Scanner(line);
                if(palidrome(line)){
                    System.out.println("\""+ line + "\""+ " is a palidrome.");

                }
                else{
                    System.out.println("\""+ line + "\""+" is not a palidrome."); 

                }

            }
            reader.reset();
            reader = new Scanner (new File(fileName));
            System.out.println();
            System.out.println("Problem 3: ");
            while(reader.hasNextLine()){
                line=reader.nextLine();
                lineScanner = new Scanner(line);

                stackCompareQueue(line);
                if(stackCompareQueue(line)){
                    System.out.println("\""+ line + "\""+ " is a palidrome."); 
                }
                else{
                    System.out.println("\""+ line + "\""+ " is not a palidrome."); 

                }

            }
            reader.close();
        }
        catch(FileNotFoundException excpt){
            System.out.println("File not found");
        }
        catch(IOException excpt){
            System.out.println("File not found");

        }

    }
}
