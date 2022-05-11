


/**
 * Code for HW1Part2
 *
 * Submission for Mark Hodges
 * 
 */
import java.util.Scanner;

public class HW1Part2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String userInput1;
        String userInput2;
        int carryAdd = 0;
        int i;
        int sum;
        boolean validString = true;
        boolean carryCheck = false;
        char charAdd;
        String answerString = "";
        System.out.println("Enter a numeric string: ");
        userInput1 = input.next();
        int l1 = userInput1.length();
        System.out.println("Enter a numeric string: ");
        userInput2 = input.next();
        int l2 = userInput2.length();
        String frontString = "";
        if (l1 > l2){
            frontString = userInput1.substring(0, (l1 - l2));
        }
        else if (l2 > l1){
            frontString = userInput2.substring(0, (l2 - l1));
        }
        for (i = 0; i < l1; i++){
            Character testChar = userInput1.charAt(i);
            if (Character.isDigit(testChar) == true){
                break;
            }
            else{
                System.out.println("Invalid String");
                validString = false;
            }
        }
        for (i = 0; i < l2; i++){
            Character testChar = userInput2.charAt(i);
            if (Character.isDigit(testChar) == true){
                break;
            }
            else{
                System.out.println("Invalid String");
                validString = false;
            }
        }
        if (validString == true){
            boolean sameLength = l1 == l2;
            int val1;
            int val2;
            if (sameLength == true){
                for (i = 1; i <= l1; i++){
                    val1 = (userInput1.charAt(l1 - i)) - '0';
                    val2 = (userInput2.charAt(l2 - i)) - '0';
                    sum = val1 + val2 + carryAdd;
                    if (sum >= 10){
                        carryAdd = 1;
                        carryCheck = true;
                        sum = sum - 10;
                        charAdd = (char)(sum + '0');
                    }
                    else{
                        carryAdd = 0;
                        carryCheck = false;
                        charAdd = (char)(sum + '0');
                    }
                    answerString = charAdd + answerString;
                }
            }
            else if (l1 > l2){
                for (i = 1; i <= l2; i++){
                    val1 = (userInput1.charAt(l1 - i)) - '0';
                    val2 = (userInput2.charAt(l2 - i)) - '0';
                    sum = val1 + val2 + carryAdd;
                    if (sum >= 10){
                        carryAdd = 1;
                        carryCheck = true;
                        sum = sum - 10;
                        charAdd = (char)(sum +'0');
                    }
                    else{
                        carryAdd = 0;
                        carryCheck = false;
                        charAdd = (char)(sum + '0');
                    }
                    answerString = charAdd + answerString;
                    frontString = userInput1.substring(0, (l1 - l2));
                }
            }
            else if (l2 > l1){
                for (i = 1; i <= l1; i++){
                    val1 = (userInput1.charAt(l1 - i)) - '0';
                    val2 = (userInput2.charAt(l2 - i)) - '0';
                    sum = val1 + val2 + carryAdd;
                    if (sum >= 10){
                        carryAdd = 1;
                        carryCheck = true;
                        sum = sum - 10;
                        charAdd = (char)(sum +'0');
                    }
                    else{
                        carryAdd = 0;
                        carryCheck = false;
                        charAdd = (char)(sum + '0');
                    }
                    answerString = charAdd + answerString;
                    frontString = userInput2.substring(0, (l2 - l1));
                }
            }
            if (carryCheck == true){
                if (sameLength == false){
                    int frontLength = frontString.length();
                    int counter = 1;
                    while (carryCheck){
                        val1 = (frontString.charAt(frontLength - counter) - '0');
                        sum = 1 + val1;
                        if (sum == 10){
                            carryCheck = true;
                            charAdd = '0';
                        }
                        else {
                            carryCheck = false;
                            charAdd = (char)(sum + '0');
                        }
                        if (counter <= frontLength){
                            charAdd = (char)(sum + '0');
                            answerString = charAdd + answerString;
                        }
                        else{
                            break;
                        }
                        counter++;
                    }
                    frontString = frontString.substring(0, (frontLength - counter));
                    answerString = frontString.concat(answerString);
                }
                else{
                    answerString = "1" + answerString;
                }
            }
            else{
                if (sameLength == false){
                    answerString = frontString.concat(answerString);
                }
                else{
                }
            }
            System.out.println(answerString);
            return;
        }
    }
}
