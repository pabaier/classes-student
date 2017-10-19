import java.util.Scanner;

public class HW1Part1 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String vowels = "aeiouy";
        int sylCount = 0;

        System.out.println("Enter a string");
        String userWord = scnr.nextLine();
        userWord = userWord.toLowerCase();
        userWord = userWord.trim();

        for(int i = 0; i < userWord.length(); i++){
            if((vowels.indexOf(userWord.charAt(i)) != -1) && (i == 0 || vowels.indexOf(userWord.charAt(i - 1)) == -1) && !(userWord.charAt(i) == 'e' && i == userWord.length() - 1)) {
                sylCount++;
            }
        }
        if(sylCount == 0)
            sylCount ++;
        System.out.println(sylCount);
    }
}
