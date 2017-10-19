
/**
 * This program will take two large numbers entered as strings and add them.
 *
 * Ashley Woods
 * 9-22-17 (edited 9-29-17)
 */
import java.util.Scanner;
import java.lang.Math;
public class HWPart2
{
    public static void main(String[]args){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        String num1 = scnr.next();
        String origNum1 = num1;
        int i = 0;
        int len1 = num1.length();
        String addedNum = "";
        String extraDigits = "";
        boolean uneven = false;
        boolean notBroken = true;
        for (i=0; i<len1 ;i++) {
            if (Character.isDigit(num1.charAt(i)) == false) {
                System.out.print("There was an error");
                notBroken = false;
                break;
            }
        }
        if (notBroken == true) {
        System.out.print("Please enter the second number: ");
        String num2 = scnr.next();
        String origNum2 = num2;
        int len2 = num2.length();
    
        for (i=0; i<len2; i++) {
            if (Character.isDigit(num2.charAt(i))==false && notBroken == true) {
                System.out.print("There was an error");
                notBroken = false;
                break;
            }
        }
    
        if (notBroken == true){
        //now to add them
        int carryOver = 0;
        int value1;
        int value2;
        int addedVal;
        int savedVal= 0;
        int extraLen = Math.abs(len1-len2);
        if (len1 > len2) {
            for (i=0; i<extraLen; ++i) {
                num2 = "0" + num2;
            }
        }
        else if (len2 > len1) {
            for (i=0; i<extraLen; ++i) {
                num1 = "0" + num1;
            }
        }
        int length = num1.length();
        for (i=(length-1); i>=0; --i){
            value1 = num1.charAt(i)-'0';
            value2 = num2.charAt(i)-'0';
            addedVal = value1+value2;
            if (i==0) {
                addedVal = addedVal+carryOver;
                carryOver = 0;
                savedVal = addedVal;
            }         
            else if (addedVal > 9) {
                addedVal = addedVal - 10 + carryOver;
                carryOver = 1;
                addedNum = addedNum + addedVal;
            }
            else {
                if (carryOver==1){
                    if ((addedVal + carryOver)>9) {
                        addedVal = addedVal - 10 + carryOver;
                        carryOver = 1;
                        addedNum = addedNum + addedVal;
                    }
                    else{
                        addedNum = addedNum + (addedVal + carryOver);
                        carryOver = 0;
                    }
                }
                else {
                    addedNum = addedNum + addedVal;
                }
            }
        }
        if (carryOver>0){
            addedNum = addedNum + carryOver;
            carryOver = 0;
        }
        int finalLen = addedNum.length();
        String finalNum = "";
        for (i=(finalLen-1); i>=0; --i) {
            finalNum = finalNum + addedNum.charAt(i);
        }
        if (savedVal > 0) {
            finalNum = "" + savedVal + "" + finalNum;
        }
        System.out.println();
        System.out.print(origNum1 + " + " + origNum2 + " = "+finalNum);
    }
}
}
}