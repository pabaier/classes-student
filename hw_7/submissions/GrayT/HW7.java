/*Tyler Gray
 *Main Driver for HW7 
 *Shows off ques
 *	 
 * 
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class HW7 {

	private static final String FILENAME = "D:\\Users\\burpi\\Documents\\Java\\HW7\\src\\dat.dat";
	private static Deque<String> wordsStack = new ArrayDeque<String>();
	private static Deque<String> wordsQue = new ArrayDeque<String>();
	
	public static void printReverse() {
		try {
		File fl = new File(FILENAME);
		Scanner sc1 = new Scanner(fl);
		while(sc1.hasNext()) {
			wordsStack.push(sc1.next());			
		}
		while(!wordsStack.isEmpty()) {
			System.out.print(wordsStack.pop() + " ");
		}
		System.out.println();
		sc1.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			wordsStack.clear();
		}				
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		//Problem 1
		printReverse();
		
		//Problem 2
		try {
		boolean pali = false;
		File fl = new File(FILENAME);
		Scanner sc2 = new Scanner(fl);
		String s;
		String in;
		wordsStack.push(in = sc2.nextLine());
		while((s = wordsStack.pop()).length() >= 1) {
			if(s.length() < 2) {
				//return true
				pali = true;
				break;
			}
			if(s.charAt(0) == s.charAt(s.length()-1)) {
				//System.out.println(s.substring(1, s.length()-1));
				wordsStack.push(s.substring(1, s.length()-1));
			}
			else {
				//Return False
				pali = false;
				//System.out.println("FALSE");
				break;
			}
		}
		if(pali) {
			System.out.println("\"" + in + "\"" + " is a palindrome.");
		}else {
			System.out.println("\"" + in + "\"" + " is not a palindrome.");
		}
		
		sc2.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		finally {
			wordsStack.clear();
		}
		
		//Problem 3
		try {
			boolean pali = true;
			File fl = new File(FILENAME);
			Scanner sc3 = new Scanner(fl);
			String s;
			String in = "";
			while(sc3.hasNext()) {
				s = sc3.next();
				in = in + " " + s;
				wordsStack.push(s);
				wordsQue.addLast(s);
			}
			while(!wordsStack.isEmpty()) {
				if(!wordsStack.pop().equals(wordsQue.removeFirst())) {
					//return false;
					pali = false;
				}
			}
			in = in.trim();
			if(pali) {
				System.out.println("\"" + in + "\"" + " is a palindrome.");
			}else {
				System.out.println("\"" + in + "\"" + " is not a palindrome.");
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
