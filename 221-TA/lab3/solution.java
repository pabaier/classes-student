import java.util.Scanner;

public class PlayerRoster {
   public static void main(String[] args) {
      
      final int NUM_PLAYERS = 5;   
      int[] jerseyNumber = {84, 23, 4,  30, 66};
      int[] rating = {7, 4, 5, 2, 9};
      char userInput = ' ';
      
      System.out.println("ROSTER");
      for (int i = 0; i < NUM_PLAYERS; i++)
      System.out.println("Player " + (i + 1) + 
							"-- Jersey number: " + jerseyNumber[i] + 
							", Rating: "+ rating[i]);
      System.out.println();
      
      Scanner input = new Scanner(System.in);
 
      do{
          System.out.println("MENU");
          System.out.println("u - Update player rating");
          System.out.println("a - Output players above a rating");
          System.out.println("r - Replace player");
          System.out.println("o - Output roster");
          System.out.println("q - Quit");
          System.out.println();
          System.out.println("Choose an option: ");
          userInput = input.next().charAt(0);
          
          if (userInput == 'o'){
             System.out.println("ROSTER");
             for (int i = 0; i < NUM_PLAYERS; i++)
                System.out.println("Player " + (i + 1) + 
									" -- Jersey number: " + jerseyNumber[i] + 
									", Rating: "+ rating[i]);
             System.out.println();
          }
          else if (userInput == 'u'){
              System.out.print("Enter jersey number: ");
              int jersey = input.nextInt();
              int i = 0;
              while (i < NUM_PLAYERS && jerseyNumber[i] != jersey)
                 i++;
              if (i < NUM_PLAYERS){
                  System.out.println("Enter new rating: ");
                  int newRating = input.nextInt();
                  rating[i] = newRating;
               }
          } // update handled if good jersey number provided
          else if (userInput == 'a'){
              System.out.print("Enter a rating: ");
              int newRating = input.nextInt();
              System.out.println("ABOVE " + newRating);
              for (int i = 0; i < NUM_PLAYERS; i++)
                 if (rating[i] > newRating)
                    System.out.println("Player " + (i + 1) + 
										" -- Jersey number: " + 
										jerseyNumber[i] + ", Rating: "+ rating[i]);
             System.out.println();            
          }
          else if (userInput == 'r'){
             System.out.print("Enter jersey number: ");
             int jersey = input.nextInt();
             int i = 0;
             while (i < NUM_PLAYERS && jerseyNumber[i] != jersey)
                i++;
             if (i < NUM_PLAYERS){
                System.out.println("Enter new jersey number: ");
                jersey = input.nextInt();
                System.out.println("Enter new rating: ");
                int newRating = input.nextInt();
                jerseyNumber[i] = jersey;
                rating[i] = newRating;
               }              
              
          }
              
        }while (userInput != 'q');
          
      return;
   }
}