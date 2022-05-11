/*
 * Sydney Jackson
 * Using Stack ADT, Queue ADT and Deque to determine if strings meet specific criteria
 * given in assignment.
 */
import java.util.Deque;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.io.IOException;
public class HW7{
    public static void main(String[] args) throws IOException{
        System.out.println("Part 1:");
        Deque<String> stack1 = new ArrayDeque<>();
        FileInputStream fileStream = null; //file input stream initialized to null (opens file)
        Scanner inMyFile = null; //scanner to scan through file
        Scanner fileInput = new Scanner(System.in); //scanner to receive file name
        Scanner lineReader = null;
        //prompt user for file name
        System.out.println("Enter a file to be read: ");
        String myFile = fileInput.next(); //gets file name from user input
        
        boolean cont = true;
        
        try {
            //System.out.println("Opening file " + myFile + ".");
            //Opening file
            fileStream = new FileInputStream(myFile); //may throw FileNotFoundException
            inMyFile = new Scanner(fileStream);
        }
        catch (IOException excpt) {
            cont = false;
            System.out.println(excpt.getMessage());
        }
        while (inMyFile.hasNextLine()){
            String line = inMyFile.nextLine();
            System.out.print("The reverse ' " + line + " ' is ' " );
            lineReader = new Scanner(line);
            while(lineReader.hasNext()){
                stack1.push(lineReader.next());
            }
            while (!stack1.isEmpty()){
                System.out.print(stack1.pop() + " ");
            }
            System.out.print("'");
            System.out.println();
        }
        System.out.println("Part 2:");
        inMyFile.close();
        fileStream = new FileInputStream(myFile); //may throw FileNotFoundException
        inMyFile = new Scanner(fileStream);
        boolean isPal = false;
        while (inMyFile.hasNextLine()){
            String line = inMyFile.nextLine();
            stack1.push(line);
            System.out.print("' " + line);
            while(!stack1.isEmpty()){
                String input = stack1.pop();
                if(input.length() < 2){
                    isPal = true;
                }
                else{
                    if (input.charAt(0) == input.charAt(input.length() - 1)){
                        isPal = true;
                    }
                    else{
                        isPal = false;
                    }
                }
            }
            if (isPal){
                System.out.print(" ' is a palindrome");
            }
            else{
                System.out.print(" ' is not a palindrome");
            }
            System.out.println();
            //System.out.print(isPal);
        }
        System.out.println("Part 3:");
        inMyFile.close();
        fileStream = new FileInputStream(myFile); //may throw FileNotFoundException
        inMyFile = new Scanner(fileStream);
        boolean isPal2 = false;
        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> stack2 = new ArrayDeque<>();
        String stackString = "";
        String queueString = "";
        while (inMyFile.hasNextLine()){
            String line = inMyFile.nextLine();
            lineReader = new Scanner(line);
            System.out.print("' " + line + " '");
            while (lineReader.hasNext()){
                String nextWord = lineReader.next();
                stack2.push(nextWord);
                queue1.addLast(nextWord);
            }
            while (!stack2.isEmpty()){
                String stackWord = stack2.pop();
                stackString += stackWord;
                String queueWord = queue1.removeFirst();
                queueString += queueWord;
                //System.out.println(queueString + " "  + stackString);
                if (stackString.equals(queueString)){
                    isPal2 = true;
                }
                else {
                    isPal2 = false;
                }
            }
            if (isPal2){
                System.out.println(" is a palindrome");
            }
            else{
                System.out.println(" is not a palindrome");
            }
            //System.out.println(isPal2);
            stackString = "";
            queueString = "";
        }
    }
}