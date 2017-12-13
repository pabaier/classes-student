import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Michael Dudley

public class HW7 {

    private static String stackSwitch(String line) throws FileNotFoundException {
        Deque<String> myStack = new ArrayDeque<>();
        String[] words = line.split(" ");
        for (String word : words) {
            myStack.push(word);
        }
        String returnString = "";
        while (!myStack.isEmpty()) {
            returnString += myStack.pop() + " ";
        }
        return returnString;
    }

    private static String palinDrome1(String l) throws FileNotFoundException {

        Deque<String> myStack = new ArrayDeque<>();
        String line = l;
        myStack.push(line);
        while (!myStack.isEmpty()) {
            line = myStack.pop();
            if (line.length() < 2) {
                return l + " is a palindrome";
            } else {
                if (line.substring(0, 1).equals(line.substring(line.length() - 1))) {
                    myStack.push(line.substring(1, line.length() - 1));
                } else {
                    return l + " is not a palindrome";
                }
            }
        }
        return "No words";
    }


    private static String palinDrome2(String line) throws FileNotFoundException {
        Deque<String> myStack = new ArrayDeque<>();
        Deque<String> myQue = new ArrayDeque<>();

        String[] words = line.split(" ");
        if(words.length == 0){
            return "No words";
        }
        for (String word : words) {
            myQue.addLast(word);
            myStack.push(word);
        }
        while (!myStack.isEmpty() || !myQue.isEmpty() ) {
            if (!myStack.pop().equals(myQue.removeFirst())) {
//               return line + " is a palindrome";
                return line + " is not a palindrome";
            }
        }
        return line + " is a palindrome";
    }

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Type your file");
        try {
            Scanner scnr = new Scanner(System.in);
            File file1 = new File(scnr.nextLine());
            scnr = new Scanner(file1);
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                String reverseString = stackSwitch(line);
                System.out.println("The reverse of " + line + " is " + reverseString);
                System.out.println(palinDrome1(line));
                System.out.println(palinDrome2(line));
                System.out.println();

            }

        }catch (Exception e) {
            System.out.println("File Not Found");
        }


    }
}
