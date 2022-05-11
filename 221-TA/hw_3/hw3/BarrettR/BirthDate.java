//package HW3;

 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  *
  *   Ryan Barrett
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
     */ 
    private static SampleDate getBirthdate() {
        System.out.print("What month, day, and year were you born?");
        Scanner scan = new Scanner(System.in);
        int month = scan.nextInt();
        int day = scan.nextInt();
        int year = scan.nextInt();
        SampleDate birthdate = new SampleDate(year, month, day);
        return birthdate; 
    }
    
    // print stats about user's birthdate
    private static void details(SampleDate birthdate) {
        System.out.print("You were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek() + ".");
        if (birthdate.isLeapYear()) {
            System.out.println(birthdate.getYear() + " was a leap year.");
        }
    }
    
    /*
     * Count # days until next birthday
     * Complete the following method
     */ 
    private static void daysUntilBirthday(SampleDate birthdate) {
        SampleDate date = new SampleDate();
        int dayCounter = 0;
        if(date.getDay() == birthdate.getDay() && date.getMonth() == birthdate.getMonth())
        {
            System.out.print("Happy Birthday!");
            System.out.println("  You are now age " + (findDaysOld(birthdate) % 365) + ".");
        }
        else
        {
            while(date.getDay() != birthdate.getDay() || date.getMonth() != birthdate.getMonth())
            {
                dayCounter++;
                date.nextDay();
            }
            System.out.println("It will be your birthday in " + dayCounter + " days.");
            
        }
        // Hint: count the days from today's date until the user's next birthday
        // If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
    }
    
        
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
        
        int daysOld = 0;
        SampleDate currentDate = new SampleDate();
        SampleDate tracker = new SampleDate(birthdate.getYear(), birthdate.getMonth(), birthdate.getDay());
        while(!tracker.equals(currentDate))
        {
            daysOld++;
            tracker.nextDay();
        }
        
        System.out.println("You are " + daysOld + " days old.");
    }
    
    private static int findDaysOld(SampleDate birthdate)
    {   
        int daysOld = 0;
        SampleDate currentDate = new SampleDate();
        SampleDate tracker = new SampleDate(birthdate.getYear(), birthdate.getMonth(), birthdate.getDay());
        while(!tracker.equals(currentDate))
        {
            daysOld++;
            tracker.nextDay();
        }
        
        return daysOld;
    }
}