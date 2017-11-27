import java.util.*;
import java.io.*;
/**
 * Corey Taylor
 * 10/30/2017
 */
public class HW4
{
    
    
    public static void main(String[]args) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        String fileName = "";
        Scanner menu = new Scanner(System.in);
        FileReader fileStream = null;
        char quitCmd = 'a';
        
        System.out.print("Enter a file name: ");
        fileName = scanner.next();
        
        try{
            fileStream = new FileReader(fileName);
            
            try{
                
                
            }catch(Exception excpt){
                System.out.println(excpt.getMessage()); 
            }
           
            }catch (FileNotFoundException excpt){
            return;
        }
        
        

        
        System.out.println("Would you like to quit or cancel an appointment?");
        System.out.println("Enter a 'q' for quit or 'c' for cancel");
        quitCmd = menu.next();
        quitCmd.toLowerCase();
        while(quitCmd = 'c'){
           
        }
        if(quitCmd = 'q'){
            System.out.print("Terminating program");
            break;
        }
    }
}
