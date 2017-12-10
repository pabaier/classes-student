import java.util.*;
import java.io.*;

/**
 * Write a description of class main here.
 *
 * @author Carter Haley
 * homework 7
 * @version (a version number or a date)
 */
public class homework7
{
    public static void main(String[] args) throws Exception{
        Scanner name = new Scanner(System.in);
        FileInputStream fileStream = null; // File input stream
        Scanner file = null;// Scanner object
        FileInputStream fileStream2= null;
        Scanner file2 = null;
        Deque<String> stringStack = new ArrayDeque<>();
        // Try to open file
        System.out.println("Enter a valid filename: ");

        String filename = name.next();
        try{
            System.out.println("Opening " + filename);
            fileStream= new FileInputStream(filename);
            file = new Scanner(fileStream);
         
        }catch(Exception e){
            System.out.println(e);
        }  
        while (file.hasNext()){
            stringStack.push(file.nextLine());
            String reverse = "";
            String str = stringStack.pop();
            String[] list = str.split(" ");
            for(int i =list.length-1; i>=0; i--){
                reverse += (list[i]+" ");
            }
            System.out.println();
            System.out.println("The reverse of the line " + str + " is " + reverse);
                
        }
        fileStream.close();
        try{
            fileStream= new FileInputStream(filename);
            file = new Scanner(fileStream);
         
        }catch(Exception e){
            System.out.println(e);
        }  
        Deque<String> palStack = new ArrayDeque<>();
        boolean pal = true;

        while (file.hasNext()){
            palStack.push(file.nextLine());
    
        while(!palStack.isEmpty()){
            String front = palStack.removeFirst();
            int length = front.length() -1;
            for (int i =0; i <= length/2; i++){
                front.toLowerCase();
                if(front.charAt(i) == (front.charAt(length - i)) || front.length()<2){
                    pal = true;
                }
                else{
                    pal = false;
            }
        }
        System.out.println();
        
    System.out.println('"'+ front + '"' + " is a character-wise palindrome: " + pal);
   }
}


        
    fileStream.close();
    
    try{
            fileStream= new FileInputStream(filename);
            file = new Scanner(fileStream);
            fileStream2= new FileInputStream(filename);
            file2 = new Scanner(fileStream2);
         
        }catch(Exception e){
            System.out.println(e);
        }
        Deque<String> wordStack = new ArrayDeque<>();
        
        boolean same = true;
        Deque<String> wordQueue = new LinkedList<>();


        while (file.hasNext()){
            String str = file.nextLine();
            String queue = file2.nextLine();
            
            String[] stackArr = str.split(" ");
            String[] queueArr = queue.split(" ");
            
            int length = stackArr.length;
            for (int i = 0; i < length; i++){
                    wordQueue.addLast(queueArr[i].toLowerCase());
                    wordStack.push(stackArr[i].toLowerCase());
                }
                while (!wordStack.isEmpty() || !wordQueue.isEmpty()){
                    String stack = wordStack.pop();
                    String qu = wordQueue.pop();
                    if (stack.equals(qu)){
                        same = true;
                    }
                    else{
                        same = false;
                    }
            }
            System.out.println();
            System.out.println(str + " is a word-wise palindrome: "+same);
        }

     //end program   
    
    }}

        



        
 
    