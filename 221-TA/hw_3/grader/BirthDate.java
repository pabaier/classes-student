
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    <List updates here> 
  * 
  * were added by
  * 
  *   Matt Hancock
  */ 

import java.util.*;

public class BirthDate {
    public static void main(String[] args) {
        
        //SampleDate birthdate = getBirthdate();
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
    }
    
    /*
     * prompt user for their birthdate and return it as a SampleDate
     */ 
    //public static SampleDate getBirthdate() {
    public static SampleDate getBirthdate() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("What month, day, and year were you born?");
        
        int month = scnr.nextInt();
        int day = scnr.nextInt();
        int year = scnr.nextInt();
        SampleDate date = new SampleDate (year, month, day);
        return date; 
    }
    
    // print stats about user's birthdate
    public static void details(SampleDate birthdate) {
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
    public static void daysUntilBirthday(SampleDate birthdate) {
        /* Your solution goes here and replaces the declaration and
         * initialization of daysUntilBirthday */
        SampleDate today = new SampleDate ();
        int daysUntilBirthday = 0;
        int todayDay = today.getDay();
        int todayMonth = today.getMonth();
        int bdayDay = birthdate.getDay();
        int bdayMonth = birthdate.getMonth();
        
        while(todayDay != bdayDay || todayMonth != bdayMonth){
            today.nextDay();
            daysUntilBirthday +=1;
            todayDay = today.getDay();
            todayMonth = today.getMonth();
        }
        if(daysUntilBirthday == 0){
            System.out.println("HAPPY BIRTHDAY!!");
        }else{
            System.out.println(daysUntilBirthday +" days until your next birthday");
        }
        

        
        
        // Hint: count the days from today's date until the user's next birthday
        // If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
    }
    
        
    /*
     * count # days old this person is
     */ 
    public static void daysOld(SampleDate birthdate) {
        SampleDate today = new SampleDate ();
        int daysOld = 0;
        while(birthdate.equals(today) == false){
            daysOld += 1;
            birthdate.nextDay();
        }
        System.out.println("You are " + daysOld + " days old.");
    }
}