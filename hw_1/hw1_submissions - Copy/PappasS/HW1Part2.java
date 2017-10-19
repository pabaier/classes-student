

import java.util.Scanner;

public class HW1Part2 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int carry = 0;

        System.out.println("Enter a num");
        String numOne = scnr.next();
        System.out.println("Enter another num");
        String numTwo = scnr.next();
        String bigNum = "";
        String smallNum = "";
        int counter = 1;

        if(!numOne.matches("[0-9]+") || !numTwo.matches("[0-9]+")){
            System.out.println("Error");
            return;
        }

        if(numOne.length() > numTwo.length()) {
            bigNum = numOne;
            smallNum = numTwo;
        } else {
            bigNum = numTwo;
            smallNum = numOne;
        }

        String newNum = "";

        for(int i = bigNum.length()-1; i >= 0; i--){
            int k;
            if(smallNum.length() - counter >= 0) {
                k = smallNum.charAt((smallNum.length() - counter)) - '0';
            } else{
                k = 0;
            }
            int j = bigNum.charAt(i) - '0';
            int tempNum = 0;
            j = j + carry;
            if(k + j >= 10) {
                carry = 1;
            }
            tempNum = (k + j) % 10;
            newNum = (tempNum + newNum);
            counter ++;

        }
        if(carry == 1)
            newNum = carry + newNum;
        System.out.println(newNum);
    }
}
