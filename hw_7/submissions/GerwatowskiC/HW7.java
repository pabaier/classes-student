
/**
 * Practice using stack ADT
 *
 * Claire Gerwatowski
 * 29 November 2017
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class HW7
{
    public static void main(String [] args) 
    {
        try {
            System.out.print("Enter file name: ");
            Scanner scnr = new Scanner(System.in);
            String fileName = scnr.next();
            System.out.println("\nProblem1: ");
            Reverse(fileName);
            System.out.println("\nProblem2: ");
            Palindrome(fileName);
            System.out.println("\nProblem 3: ");
            QPalindrome(fileName); 
        }
        catch (IOException excpt){
            System.out.println("File not found");
        }
        catch (Exception excpt) {
            System.out.println(excpt.getMessage() + excpt);
        }
    }

    public static void Reverse(String file) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(file);
        Scanner inStream = new Scanner(inputStream);
        Deque<String> stack = new ArrayDeque<>();
        while(inStream.hasNextLine()){
            String[] line;
            String list = inStream.nextLine();
            line = list.split(" ");
            for (int i=0; i<line.length; i++) {
                stack.add(line[i]);
                stack.push(line[i]);
            }
            for (int j=0; j<line.length; j++)
                System.out.print(stack.pop() + " ");
            System.out.println();
            }
    }
   
    public static void Palindrome(String file) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(file);
        Scanner inStream = new Scanner(inputStream);
        Deque<String> stack = new ArrayDeque<>();
        while(inStream.hasNextLine()){
            String line = inStream.nextLine();
            stack.push(line);
            while (!stack.isEmpty()) {
                String word = stack.pop();
                if (word.length()<2)
                    System.out.println(line + " is a palindrome");
                else {
                    if (word.charAt(0)==word.charAt(word.length()-1)) {
                        stack.push(word.substring(1,word.length()-1));
                    }
                    else {
                        System.out.println(line + " is not a palindrome");
                    }
                }
            }
        }
    }
    
    public static void QPalindrome(String file) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(file);
        Scanner inStream = new Scanner(inputStream);
        while (inStream.hasNextLine()) {
            Deque<String> stack = new ArrayDeque<>();
            Deque<String> queue = new ArrayDeque<>();
            boolean palin = true;
            String[] line;
            String list = inStream.nextLine();
            list = list.replace("\n","");
            line = list.split(" ");
            for (int i=0; i<line.length; i++) {
                stack.push(line[i]);
                queue.addLast(line[i]);
            }
            
            while (palin==true && stack.isEmpty()==false) {
                String word1 = stack.pop();
                String word2 = queue.removeFirst();
                
                if (word1.equals(word2)) {
                    palin=true;
                    if (stack.isEmpty())
                        System.out.println(list + " is a palindrome");
                }
                else {
                    palin=false;
                    System.out.println(list + " is not a palindrome");
                }
            }
        }
    }
}

