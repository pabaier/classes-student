
/**
 * HW7 file, working with stacks
 *
 * @author Andrea Lingenfelter
 * @version December 2017
 */
import java.util.*;
import java.io.*;
public class HW7 {
    
    //problem 1, reading input file and outputting reverse of each line
    public static void problem1(String fileName){
        System.out.println("Excercise 1: Printing the words in reverse order. \n");
        FileInputStream fileByteStream = null;
        
        Scanner inStream = null;
        String file = fileName;
        Deque<String> reverse = new ArrayDeque<>();
        
        try{
            file = fileName;
            fileByteStream = new FileInputStream(fileName);
            inStream = new Scanner(fileByteStream);
            String output = "\"";
            
            while (inStream.hasNextLine()) {
                String line = inStream.nextLine();
                String words[] = line.split(" ");
                
                for (int i = 0; i < words.length; i++){
                    reverse.push(words[i].toString());
                }
                for (int i = 0; i < words.length; i++){
                    output = output + reverse.pop().toString() + " ";
                }
                output = output.trim() + "\"";
                System.out.println("The reverse of \"" + line + "\" is " + output);
                output = "\"";
                
            }
            
            fileByteStream.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }      
    }
    
    //problem 2: Reading an input file and determining if each line is a palindrome 
    // by character
    public static void problem2(String fileName){
        System.out.println("Exercise 2: Determining if the string is a palindrome by character. \n");
        FileInputStream fileByteStream = null;
        Scanner inStream = null;
        Boolean b = true;
        String isOrNot = "is";
        String file = fileName;
        Deque<String> palindrome = new ArrayDeque<>();
        char first = ' ';
        char last = ' ';
        
        try{
            
            fileByteStream = new FileInputStream(fileName);
            inStream = new Scanner(fileByteStream);
            
            while (inStream.hasNextLine()) {
                String line = inStream.nextLine();
                palindrome.push(line);
                
                
                while (b == true && !palindrome.isEmpty()){
                   
                    String work = palindrome.pop();
                    work = work.toUpperCase();
                    first = work.charAt(0);
                    last = work.charAt(work.length() - 1);
                    
                    
                    if (!(first == last)) {
                        b = false;
                    }
                    else {
                        work = work.substring(1, work.length() - 1);
                    
                          if (work.length() > 2){
                             palindrome.push(work);
                         }
                    }                  
                }
                
                if (b){ 
                    isOrNot = "is";
                }
                else {
                    isOrNot = "is not";
                }
                System.out.println("\"" + line + "\" " + isOrNot + " a palindrome.");
                b = true;
            }
            
            fileByteStream.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }      
    }
    
    
    
    
    //problem 3: reading input file and determine if line is palindrome using stack and queue
    
    public static void problem3(String fileName){
        System.out.println("Exercise 3: Determining if the string is palindrome by word. \n");
        FileInputStream fileByteStream = null;
        Scanner inStream = null;
        Boolean b = true;
        String isOrNot = "is";
        String file = fileName;
        Deque<String> stack = new ArrayDeque<>();
        Deque<String> queue = new ArrayDeque<>();
        String first = "";
        String last = "";
        
        try{
            
            fileByteStream = new FileInputStream(fileName);
            inStream = new Scanner(fileByteStream);
            
            while (inStream.hasNextLine()) {
                String line = inStream.nextLine();
                String [] pWords = line.split(" ");
                
                for (int i = 0; i < pWords.length; i++){
                    stack.push(pWords[i]);
                    queue.addLast(pWords[i]);
                }
                
                while (b == true && !stack.isEmpty()){
                    first = stack.pop();
                    first = first.toUpperCase();
                    last = queue.pop();
                    last = last.toUpperCase();
                                 
                    if (first.compareTo(last) != 0) {
                        b = false;
                        stack.clear();
                        queue.clear();
                    }       
                    
                    
                }
               
                
                if (b){ 
                    isOrNot = "is";
                }
                else {
                    isOrNot = "is not";
                }
                System.out.println("\"" + line + "\" " + isOrNot + " a palindrome.");
                 b = true;
            }
            
            fileByteStream.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }      
    }
    
    public static void main (String args[]){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter filename: ");
        String fileName = scnr.nextLine();
            
        problem1(fileName);
        System.out.println();
        problem2(fileName);
        System.out.println();
        problem3(fileName);
        
    }
    
}
