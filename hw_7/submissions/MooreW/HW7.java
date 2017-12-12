import java.io.*;
import java.util.*;

/*Elex Moore
 * 
 * 
 */
public class HW7 {
	public static void main(String[] args) throws Exception{
		Deque<String> fileStr= new LinkedList<>();
		
		//Read the file input
		System.out.println("Enter the name of your file (include the .txt): ");
		Scanner myScan = new Scanner(System.in);
		String filename = myScan.next();
		
		File file = new File(filename);
		Scanner hello = new Scanner(file);
		
		//Reverses the words on each line of the file
		while(hello.hasNext()){
			fileStr.push(hello.next());
			
			
			System.out.print("The reverse of " + fileStr.peek() + hello.nextLine() + " is ");
			System.out.println(fileStr.peek() + " ");
			fileStr.pop();
				
		}
		myScan.close();
		fileStr.clear();
		
		//Checks to see if the lines in the file are a palindrome
		boolean isPalindrome;
		while(hello.hasNextLine()){
			fileStr.push(hello.nextLine());
			while(!fileStr.isEmpty()){
				String word = fileStr.pop();
				if(word.length() == 0 || word.length() == 1){
					System.out.println("true");
				}
				else{
					if(word.substring(0) == word.substring(-1)){
						fileStr.push(word);
					}
					else{System.out.println("false");}
				}
			}
		}
	}

}
