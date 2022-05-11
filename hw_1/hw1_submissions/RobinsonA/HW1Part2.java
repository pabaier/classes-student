
/**
Ariel Robinson
HW1 Part2
User enters two numbers that are strings the strings are then added and 
a string is returned of the sum of the two numbers
 */
import java.util.Scanner;
import java.util.Arrays;
public class HW1Part2
{
    public static void main(String[] args){
        Scanner scnr=new Scanner(System.in);
        System.out.println("Please enter a number");
        String str1=scnr.nextLine();
        System.out.println("Please enter another number");
        String str2=scnr.nextLine();
        int i=0;
        int j=0;

        boolean validNumber=true;

        //checks to see if both strings are numbers
        for(i=0; i<str1.length(); i++){

            if(Character.isLetter(str1.charAt(i))){
                validNumber=false;
            }
        }
        for(j=0; j<str2.length(); j++){
            if(Character.isLetter(str2.charAt(j))){
                validNumber=false;
            }
        }
        //if string contains anything but numbers an error message prints
        if(!validNumber){
            System.out.println("Error");
        }

        else{
            int firstNum=0;
            int secondNum=0;
            int total=0;
            int carry=0;
            char ch;
            int sum=0;
            //if the strings are not the same length a 0 is added to make them equal lengths
            while(str1.length()!= str2.length()){
                if(str1.length()<str2.length()){
                    str1="0"+str1;
                }
                else if(str2.length()<str1.length()){
                    str2="0"+str2;
                }
            }

            //System.out.println("string 1: " + str1);
            //System.out.println("string 2: "+ str2);
            int firstInt[]=new int[str1.length()];
            int secondInt[]=new int[str2.length()];
            String strTotal="";
            String numberOne="";
            int newSum[]=new int[str2.length()+1];

            //create arrays of each string
            for(i=0; i<str1.length(); i++){

                firstNum=str1.charAt(i)-'0';
                firstInt[i]=firstNum;

                //System.out.println("first Num: " +firstNum);

            }

            for(j=0; j<str2.length(); j++){
                secondNum=str2.charAt(j)-'0';
                secondInt[j]=secondNum;
                //System.out.println("second Num: "+ secondNum);

            }
            //sums up each of the numbers
            for(int x=firstInt.length-1; x>=0; x--){
                int num1=secondInt[x];
                int num2=firstInt[x];

                sum=num1+num2+carry;

                //if the sum is greater than 9 than carry is set to 0
                if(sum>9){
                    newSum[x+1]=sum-10;
                    carry=1;
                }
                else{
                    carry=0;
                    newSum[x+1]=sum;
                }

            }
            newSum[0]=carry;
            //System.out.println(Arrays.toString(newSum));

            //turns array of numbers into a string
            String totalString="";
            for(i=0; i<newSum.length;i++){
                totalString+=newSum[i];

            }
            if(totalString.indexOf("0")==0){
                System.out.println("The sum is: "+totalString.substring(1));
            }
            else{
                System.out.println("The sum is: "+ totalString);
            }

        }
    }
}

