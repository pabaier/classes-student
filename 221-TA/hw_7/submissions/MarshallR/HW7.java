import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * A set of methods for parsing information from a text file given from user input
 * Contains a main() test driver method, a problemOne() method for reversing lines of text from a file on the word level,
 * a problemTwo() method for checking lines of text from the file to see if they are palindromes on a character level,
 * and a problemThree() method for checking lines of text from the file to see if they are palindromes on a word level
 *
 * @author Richard Marshall
 * @version 12/3/17
 */
public class HW7
{
    /**
     * main() - a test driver method for methods problemOne(), problemTwo(), and problemThree().
     * takes a file name from user input in the console, and uses that file in the three other methods,
     * printing the results on screen.
     *
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean contin = true;
        FileInputStream fileStream = null;
        String file = null; //this will be used to reopen the file outside of the loop I create below to ensure the user enters a valid file name
        
        while (contin) { //this will loop until the user enters a valid file name and create a fileinputstream if it is valid
            System.out.println("Please enter the name of the file you wish to process: ");
            String fileName = scnr.nextLine();
            
            try {
                fileStream = new FileInputStream(fileName);
                contin = false;
                file = fileName;
            }
            catch (IOException exp){
                System.out.println("Invalid file name.");
                contin = true;
            }
        }
        
        System.out.println("Testing function for reversing lines by word ");
        problemOne(fileStream);
        
        //each time I wish to test the file I need to reset it by closing and reopening the file
        try {
            fileStream.close();
            fileStream = new FileInputStream(file);
        }
        catch (IOException exp) {
            System.out.println("IOException caught on attempting to close file or reset file position: " + exp.getMessage()); 
        }
        
        System.out.println("\nTesting function for checking for palindromes at the character level");
        problemTwo(fileStream);
        
        try {
            fileStream.close();
            fileStream = new FileInputStream(file);
        }
        catch (IOException exp) {
            System.out.println("IOException caught on attempting to close file or reset file position: " + exp.getMessage()); 
        }
        
        System.out.println("\nTesting function for checking for palindromes at the word level");
        problemThree(fileStream);
        
        //While I don't need to reset the fileinputstream again, I do need to close it so I do so here 
        try {
            fileStream.close();
        }
        catch (IOException exp) {
            System.out.println("IOException caught on attempting to close file or reset file position: " + exp.getMessage()); 
        }
        return;
    }
    
    /**
     * problemOne(FileInputStream fileStream) - a method that takes a file, parsing it for text and reversing any text at the word level before printing it on screen
     *
     * @param  fileStream  the fileStream of the file which you wish to parse
     */
    public static void problemOne(FileInputStream fileStream) {
        Scanner fileScnr = new Scanner(fileStream);
        Deque<String> stack = new ArrayDeque<>();
        
        while (fileScnr.hasNextLine()) {
            Scanner lineScnr = new Scanner(fileScnr.nextLine());
            String printString = "";
            
            while (lineScnr.hasNext()) {
                stack.addFirst(lineScnr.next());
            }
            
            while (!(stack.isEmpty())) {
                printString += stack.removeFirst() + " ";
            }
            
            System.out.println(printString);
        }
        
        return;    
    }
    
    
    /**
     * problemTwo(FileInputStream fileStream) - a method that takes a file, parsing it for text and checking to see if each line is a palindrome on the character level
     * 
     * @param  fileStream  the fileStream of the file which you wish to parse
     */
    public static void problemTwo(FileInputStream fileStream) {
        Scanner fileScnr = new Scanner(fileStream);
        Deque<String> stack = new ArrayDeque<>();
        
        while (fileScnr.hasNextLine()) {
            boolean isDrome = false;
            String initialString = fileScnr.nextLine();
            stack.addFirst(initialString);
            
            
            while (!(stack.isEmpty())) {
                String checkString = stack.removeFirst().toLowerCase();
                char firstChar = checkString.charAt(0);
                char lastChar = checkString.charAt(checkString.length() - 1);
                
                    if (checkString.length() < 2) {
                        isDrome = true;
                    }
                    else if (firstChar == lastChar) {
                        stack.addFirst(checkString.substring(1,checkString.length() - 1));    
                    }
                    else {
                        isDrome = false;
                    }
                }
            
            if (isDrome) {
                System.out.println("\"" + initialString + "\" is a palindrome.");
            }
            else {
                System.out.println("\"" + initialString + "\" is not a palindrome.");
            }
        }
        
        return;
    }
    
    /**
     * problemThree(FileInputStream fileStream) - a method that takes a file, parsing it for text and checking to see if each line is a palindrome on the word level
     *
     * @param  fileStream  the fileStream of the file which you wish to parse
     */
    public static void problemThree(FileInputStream fileStream) {
        Scanner fileScnr = new Scanner(fileStream);
        
        
        while (fileScnr.hasNextLine()) {
            String initialString = fileScnr.nextLine();
            Scanner lineScnr = new Scanner(initialString.toLowerCase());//the toLowerCase is optional, I chose to include it to make this implementation not case sensitive
            Deque<String> stack = new ArrayDeque<>();
            Deque<String> queue = new ArrayDeque<>();
            boolean isDrome = true;
            
            while (lineScnr.hasNext()) {
                String item = lineScnr.next();
                stack.addFirst(item);
                queue.addLast(item);
            }
            
            while ((!(stack.isEmpty())) && isDrome) {
                String stackItem = stack.removeFirst();
                String queueItem = queue.removeFirst();
                if (!(stackItem.equals(queueItem))){
                    isDrome = false;
                }
            }
            
            if (isDrome) {
                System.out.println("\"" + initialString + "\" is a palindrome.");
            }
            else {
                System.out.println("\"" + initialString + "\" is not a palindrome.");
            }
        }
        
        return;
    }
}
