import java.util.Scanner;
//Carson Barber
//Computer Science 221
//HW1Part2
public class HW1Part2
{
    static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args)
    {
        String val1 = "";
        String val2 = "";
        System.out.println("Please enter the first number.");
        val1 = getString();
        System.out.println("Please enter the second number.");
        val2 = getString();
        String answer = stringAddition(val1,val2);
        System.out.println("Sum = " + answer);
        
    }
    public static String getString(){
        String s = "";
        boolean valid = false;
        s = scnr.next();
        valid = true;
        //check if each character in the string is a digit
        for(int i = 0; i<s.length(); i++){
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))valid = false;
        }
        if(!valid){
            System.out.println("Error: " + s + " is not a valid number.");
            return null;    //if I should ask for input until an appropriate string is input, replace "return null;" with "return getString();"
        }
        return s;
    }
    public static String stringAddition(String s1, String s2){
        String retVal = "";
        String carryVals = "0"; //start at 0 to create a 1 character offset
        boolean needToCarry = false;
        for(int i = 1; i<=s1.length() && i<=s2.length();i++){
            int sum = s1.charAt(s1.length()-i)- '0' +(s2.charAt(s2.length()-i) -'0');
            retVal = sum%10 + retVal;
            carryVals = sum/10 + carryVals;
            if(sum/10 != 0)needToCarry = true;
        }
        //add any remaining characters to retVal if s1 and s2 are different lengths
        if(s1.length()>s2.length()){
            for(int i = 1; i+s2.length()<=s1.length();i++){
                retVal = s1.charAt(s1.length()-s2.length()-i) + retVal;
            }
        }
        else{
            for(int i = 1; i+s1.length()<=s2.length();i++){
                retVal = s2.charAt(s2.length()-s1.length()-i) + retVal;
            }
        }
        //recursive call to add any carried numbers
        if(needToCarry){
            retVal = stringAddition(retVal, carryVals);
        }
        //trim the 0 found at the beggining of the added statements, length check is for 0+0 case
        while(retVal.charAt(0) == '0' && retVal.length()>1){
            retVal = retVal.substring(1);
        }
        return retVal;
    }
    
}
