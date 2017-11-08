import java.util.Scanner;
public class HW1Part2 {
	
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		Scanner myScan2 = new Scanner(System.in);
		
		System.out.println("Enter two numbers: ");
		String num1 = myScan.next();
		String num2 = myScan.next();
		String res = " ";
		
		int a = 0;
		int b = 0;
		int result = 0;
		a = Integer.parseInt(num1);
		b = Integer.parseInt(num2);
		result = a + b;
		res = Integer.toString(result);
		
		System.out.println(num1 + " + " + num2 + " = " + res);
		
		myScan.close();
		myScan2.close();
		

	}

}
