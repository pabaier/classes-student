
/**
 * Reading in a file, using stacks and queues to print the reverse order of the contents, 
 * and determine wheter or not any lines are palindromes
 *
 * @author Jonathan Rabiu
 * 
 */
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class HW7
{
    public static void main(String [ ] args){
        try{
            //Problem 1
            Deque<String> stack1 = new ArrayDeque<>();
            File file = null;
            Scanner read = null;
            System.out.println("Enter the name of the file to be read");
            Scanner scnr = new Scanner(System.in);
            String filename = scnr.nextLine();
            file = new File(filename);
            read = new Scanner(file);
            while(read.hasNext()){
                stack1.push(read.next());
            }
            Scanner readagain = new Scanner(file);
            System.out.print("The reverse of " + "'");
            while(readagain.hasNext()){
                System.out.print(readagain.next() + " ");
            }
            System.out.print("'" +"is "+ "'");

            for(String word: stack1){
                System.out.print(stack1.pop() +" ");
            }
            System.out.print("'" + "\n");

            //Problem 2
            Deque<String> stack2 = new ArrayDeque<>();
            Scanner read2 = new Scanner(file);

            while(read2.hasNext()){
                stack2.push(read2.nextLine());
            }  
            String isaP = "";
            while(!stack2.isEmpty()){
                isaP = stack2.pop();
                //System.out.print(isaP); test pop
                if(isaP.length() < 2){
                    System.out.println("'" + isaP + "'" + " is a palindrome");
                }else{
                    if(isaP.substring(0, 1).compareTo(isaP.substring(isaP.length()-1)) == 0) {
                        stack2.push(isaP.substring(1,isaP.length()-1));
                    }else{
                        System.out.println("'"+ isaP + "'" + " is not a palindrome");
                    }
                }

            }

            //Problem 3
            Deque<String> queue1 = new ArrayDeque<>();
            Deque<String> stack3 = new ArrayDeque<>();
            Scanner read3 = new Scanner(file);
            while(read3.hasNext()){
                stack3.push(read3.next());
                queue1.addLast(stack3.peek());
            }

            /*
            //printing queue to see contents
            while(!queue1.isEmpty()){
            System.out.println("Printing queue1: " + queue1.removeFirst());
            }
            //printing stack to see contents
            while(!stack3.isEmpty()){
            System.out.println("Printing stack3: " + stack3.pop());
            }*/

            while(!queue1.isEmpty()){
                if(!queue1.removeFirst().equals(stack3.pop())){
                    System.out.println(queue1.peekFirst() + " " + stack3.peek()  + " is not a palindrome");
                }else{
                    System.out.println(queue1.peekFirst() + " " + stack3.peek() + " is a palindrome");}
            }

        }
        catch(FileNotFoundException e){
            System.err.println("File not found! Enter the correct file name");
        }

    }
}

