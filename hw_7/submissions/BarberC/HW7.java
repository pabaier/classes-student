/**
 * @author Carson Barber
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
public class HW7
{
    public static void main(String[] args) throws IOException{
        Scanner userScnr = new Scanner(System.in);
        System.out.println("Please enter the name of the file to be read. (Test file is named \"ToRead.txt\"");
        Scanner fileScnr;
        String fileName = userScnr.next();
        //create scanner associated with file
        try{
            FileInputStream fileStream = new FileInputStream(fileName);
            fileScnr = new Scanner(fileStream);
        }
        catch (IOException expt){
            System.out.println("File not found. Exiting...");
            return;
        }
        //print the reverse of each ine, wordwise
        System.out.println("Printing reverse of file...");
        while(fileScnr.hasNextLine()){
            printReverse(fileScnr.nextLine());
        }
        System.out.println();
        //reset scanner associated with file
        try{
            FileInputStream fileStream = new FileInputStream(fileName);
            fileScnr = new Scanner(fileStream);
        }
        catch (IOException expt){
            System.out.println("File not found. Exiting...");
            return;
        }
        //tell whether each line is a palindrome or not, letterwise
        System.out.println("Checking file for letterwise palindromes...");
        while(fileScnr.hasNextLine()){
            String s = fileScnr.nextLine();
            if(isLetterwisePalindrome(s)){
                System.out.println("\"" + s + "\" is a letterwise palindrome");
            }
            else System.out.println("\"" + s + "\" is not a letterwise palindrome");
        }
        System.out.println();
        //reset scanner associated with file
        try{
            FileInputStream fileStream = new FileInputStream(fileName);
            fileScnr = new Scanner(fileStream);
        }
        catch (IOException expt){
            System.out.println("File not found. Exiting...");
            return;
        }
        //tell whether each line is a palindrome or not, wordwise
        System.out.println("Checking file for wordwise palindromes...");
        while(fileScnr.hasNextLine()){
            String s = fileScnr.nextLine();
            if(isWordWisePalindrome(s)){
                System.out.println("\"" + s + "\" is a wordwise palindrome");
            }
            else System.out.println("\"" + s + "\" is a not wordwise palindrome");
        }
    }
    public static void printReverse(String s){
        Scanner scnr = new Scanner(s);
        Deque<String> deque = new ArrayDeque<>();
        while(scnr.hasNext()){
            deque.push(scnr.next());
        }
        while(!deque.isEmpty()){
            System.out.print(deque.pop() + " ");
        }
        System.out.println();
    }
    public static boolean isLetterwisePalindrome(String s){
        s = s.toLowerCase();
        Scanner scnr = new Scanner(s);
        Deque<String> deque = new ArrayDeque<>();
        deque.push(s);
        while(!deque.isEmpty()){
            s = deque.pop();
            if(s.length() < 2)return true;
            //return false if two letters mismatch
            if(!s.substring(0,1).equals(s.substring(s.length()-1)))return false;
            deque.push(s.substring(1,s.length()-1));
        }
        return true;
    }
    public static boolean isWordWisePalindrome(String s){
        s = s.toLowerCase();
        Scanner scnr = new Scanner(s);
        Deque<String> deque = new ArrayDeque<>();
        Deque<String> queue = new ArrayDeque<>();
        while(scnr.hasNext()){
            String toPush = scnr.next();
            deque.push(toPush);
            queue.addLast(toPush);
        }
        while(!deque.isEmpty() && !queue.isEmpty()){
            String s1 = deque.pop();
            String s2 = queue.removeFirst();
            //return false if two words mismatch
            if(!s1.equals(s2))return false;
        }
        return true;
    }
}
