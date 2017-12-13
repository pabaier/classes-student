//Gabe Jurecki

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW7 {
    public static void main(String[] args) throws FileNotFoundException{
        //String str1 = "Hello how are you";
        System.out.println("Enter the name of your file: ");
        Scanner userInput = new Scanner(System.in);
        String fileName = userInput.nextLine();
        File text = new File(fileName);
        Scanner scnr = new Scanner(text);
        int i = 0;
        while(scnr.hasNextLine()){
          //  System.out.println(i);
            String line = scnr.nextLine();
            WordSwapMethods.reverseSentence(line);
            i++;

        }
        Scanner scnr2 = new Scanner(text);
        while(scnr2.hasNextLine()){
            String line = scnr2.nextLine();
            WordSwapMethods.isAPalindrome(line);
        }

    }
}
