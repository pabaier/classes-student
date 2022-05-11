
/**
 * Write a description of class HW1Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;  

public class HW1Part1
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class HW1Part1
     */


    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter word");
       String word = sc.next();
       String regex = "[a-zA-Z]*";
       char c = ' ';
       int syllables = 0;
         if(word.matches(regex)){
            for (int i = 0; i < word.length()-1; i++){
                c = word.charAt(i); 
                char d = word.charAt(i+1);
                 if (isAVowel (c) && !isAVowel(d) ) {      
                  syllables = syllables + 1; 

                    }
            }

            if(word.charAt(word.length()-1) == 'e' || word.charAt(word.length()-1) == 'e' && isAVowel(word.charAt(word.length()-2))  ){
            syllables = syllables + 1; 

            }  if(word.charAt(word.length()-1) == 'e' || word.charAt(word.length()-1) == 'e' && !isAVowel(word.charAt(word.length()-2))  ){
            syllables = syllables - 1; 
            } 
            if (syllables < 1){                              
            System.out.println ("syllables: 1"); } 
            else {
            System.out.println ("syllables: " + syllables);} 

        }else{
                    System.out.println ("Enter valid word");} 
        


    }
    public static boolean isAVowel( char ch ) {
        // the code to return a true value if ch is a vowel or false if ch is not a vowel appears here }

        if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o'|| ch == 'O'|| ch == 'u'|| ch == 'U'|| ch == 'y'|| ch == 'Y' ) {
        return true;
        
        }
            return false;}
           
            

            
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
}
