import java.util.Scanner;
public class HW1Part2 {
    public static void main(String[] args){
        System.out.println("Please enter two numbers to add, followed by Enter");
        Scanner userInput = new Scanner(System.in);
        String numberOne = userInput.next();
        String numberTwo = userInput.next();
        System.out.println(addNumbers(numberOne,numberTwo));
        if (verify(numberOne) && verify(numberTwo)) {
            //System.out.println("Add Strings Now");
            //String addedStrings = addNumbers(numberOne, numberTwo);
            //System.out.println(addedStrings);
        }
        else {
            System.out.println("Error at least one of the strings has a letter");
        }
            
        }
    /**
     * This method adds two string numbers together
     * @return string1 added to string2
     */
    public static String addNumbers (String string1, String string2) {
       String result = "";
       String carryString = "";
       if (string1.length() > string2.length()) {
           for (int i = string1.length() - string2.length(); i > 0; i--) {
              string2 = "0" + string2;
            }
        }
       else if(string2.length() > string1.length()) {
           for (int i = string2.length() - string1.length(); i > 0; i--) {
              string1 = "0" + string1;
            }
       }
       for (int i = string2.length()-1; i >= 0; i--) {
           carryString ="0" + carryString;
        }
       for (int i = string1.length()-1; i >= 0; i--){
           int value1 = string1.charAt(i) - '0';
           int value2 = string2.charAt(i) - '0';
           int value3 = carryString.charAt(i) - '0';
           String carryResult = String.valueOf(value1 + value2 + value3);
           //this if does the calculation for carrying
           if (value1 + value2 + value3 > 9) {
               if (i != 0) {
                   char[] carryStringch = carryString.toCharArray();
                   carryStringch[i-1] = carryResult.charAt(0);
                   carryString = String.valueOf(carryStringch);
                   result = carryResult.charAt(1) + result;
                   //System.out.println(carryString);
            }
               else {
                   result = carryResult.charAt(1) + result;
                   result = carryResult.charAt(0) + result; 
                }
           }
           //this else does the regular addition without carrying
           else {
               String add = String.valueOf(value1 + value2 + value3);
               result = add + result;
            }
        }
       return result;
    }
    //this method checks for if it is a letter and if it not a number then it returns false
    public static boolean verify(String str) {
        for (int i=0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                return false;
            }
        } 
        return true;
    }
}