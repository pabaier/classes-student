import java.util.Scanner;  

public class HW1Part1
{
    public static void Syllables(){
       Scanner myScan = new Scanner(System.in);
       System.out.println("Enter word");
       String userWord = myScan.next();
       String regex = "[a-zA-Z]*";
       char c = ' ';
       int syllables = 0;
         if(userWord.matches(regex)){
            for (int i = 0; i < userWord.length()-1; i++){
                c = userWord.charAt(i); 
                char d = userWord.charAt(i+1);
                 if (isAVowel (c) && !isAVowel(d) ) {      
                  syllables = syllables + 1; 
                 }
            }

            if(userWord.charAt(userWord.length()-1) == 'e' || userWord.charAt(userWord.length()-1) == 'e' && 
            		isAVowel(userWord.charAt(userWord.length()-2))  ){
            syllables = syllables + 1; 
            }
            
            if(userWord.charAt(userWord.length()-1) == 'e' || userWord.charAt(userWord.length()-1) == 'e' && 
            		!isAVowel(userWord.charAt(userWord.length()-2))  ){
            syllables = syllables - 1; 
            } 
            
            if (syllables < 1){                              
            System.out.println ("syllables: 1"); } 
            else {
            System.out.println ("syllables: " + syllables);} 

        }else{
                    System.out.println ("Enter valid word");
        }
        myScan.close();


    }
    public static boolean isAVowel( char ch ) {
        // the code to return a true value if ch is a vowel or false if ch is not a vowel appears here }

        if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o'|| ch == 'O'|| ch == 'u'|| ch == 'U'|| ch == 'y'|| ch == 'Y' ) {
        return true;
        
        }
            return false;
    }

	public static void main(String[] args) {
		Syllables();

	}

}
