
/**
 * Ariel Robinson
 * HW1Part1 
 * The user enters a word and the program figures out an estimate of how many 
 * syllables are in the word. 
 * 
 */
import java.util.Scanner;

public class HW1Part1
{
    public static boolean isAVowel(char ch){

        if((ch=='a') || (ch=='e') || (ch=='i') || (ch=='o') || (ch=='u') ||( ch=='y')){
            return true;

        }
        else{
            return false;
        }

    }

    public static void main(String[] args){

        Scanner userInput=new Scanner(System.in);
        System.out.println("Please enter a word");
        String word= userInput.nextLine();
        boolean validWord=false;
        int i =0;
        int numVowels=0;
        int findE=word.indexOf('e');

        //finds space and ignores anything after the space 
        int space= word.indexOf(" ");
        if(word.indexOf(" ") != -1){
            word=word.substring(0,space);
        }
        //makes all letters in word lowercase
        word=word.toLowerCase();
        for (i=0; i<word.length(); i++){
            if(Character.isLetter(word.charAt(i))){
                validWord=true;
            }
            else{
                validWord=false;
            }
        }

        //if the word contains anything other than a letter than it is not valid
        if(!validWord){
            System.out.println("Not a valid word");
        }
        else{
            for(i=0;i<word.length(); i++){
                //finds and counts vowels in the word if not preceded by another vowelif(isAVowel(word.charAt(i))){

                //if another vowel is before a vowel then it subtracts from numVowels
                if(isAVowel(word.charAt(i))){
                    numVowels+=1;

                    if(i>0 && isAVowel(word.charAt(i-1))) {
                        numVowels-=1;

                        //if e is at the end of the word that doesn't count 

                    }
                }

            }
            if(word.indexOf('e')==word.length()-1){
                numVowels-=1;
            }
            if(numVowels==0){
                numVowels+=1;
            }
            System.out.println("Number of syllables: " +numVowels );  

        }
    }
}

