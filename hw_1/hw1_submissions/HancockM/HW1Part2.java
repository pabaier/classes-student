
/**
 * Write a description of class HW1Part2 here.
 *
 * Matt Hancock
 * @version (a version number or a date)
 */
public class HW1Part2
{
    public static void main(String[] args){
    //initialize variables
    String numA = "10009";
    String numB = "10005";
    String longer = "";
    String shorter = "";
    
    int stringLength = 0;
    String newNum = "";
    int a = numA.charAt(0) - '0';
    int b = numB.charAt(0)-'0';
    int c = 0;
    int carry = 0;
    int i = 0;
    //determine which string is longer
    if(numA.length() >= numB.length()){
        stringLength = numA.length();
        longer = numA;
        shorter = numB;
    }else{
        stringLength = numB.length();
        longer = numB;
        shorter = numA;
    }
    for(int j = 0; i < (longer.length() - shorter.length());++j){
        shorter = "0" + shorter;
    }
    longer = "0"+longer;
    shorter = "0" + shorter;
    for(i=stringLength; i >= 0 ; --i){
        a = shorter.charAt(i) - '0';
        b = longer.charAt(i) - '0';
        c = a+b+carry;
        System.out.println("test a: " + a + " b: " + b + " c: " +c + " carry: " + carry);
        if(c>10){
         c= c-10;
         carry = 1;
        }else{
            carry = 0;
        }
        newNum = (""+c+"")+ newNum;
    }
    if(newNum.charAt(0) == '0'){
        newNum = newNum.substring(1);
    }
    System.out.print(newNum);
    
    }
}
