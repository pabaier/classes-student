import java.util.*;
import java.io.*;
import java.lang.*;
public class HW7 {
    public static boolean palindrome(String str) {
        String s[] = str.split(" ");
        String newStr = "";
        for(int i = 0; i < s.length; ++i){
            newStr = newStr + s[i];
        }

        //System.out.println(newStr);
        int i = 0;
        int len = newStr.length();
        if(len < 2){
           return true;
        }
        else {
            if (Character.toUpperCase(newStr.charAt(0)) != Character.toUpperCase(newStr.charAt(newStr.length() - 1))) {
               return false;
            }
            else{
                //len--;
                i++;
                return palindrome(newStr.substring(i, len-- - 1));
            }
        }
    }


    public static void main(String[] args){
        //Problem 1
        String fileName = "";
        Deque<String> stack = new ArrayDeque<>();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter file name: ");
        fileName = scnr.next();
        File file = new File(fileName);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(input.hasNextLine()){
            Scanner sc = new Scanner(input.nextLine());
            while(sc.hasNext()){
                String word = sc.next();
                stack.push(word);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");

        }
        System.out.println();

        //Problem 2
        Deque<String> stack2 = new ArrayDeque<>();
        String in2 = "";
        Scanner scnr2 = new Scanner(System.in);
        System.out.println("Enter file name: ");
        in2 = scnr2.next();
        File file2 = new File(in2);
        Scanner input2 = null;
        try {
            input2 = new Scanner(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(input2.hasNextLine()){
            stack2.push(input2.nextLine());
        }
        while(!stack2.isEmpty()){
            String sen = stack2.pop();
            System.out.println(sen + ": " + palindrome(sen));


        }

        //Problem 3
        Deque<String> q = new ArrayDeque<>();
        String in3 = "";
        Scanner scnr3 = new Scanner(System.in);
        System.out.println("Enter file name: ");
        in3 = scnr3.next();
        File file3 = new File(in3);
        Scanner input3 = null;
       // String reverse = "";
       // String original = "";
        try {
            input3 = new Scanner(file3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(input3.hasNextLine()) {
            String reverse = "";
            String original = input3.nextLine();
            Scanner sc2 = new Scanner(original);
            while (sc2.hasNext()) {
                q.addLast(sc2.next());
                reverse = q.removeFirst() + " " + reverse;
            }
            System.out.println(original);
            System.out.println(reverse);

            if (Objects.equals(original.trim(), reverse.trim())) {
                System.out.println(original + " is a palindrome.");
            } else {
                System.out.println(original + " is not a palindrome.");
            }
        }

        //System.out.println(q);

    }
}
