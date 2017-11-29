import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class HW4 {

	public static void main(String[] args) throws Exception{
		String Filename;
		try{
			System.out.print("Enter the name of your file: ");
			Scanner myScan = new Scanner(new File(Filename));
			
		}
		catch(FileNotFoundException){
			String string = "NOT AN EXCEPTION MESSAGE FROM THE Java Virtual Machine";
			System.out.println(string);
			break;
		}
		char quit = 'q';
		
		

		
	}

}
