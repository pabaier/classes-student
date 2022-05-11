import java.util.Scanner;
public class HW1Part1 {
    public static void main(String[] args){
        System.out.println("Please enter a word to count it's Syllable: ");
        Scanner userInput = new Scanner(System.in);
        String word = userInput.next();
        word= word.toLowerCase();
        int NUM_VALS = 0;
        for (int i=0; i < word.length(); i++){
            char letter = word.charAt(i);
            if ((int) word.charAt(i) > 96 && word.charAt(i) <123){
            
            if (i!=0 && (word.charAt(i-1) != 'a' && 
                word.charAt(i-1) != 'e' && 
                word.charAt(i-1) != 'i' &&
                word.charAt(i-1) != 'o' &&
                word.charAt(i-1) != 'u' &&
                word.charAt(i-1) != 'y')) {
                switch (letter) {
                    case 'a':
                        NUM_VALS++;
                        break;
                    case 'e':
                        if (i !=word.length()-1) {
                            NUM_VALS++; 
                        }
                        break;
                    case 'i':
                        NUM_VALS++;
                        break;
                    case 'o':
                        NUM_VALS++;
                        break;
                    case 'u':
                        NUM_VALS++;
                        break;
                    case 'y':
                        NUM_VALS++;                 
                        break;
                    
                } 
                
                
        } else if (i==0) {
            switch (letter) {
                    case 'a':
                        NUM_VALS++;
                        break;
                    case 'e':
                        if (i !=word.length()-1) {
                            NUM_VALS++;
                        }
                        break;
                    case 'i':
                        NUM_VALS++;
                        break;
                    case 'o':
                        NUM_VALS++;
                        break;
                    case 'u':
                        NUM_VALS++;
                        break;
                    case 'y':
                        NUM_VALS++;
                        break;
                    
                }
            
            
        }
        } else {
            System.out.println("Error");
            return;
        }
        }
        if (NUM_VALS==0)
            NUM_VALS++;
        System.out.println(NUM_VALS);
    }
}
    