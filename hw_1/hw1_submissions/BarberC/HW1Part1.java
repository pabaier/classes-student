import java.util.Scanner;
//Carson Barber
//Computer Science 221
//HW1Part1
public class HW1Part1
{
    public static void main(String[] args)
    {
       Scanner scnr = new Scanner(System.in);
       String userWord = "" ;
       int syllableCount = 0;
       boolean validWord = false;
       //Get a valid word from user
       while(!validWord){
           System.out.println("Please enter a word");
           userWord = scnr.next();
           userWord.trim();
           validWord = true;
           for(int i = 0; i<userWord.length();i++){
               if(!isLetter(userWord.charAt(i))){
                   validWord = false;
               }
           }
           if(!validWord){
                System.out.println("Please enter a word with only letters");
           }
        }
       boolean previousCharWasVowel = false;
       //count syllables in userWord
       for(int i = 0; i<userWord.length();i++){
            if(isVowel(userWord.charAt(i)))syllableCount++;
            if(previousCharWasVowel && isVowel(userWord.charAt(i)))syllableCount--;//check if preceding character is a vowel
            else if(i == userWord.length()-1 && Character.toUpperCase(userWord.charAt(i)) == 'E'){
                syllableCount--; //check if it is the final char in the word,
                                 //not preceded by a vowel, and ends in e
            }
            previousCharWasVowel = isVowel(userWord.charAt(i));
       }
       if(syllableCount == 0)syllableCount++;
       System.out.println("\"" + userWord + "\" has " + syllableCount + " vowel(s).");
    }
    //return true if char c is a letter(a to z)
    public static boolean isLetter(char c)
    {
        c = Character.toUpperCase(c);
        if(c >= 'A' && c<='Z')return true;
        return false;
    }
    //return true if char c is a vowel(a, i, u, e, o, or y)
    public static boolean isVowel(char c)
    {
        c = Character.toUpperCase(c);
        if(c == 'A' || c == 'I' || c == 'U' || c == 'E' || c == 'O' || c == 'Y')
            return true;
        return false;
    }
}