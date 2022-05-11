
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    Updated:
  *    getBirthdate()
  * 
  * were added by
  * 
  *   Orianna Gandy-Wells
  */ 

import java.util.Scanner;

public class BirthDate {
    public static void main(String[] args) {
        
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
    
}
    
    /*
     * prompt user for their birthdate and return it as a CalendarDate
     */ 
    private static SampleDate getBirthdate() {
        Scanner scnr = new Scanner(System.in);
        System.out.print("What month, day and year, were you born? ");
        int month = scnr.nextInt();
        int day = scnr.nextInt();
        int year = scnr.nextInt();
        
        SampleDate CalendarDate = new SampleDate(year, month, day);
        return CalendarDate;
       
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
        /* Your solution goes here and replaces the declaration and
         * initialization of daysUntilBirthday */
        int age = 0;
    
        /*for (int i = 1753; i< 2018; i++){
            for (int j = 1; j <month; j++){
                for (int k = 1; k<day; k++){
                    
                }
            }
        }*/
        
        /*SampleDate today = new SampleDate (); 
        for (int i = 0; i <= 0; i++){
        }
        int daysUntilBirthday = 0;
        if (birthdate == today){
            System.out.println("Today is your birthday! Happy Birthday!");
            System.out.println("You are " + age + "today");
        }*/
        
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
        // Hint: count the days from birthdate to today's date
        
        System.out.println("You are " + daysOld + " days old.");
    }
}