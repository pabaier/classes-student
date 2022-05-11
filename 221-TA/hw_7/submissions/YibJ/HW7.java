
/**
 * Reading a file and reversing the string 
 *
 * Julie Yib 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class HW7 
{
    public static void main(String [] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        String fileName = "";
        
        System.out.println("Please insert a file name: ");
        fileName = input.nextLine();

        
        
        try {
            Scanner read = new Scanner(new File (fileName));
            Deque<String> line = new ArrayDeque<>();
            //part1 
            while(read.hasNextLine()){
                String next = read.nextLine();
                try{
                    
                    for(String w : next.split(" ")){
                        line.push(w);
                    }
                    
                    System.out.print("The reverse is: ");
                  
                    for (String reverse : line){
                      System.out.print(line.pop() + " ");
                     
                    }
                    System.out.println();
                }
                catch(Exception e){
                    System.out.print("An error has occured");
                }

            }
            //part2 
            read.reset();
            read = new Scanner(new File (fileName));
            
            while(read.hasNextLine()){
                String scan = read.nextLine();
                boolean palindromeX = palindrome(scan);
                System.out.println(scan);
                if(palindromeX){
                    System.out.println(" is a palindrome.");
                }
                else{
                    System.out.println(" is not a palindrome.");
                }
            }
            
            //part3
            read.reset();
            read = new Scanner(new File (fileName));
            
            while(read.hasNextLine()){
                String scan = read.nextLine();
                boolean palindromeX = wordPalindrome(scan);
                System.out.println(scan);
                if (palindromeX) {
                    System.out.println(" is palindrome");
                }
                else{
                    System.out.println(" is not a plaindrome.");
                }
               
            }
        }
        
          catch (FileNotFoundException excpt){
              System.out.println("Please enter an existing file");
            }
        }
        
        //method for problem 2 
        public static boolean palindrome(String s){
            Deque<String> line = new ArrayDeque<>();
            
            line.push(s);
            
            while(!line.isEmpty()){
                //taken  from recursive lab
                String w = line.pop();
                if (w.length() == 0 || w.length() == 1){
                    return true;
                }
            
                else {
                    
                    if (Character.toLowerCase(w.charAt(0)) == 
                    Character.toLowerCase(w.charAt(w.length()-1))){
                        line.push(w.substring(1, (w.length()-1)));
                    }
                    else{
                        return false;
                    }
            
                }
               }
               return true;
            }
            
           //method from problem 3 
         public static boolean wordPalindrome(String s){
             Deque<String> queue = new ArrayDeque<>();
             Deque<String> stack = new ArrayDeque<>();
             for(String w : s.split(" ")){
                 queue.push(w);
                 stack.addLast(w);
                }
             
            while(!queue.isEmpty() && !stack.isEmpty()){
                String a = queue.removeFirst();
                String b = stack.pop();
                if(!a.equalsIgnoreCase(b)){
                    return false;
              }  
            
           }
    
            return true;
        }
    }
    

