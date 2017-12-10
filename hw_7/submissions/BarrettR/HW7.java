/**
 * HW7 problems n stuff
 * @author RyanBarrett
 */    
import java.util.*;
import java.io.FileInputStream;
public class HW7 {
    /**
     * Tests problems 1, 2, and 3
     */
    public static void main(String[] args) {
        FileInputStream fileReader = null;
        
        //gets name of file
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name of file: ");
        String fileName = scan.nextLine();
        
        //problem one
        try{
            fileReader = new FileInputStream(fileName);
            Scanner problemOneScanner = new Scanner(fileReader);
            while(problemOneScanner.hasNextLine()){
                String currentLine = problemOneScanner.nextLine();
                System.out.print("The reverse \"" + currentLine + "\" is \"");
                Deque<String> line = new ArrayDeque<>();
                for(int i = 0; i < currentLine.length(); i++)
                    line.push(currentLine.substring(i, i + 1));
                while(!line.isEmpty())
                    System.out.print(line.pop());
                System.out.print("\"");
                System.out.println();
            }
            System.out.println("End of Problem One\n\n\n");
            fileReader.close();
        }catch(Exception e){
            System.out.println("something went wrong");
        }

        //problem two
        try{
            fileReader = new FileInputStream(fileName);
            Scanner problemTwoScanner = new Scanner(fileReader);
            while(problemTwoScanner.hasNextLine()){
                String currentLine = problemTwoScanner.nextLine();
                Deque<String> back = new ArrayDeque<>();
                Deque<String> front = new ArrayDeque<>();
                int count = 0;
                for(int i = 0; i < currentLine.length(); i++){
                    back.push(currentLine.substring(i, i + 1));
                    count++;
                }
                for(int i = currentLine.length() - 1; i >= 0; i--)
                    front.push(currentLine.substring(i, i + 1));
                boolean isPalindrome = true;
                while(count > 1){
                    if(!front.pop().equals(back.pop()))
                        isPalindrome = false;
                    count--;
                }
                if(!isPalindrome)
                    System.out.println("\"" + currentLine + "\" is not a palindrome.");
                else
                    System.out.println("\"" + currentLine + "\" is a palindrome.");
            }
            System.out.println("End of Problem Two\n\n\n");
            fileReader.close();
        }catch(Exception e){
            System.out.println("something went wrong");
        }

        //problem three
        try{
            fileReader = new FileInputStream(fileName);        
            Scanner problemThreeScanner = new Scanner(fileReader);
            while(problemThreeScanner.hasNextLine()){
                String currentLine = problemThreeScanner.nextLine();
                Scanner currentLineScan = new Scanner(currentLine);
                Queue<String> forwards = new LinkedList<>();
                Deque<String> backwards = new ArrayDeque<>();
                while(currentLineScan.hasNext()){
                    String word = currentLineScan.next();
                    forwards.add(word);
                    backwards.push(word);
                }
                boolean isPalindrome = true;
                while(!backwards.isEmpty())
                    if(!backwards.pop().equals(forwards.remove()))
                        isPalindrome = false;
                if(!isPalindrome)
                    System.out.println("\"" + currentLine + "\" is not a palindrome.");
                else
                    System.out.println("\"" + currentLine + "\" is a palindrome.");
                fileReader.close();
            }
            System.out.println("End of Problem Three\n\n\n");
        }catch(Exception e){
            System.out.println("something went wrong");
        }
    }
}