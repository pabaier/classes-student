
/*Sydney Jackson
 * CSCI 221 - 10:30AM Section - McCauley
 * HWPart2 - Adding two strings that consist of integers by using long addition and carrying.
 */
import java.lang.Math;
import java.util.Scanner;
public class HW1Part2{
    public static void main(String [] args){
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        String num1 = scnr.nextLine();
        
        System.out.println("Enter another number: ");
        String num2 = scnr.nextLine();
        
        int i = 0;
        //determine the length of both of the strings entered to determine which needs be altered
        int num1Len = num1.length();
        int num2Len = num2.length();
        
        String sum = "";
        int numOf1;
        int numOf2;
        //initialize an integer to be used to determine if carrying needs to be done when adding
        int carry = 0;
        char ch;
        //initialize an integer to be set as the sum of each char string
        int add = 0;
        //determine the max of the strings lengths to use for the loop that runs through
        //each of the strings
        int maxLen = Math.max(num1Len,num2Len);
        int lenDiff = 0;
        //if the length of one string is greater than the other,
        //add '0's to the beginning of the smaller string
        if (num1Len > num2Len){
            lenDiff = num1Len - num2Len;
            for (int j = 0; j <= lenDiff; ++j){
                num2 = '0' + num2;
                num1 = num1;
            }
        }
        else if (num2Len > num1Len){
            lenDiff = num2Len - num1Len;
            for (int k = 0; k <= lenDiff; ++k){
                num1 = '0' + num1;
                num2 = num2;
            }
        }
        
           // loop through each value in the strings, determine if the character is a digit, if not
           //stop the program and output error message to user
            for (i = maxLen - 1; i >= 0; --i){
            
                int difference = 0;
          
                if (!Character.isDigit(num1.charAt(i)) || !Character.isDigit(num2.charAt(i))){
                    System.out.println("Error: Input must be integers.");
                    break;
            }
                else{
                    
                    numOf1 = num1.charAt(i) - '0';
                    numOf2 = num2.charAt(i) - '0';
                    
                    add = numOf1 + numOf2;
                }
                        //if i == the last character of the string the carry is
                        //going to be 0 because nothing has been added yet before that
                        while (i == num1Len){
                            carry = 0;
                            
                    }
                        //if the numbers added is greater than 10 and the carry is 1, subtract 9 
                        //from the values added
                        if (add >= 10 && carry == 1){
                            carry = 1;
                        difference = add - 9;
                    }
                        //if the numbers added is less than 10 and the carry is 1, add 1 to the 
                        //values added
                        else if(add <10 && carry == 1){
                            carry = 0;
                        difference = add + 1;
                    }
                        //if the numbers added is greater than 10 and the carry is 0, subtract 10
                        //from the values added
                
                        else if(add >=10 && carry == 0){
                            carry = 1;
                            difference = add - 10;
                        }
                        //if we are iterating through the first character of the strings and
                        //the numbers added are greater than 10
                        else if(i == 0 && add >= 10 && carry ==0){

                            difference = add;
                        }
                        else{
                            carry = 0;
                            difference = add;
                    }
                    
                     
                      ch = (char)(difference + '0');
                            sum = ch + sum;
 
            }

            System.out.println("" + sum + "");
        }
   
 
    }