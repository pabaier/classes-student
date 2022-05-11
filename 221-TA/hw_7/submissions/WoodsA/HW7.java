import java.util.Deque;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class HW7
{  
    public static void main (String[] args) throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scnr.next();
        try {
            FileInputStream file = new FileInputStream(fileName);
            Scanner fileScnr = new Scanner(file);
            //Problem one
            System.out.println("Problem 1:");
            while (fileScnr.hasNextLine()){
                reverseSentence(fileScnr.nextLine());
            }
            //reset file
            file = new FileInputStream(fileName);
            Scanner fileScnr2 = new Scanner(file);
            //problem two
            System.out.println("Problem 2:");
            while (fileScnr2.hasNextLine()) {
                isPalindrome(fileScnr2.nextLine());
            }
            //reset file
            file = new FileInputStream(fileName);
            Scanner fileScnr3 = new Scanner(file);
            //problem three
            System.out.println("Problem 3:");
            while (fileScnr3.hasNextLine()) {
                isPalindromeWordLevel(fileScnr3.nextLine());
            }
        }
        catch (Exception E) {
            System.out.print("File not found");
        }
    }
    
    public static void reverseSentence(String line){
        Deque<String> stack1 = new ArrayDeque<>();
        int spaceIndex = line.indexOf(" ");
        String thisLine = line;
        while (spaceIndex > 0) {
            stack1.push(thisLine.substring(0,spaceIndex));
            thisLine = thisLine.substring(spaceIndex);
            thisLine = thisLine.trim();
            spaceIndex = thisLine.indexOf(" ");
        }
        stack1.push(thisLine);
        System.out.print("The reverse of \"" + line + "\" is \"");
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop());
            if (!stack1.isEmpty()) {
                System.out.print(" ");
            }
        }
        System.out.println("\"");
    }
    
    public static void isPalindrome(String line){
        Deque<String> stack1 = new ArrayDeque<>();
        boolean isPalindrome = true;
        String text = line;
        int length = line.length();
        stack1.push(text);
        while (length != 0 && length != 1 && isPalindrome) {
            if(stack1.peek().charAt(0) == stack1.peek().charAt(length-1)){
                stack1.push(stack1.peek().substring(1,length-1));
                length = stack1.peek().length();
            }
            else {
                isPalindrome = false;
            }
        }
        if (isPalindrome) {
            System.out.println("\"" + line + "\" is a palindrome.");
        }
        else {
            System.out.println("\"" + line + "\" is not a palindrome.");
        }
    }
    
    public static void isPalindromeWordLevel(String line) {
        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> stack1 = new ArrayDeque<>();
        boolean isPalindrome = true;
        String text = line;
        int indexZero = text.indexOf(" ");
        while (indexZero > 0) {
            queue1.addLast(text.substring(0,text.indexOf(" ")));
            stack1.push(text.substring(0,text.indexOf(" ")));
            text = text.substring(text.indexOf(" "));
            text = text.trim();
            indexZero = text.indexOf(" ");
        }
        queue1.addLast(text);
        stack1.push(text);
        while(isPalindrome && !queue1.isEmpty() && !stack1.isEmpty()){
            if (queue1.removeFirst().equalsIgnoreCase(stack1.pop())) {
            }
            else {
                isPalindrome = false;
            }
        }
        if (isPalindrome) {
            System.out.println("\"" + line + "\" is a palindrome.");
        }
        else {
            System.out.println("\"" + line + "\" is not a palindrome.");
        }
    }
}
