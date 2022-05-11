//Gabe Jurecki

import java.util.ArrayDeque;
import java.util.Deque;

public class WordSwapMethods {
    static void reverseSentence(String e) {
        Deque<String> stack1 = new ArrayDeque<>();

        String ee[] = e.split(" ");
        System.out.println(ee.length);
        for (int i = 0; ee.length - 1 >= i; i++) {
            stack1.push(ee[i]);
        }
        System.out.println(stack1);
    }

    static void isAPalindrome(String e){
        Deque<String> stack2 = new ArrayDeque<>();
        stack2.push(e);
        int i = 0;
        int j = e.length();
        while(!stack2.isEmpty()){
            String p = stack2.pop();

            if(p.length() < 2) {
                System.out.println(e + " is a palindrome.");
            }else{
                //if(e.substring(0, i) == e.substring(j)){
                if(p.substring(0 ,1).equals(p.substring(p.length() -1 ))){
                    stack2.push(p.substring(1,p.length()-1));
                }else{
                    System.out.println(e + " is not a palindrome.");
                }
            }

        }
    }
}
