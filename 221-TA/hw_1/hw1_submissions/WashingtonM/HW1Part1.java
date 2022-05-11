// package edu.cofc.csci221.washingtonmary;

/**
 * Estimate how many syllables are in a word
 *
 * Mary Washington
 * Eclipse Oxygen 4.7.0
 */ 
import java.util.Scanner;

public class HW1Part1
{

    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);
        String word = " ";

        Character ch = ' ';
        int syllableCnt = 0;
        System.out.println("Please enter a word.");
        word = scnr.next().trim().toUpperCase(); //Forcing all the input to be uppercase

        boolean isPreviousChVowel = false;
        boolean isCurrChVowel = false;
        //Checking to see if the input contains only letters and how many vowels
        for(int i = 0; i < word.length(); i++){
            ch = word.charAt(i);
            /*Checking the letters
            System.out.println(ch);
             */
            if(Character.isLetter(ch)){
                isCurrChVowel = isVowel(ch);
                if(isCurrChVowel && !isPreviousChVowel && !(ch == 'E' && i == (word.length() - 1))){
                    syllableCnt++;
                }
                //previous becomes current as you move through the loop
                isPreviousChVowel = isCurrChVowel;
            }
            else{
                System.out.println("Please use only letters.");
            }

        }
        if(syllableCnt == 0){
            syllableCnt++;
        }
        System.out.println(syllableCnt);
        scnr.close(); //closing the ability to use input
    }         
    
    //checking a case by case basis of vowels including y
    public static boolean isVowel(char ch){
        switch(ch){
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'Y':
            return true;

            default:
            return false;

        }
    }

}
