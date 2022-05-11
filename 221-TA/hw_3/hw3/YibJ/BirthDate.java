
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    update SampleDate getBirthdate()
  *             daysUntilBirthday
  *             daysOld
  *             
  * 
  * were added by
  * 
  *   Julie Yib 
  */ 

import java.util.*;

public class BirthDate {
    public static void main(String[] args) {
        
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
        
    }
    
    private static SampleDate getBirthdate() {
        Scanner input = new Scanner(System.in);
        System.out.print("What month, day, and year were you born?");
        int month = input.nextInt();
        int day = input.nextInt();
        int year = input.nextInt();
        SampleDate date = new SampleDate (year, month, day);
        return date; 
    }
    
    private static void details(SampleDate birthdate) {
        System.out.print("You were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek() + ".");
        if (birthdate.isLeapYear()) {
            System.out.println(birthdate.getYear() + " was a leap year.");
        }
    }

    private static void daysUntilBirthday(SampleDate birthdate) {
         //calls current dates 
         SampleDate today = new SampleDate ();       
         int daysUntilBirthday = 0; 
         if ((today.getMonth() == birthdate.getMonth()) && (today.getDay() == 
         birthdate.getDay())){
            System.out.println("Happy Birthday!");
            return;
            }  
         //prompts birthdate the following year 
         int nextYear = today.getYear();
         if ((today.getMonth() > birthdate.getMonth()) || 
         (today.getMonth() == birthdate.getMonth()) && 
         (today.getDay() > birthdate.getDay()))
         {
             nextYear++;
            } 
         //sets a new SampleDate for the following year 
         SampleDate nextBday = new SampleDate(nextYear, birthdate.getMonth(),
         birthdate.getDay());
         while (!today.equals(nextBday)){
             today.nextDay();
             daysUntilBirthday++;
            }
          System.out.println("It will be your birthday in " + daysUntilBirthday
          + " days.");
    }
   
    private static void daysOld(SampleDate birthdate) {
        SampleDate today = new SampleDate ();
        int daysOld = 0;
        while (!birthdate.equals(today))
        {
            birthdate.nextDay();
            daysOld++;
        }
        System.out.println("You are " + daysOld + " days old.");
    }
    
}
