import java.util.Scanner;

/*
 * Author: Adam Dzierzko
 */

public class HW1Part2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String userString1;
        String userString2;
        System.out.println("This program will add two numeric Strings");
        System.out.println("Please enter the first numeric string:");
        userString1 = scanner.next();
        while(!isNumeric(userString1)){
            System.out.println("Entered string is not numeric, please enter the string again: ");
            userString1 = scanner.next();
        }
        System.out.println("Please enter the second numeric string:");
        userString2 = scanner.next();
        while(!isNumeric(userString2)){
            System.out.println("Entered string is not numeric, please enter the string again: ");
            userString2 = scanner.next();
        }


       System.out.println(addTwoStrings(userString1, userString2));

    }

    public static String addTwoStrings(String s1, String s2){

        int temp;
        int value1;
        int value2;
        int carry = 0;
        String returnString = "";

        if (s1.length() > s2.length()) {                                    // make strings equal length
            do{
                s2 = '0' + s2;
            }while (s1.length() != s2.length());
        } else if (s1.length() < s2.length()) {
            do{
                s1 = '0' + s1;
            }while (s1.length() != s2.length());
        }

        for(int i = s1.length() -1 ; i >= 0; i--){

            value1 = s1.charAt(i) - '0';
            value2 = s2.charAt(i) - '0';
            temp = value1 + value2;
            if(carry > 0) {
                temp += carry;
                carry--;
            }
            if(i== 0 && temp >= 10){
                returnString += (temp - 10) + "" + 1;
                break;
            }
            if(temp >= 10){
                carry++;
                temp -= 10;
            }
            returnString += "" + temp;
        }
        return reverseString(returnString);
    }

    public static String reverseString(String s){

        String reversedString = "";
        for (int i = s.length() - 1; i >= 0; i--){
            reversedString += s.charAt(i);
        }
        return reversedString;
    }

    public static boolean isNumeric(String s){

        boolean isNumeric = true;
        for (int i = 0; i < s.length(); i++){
            if ("0123456789".indexOf(s.charAt(i)) < 0 ){
                isNumeric = false;
            }
        }
        return isNumeric;
    }

}
