// Shaina Mae Mainar
// Purpose: HW1Part2. Input: numerical string. Output: sum
// I certify that this is my own work pledged 9/29/17

import java.util.Scanner;

public class HW1Part2{
    public static void main(String args[]){
        Scanner scnr = new Scanner(System.in);
        String value1 = "";
        String value2 = "";
        
        System.out.println("Enter first value: ");
        value1 = scnr.nextLine();
        System.out.println("Enter second value: ");
        value2 = scnr.nextLine();
        
        while(!isGoodInput(value1) || !isGoodInput(value2)){
            System.out.println("Error");
            System.out.println("Enter first value: ");
            value1 = scnr.next();
            System.out.println("Enter second value: ");
            value2 = scnr.next();
            if(isGoodInput(value1) && isGoodInput(value2)){
                break;
            }
            
        }
       // System.out.println(value2);
        System.out.println("The answer is: " + add(value1, value2));
        
        
        
    }
    
    public static boolean isGoodInput(String value){
        char[] chars = value.toCharArray();
        
        for(char c: chars){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
        
    }
    
    public static String add(String value1, String value2) {
        String finalVal = "";
        char[] vals1Char = value1.toCharArray();
        char[] vals2Char = value2.toCharArray();
        char[] result = new char[vals1Char.length + 1];
        int carry = 0;
        if(vals2Char.length > vals1Char.length){
            vals1Char = sameLength(vals2Char, vals1Char);
            
        }
        else{
            vals2Char = sameLength(vals1Char, vals2Char);
        }
        
        for(int i = vals1Char.length - 1; i >= 0; --i){
            int sum = Character.getNumericValue(vals1Char[i]) 
            + Character.getNumericValue(vals2Char[i])
            + carry;
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }
            else{
                carry = 0;
            }
            //System.out.println("" + Character.getNumericValue(vals1Char[i]) +
            //Character.getNumericValue(vals2Char[i]) + carry + sum);
            
            finalVal = sum + finalVal;
            
            
        }
        if(carry == 1){
            finalVal = carry + "" + finalVal;
        }
        else{
            finalVal = finalVal;
        }
        
        
        
        
        //System.out.println("FIXME: Finish add()");
        return finalVal;
        
    }

    
    public static char[] sameLength(char[] vals1, char[] vals2){
        //Purpose: to make both values the same length so indexing is easier
        int diff = vals1.length - vals2.length;
        char[] num = new char[vals1.length];
        for(int i = 0; i < diff; ++i){
            num[i] = '0';
        }
        for(int i = 0; i < vals2.length; ++i){
            num[diff+i] = vals2[i];
        }
        // for(int i = 0; i < num.length; ++i){
            // System.out.println(num[i]);
        // }
             
        return num;
    }
    
    
}
