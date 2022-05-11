
/**
 * This program prompts for, and inputs, two strings.
 * Assuming good input, the program adds the two strings, which contain
 * exclusively integer characters (inputs that contain non-integer
 * characters,cause the program to prompt the user for a different string).
 * In order to effectively add the two integers, the program starts from the
 * ones units, and adds the integers from right to left, using nested loops.
 * If the sum of the placeholders is greater than or equal to 10, the program
 *  carries a one to the next digit.
 * 
 * author: John Haley
 * Programming Assignment 1 - Part 2
 */
import java.util.Scanner;

public class HWPart2
{
    public static void main(String[] args)
    {
    Scanner scnr = new Scanner(System.in);
   
    System.out.println("Enter a number: ");
    String string1 = scnr.next();
    System.out.println("Enter a number: ");
    String string2 = scnr.next();
    
    boolean str1IsValid = false;
    boolean str2IsValid = false;
    
    while (string1.length()>string2.length()){
         string2 = "0" + string2;
    }

    while((string2.length()>string1.length())){
             string1 = "0" + string1;       
    }

    

        for (int i=0; i< string1.length();i++){
            if ((string1.charAt(i) > 47 && string1.charAt(i) < 58) && (string2.charAt(i) > 47 && string2.charAt(i) < 58)){
                str1IsValid = true;
                str2IsValid = true;
            }
        }
        if(!str1IsValid || !str2IsValid){
            System.out.println("Not a valid number.");
        }
    
    int num2;
    int num1;
    int sum = 0;
    //System.out.print("str 1: "+string1 + "str 2: "+string2 );
    int[] ans = new int[string1.length()];
    String finalAnswer = "";
    
    for (int i=string1.length()-1; i >= 0 ; i--){
        //System.out.println("i: " + i);
            num1 = string1.charAt(i) - '0';
            num2 = string2.charAt(i) - '0';
            
            sum = num1 + num2;
          
            if(sum>=10 && i==0){
                ans[i] = 1;
                ans[i+1] = sum-10;
            }
            else if(sum>=10){
                ans[i] += sum -10;
                ans[i-1] += 1;
            }else if(sum<10){
                ans[i] += sum;
            }
        }
        
        System.out.print("The sum of those two numbers is: ");
        for (int i=0;i<ans.length;i++){
            if(i==0 && ans[i]==0){
            }
            else{
            finalAnswer = finalAnswer + ans[i];
        }
          
        }
        System.out.println(finalAnswer);               
                
                
            
        }
    }
