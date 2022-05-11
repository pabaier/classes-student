
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    fixed the getBirthdate method, completed the daysUntilBirthday method,
  *    completed the daysOld method
  * 
  * were added by
  * 
  *   Richard Marshall
  */ 

import java.util.*;

public class BirthDate {
    public static void main(String[] args) {
        
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
    }
    
    /*
     * prompt user for their birthdate and return it as a SampleDate
     * creates a sample date object based on user input via a terminal prompt
     */ 
    private static SampleDate getBirthdate() {
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("What day were you born? (Please use numbers seperated by space in month day year order) :");
        
        int month = scnr.nextInt();
        int day = scnr.nextInt();
        int year = scnr.nextInt();
        
        SampleDate birthdate = new SampleDate (year, month, day);
        
        return birthdate; 
    }
    
    // print stats about user's birthdate. This method was provided for me
    private static void details(SampleDate birthdate) {
        System.out.print("You were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek() + ".");
        if (birthdate.isLeapYear()) {
            System.out.println(birthdate.getYear() + " was a leap year.");
        }
    }
    
    /*
     * Count # days until next birthday
     * checks the day and the month to see when the next instance of that date will appear,
     * counting up until the day is equal
     */ 
    private static void daysUntilBirthday(SampleDate birthdate) {
        int daysUntilBirthday = 0;
        SampleDate currentDay = new SampleDate();
        
        while ((currentDay.getDay() != birthdate.getDay()) || (currentDay.getMonth() != birthdate.getMonth())){
            currentDay.nextDay();
            daysUntilBirthday += 1;
        }
        // the above method counts the up from current day until the next instance of the birthday
        // note that I ignore year here as we are just looking for the next instance of the specific month and day
        
        if (daysUntilBirthday == 0) { // this means its already their birthay if that equals 0
            System.out.println("Happy Birthday!");
        }
        else { // this will print out if it is not already their birthday
            System.out.println("You have " + daysUntilBirthday + " days until your next birthday.");
        }
        
    }
    
        
    /*
     * count # days old this person is
     * uses a similar approach to next birthday only it counts up
     * from the birthdate parameter to the current day
     */ 
    private static void daysOld(SampleDate birthdate) {
        SampleDate currentDay = new SampleDate();
        int daysOld = 0;
        
        while (!(birthdate.equals(currentDay))) { //I use the equals method here as year is important
                     birthdate.nextDay(); // this will loop and incrument the number daysOld from their birthdate to the currentDate
                     daysOld += 1;           
        }
        
        System.out.println("You are " + daysOld + " days old.");
    }
}