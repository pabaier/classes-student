
/**
 * Write a description of class HW1Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
 

public class HW1Part1{
    public static void main(String[] args){
        int x;
        int i;
        int j;
        String userString;
        String userStringUp;
        char[] userArray;
        int numVowels = 0;
        
        System.out.print("Please enter a string:");
        Scanner sc1 = new Scanner(System.in);
        userString = sc1.nextLine();
        
        //Changes string to UPPERCASE
        userStringUp = userString.toUpperCase();
        
        int ARRAY_VALUE = userStringUp.length();
        
        userArray = userStringUp.toCharArray();
        
        for(i = 1; i < ARRAY_VALUE; i++){
            if(userArray[0] == 'A' || userArray[0] == 'E' || userArray[0] == 'I' || userArray[0] == 'O' || userArray[0] == 'U' || userArray[0] == 'Y'){
                numVowels++;
            
            }else if(userArray[i] == 'A' || userArray[i] == 'E' || userArray[i] == 'I' || userArray[i] == 'O' || userArray[i] == 'U'|| userArray[i] == 'Y'){
                numVowels++;
                if(userArray[i - 1] == 'E' || userArray[i - 1] == 'E' || userArray[i - 1] == 'I' || userArray[i - 1] == 'O' || userArray[i - 1] == 'U' || userArray[i - 1] == 'Y'){
                    numVowels--;
                }
            }
           
        }
         if(userArray[(userArray.length - 1)] == 'E'){
                numVowels--;
            }
        if(numVowels > 0){
            System.out.print("The word "+userString+" has " + numVowels + " syllables.");
        } else{
            System.out.print("The word " + userString + " has no syllables.");
        }
        
        
    
    }
}
