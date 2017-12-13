import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * Write a description of class HW7 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HW7
{
    public static void main (String [] args) throws IOException{
        FileInputStream fileByteStream = null;
        Scanner inFS = null;
        
        Deque<String> stackName = new ArrayDeque<>();
        
        // problem #1
        
        System.out.println("Problem 1");
        System.out.println("Opening file file.txt");
        
        fileByteStream = new FileInputStream("/mnt/sda5/School/221/hw_7/grader/input.txt");
        inFS = new Scanner(fileByteStream);
        String fileLine;
        String fileText;
        while(inFS.hasNextLine()){
            fileLine = inFS.nextLine();
            Scanner lineScanner = new Scanner(fileLine);
            System.out.print("The reverse of \"" + fileLine + "\" is");
            while(lineScanner.hasNext()){
                fileText = lineScanner.next();
                stackName.addFirst(fileText);
            }
            while(!stackName.isEmpty()){
                System.out.print(" " + stackName.removeFirst());
            }
            System.out.println("");
        }
        System.out.println("\n\n");
        
        //Problem #2
        

        System.out.println("Problem 2");
        System.out.println("Opening file file.txt");
        
        fileByteStream = new FileInputStream("/mnt/sda5/School/221/hw_7/grader/input.txt");
        inFS = new Scanner(fileByteStream);

        while(inFS.hasNextLine()){
            fileLine = inFS.nextLine();
            stackName.addFirst(fileLine);
            System.out.print("\"" + fileLine + "\"");
            while(!stackName.isEmpty()){
                String line = stackName.pop();
    
                if(line.length() < 2){
                    System.out.println(" is a Palindrome");
                }
                else{
                    if(line.charAt(0) == line.charAt(line.length() -1)){
                        stackName.addFirst(line.substring(1,line.length()-1 ));
                    }
                    else{
                        System.out.println(" is not a palindrome");
                    }
                }
            }
        }
        System.out.println("\n\n");
        
        //Problem #3
        Deque<String> queueName = new ArrayDeque<>();
        
        System.out.println("Problem 3");
        System.out.println("Opening file file.txt");
        
        fileByteStream = new FileInputStream("/mnt/sda5/School/221/hw_7/grader/input.txt");
        inFS = new Scanner(fileByteStream);

        while(inFS.hasNextLine()){
            fileLine = inFS.nextLine();
            Scanner lineScanner = new Scanner(fileLine);
            System.out.print("\"" + fileLine + "\" ");
            while(lineScanner.hasNext()){
                fileText = lineScanner.next();
                queueName.addLast(fileText);
                stackName.addFirst(fileText);
            }
            while(!queueName.isEmpty() && !stackName.isEmpty()){
                String stackWord = stackName.pop();
                String queueWord = queueName.removeFirst();
                if(queueName.isEmpty() && stackWord.equals(queueWord)){
                    System.out.println(" is a Palindrome");
                }
                else if(!stackWord.equals(queueWord)){
                    System.out.println(" is not a Palindrome");
                    while(!queueName.isEmpty()){
                        queueName.removeFirst();
                    }
                }
            }
        }
    }

    
    public HW7()
    {
        // initialise instance variables
        
    }


}
