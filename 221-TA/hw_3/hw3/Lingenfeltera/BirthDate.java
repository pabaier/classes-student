
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    requesting user input 
  *    setting user input as birthdate
  *    calculating user age in day and adding days for leap years during lifetime
  *    calculating days until next birthday
  *    printing happy birthday if users birthday matches current date
  *  
  *    
  * 
  * were added by
  * 
  *   Andrea Lingenfelter
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
     * prompt user for their birthdate and return it as a CalendarDate
     */ 
    private static SampleDate getBirthdate() {
        /* Your solution goes here and change the return */
        Scanner input = new Scanner(System.in);
        System.out.println("What month were you born? ");
        int month = input.nextInt();
        System.out.println("What day were you born? ");
        int day = input.nextInt();
        System.out.println("What year were you born? ");
        int year = input.nextInt();
        
        
        SampleDate date = new SampleDate(year, month, day);
        
        return date; 
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
        SampleDate today = new SampleDate();
        int[] DAYS_PER_MONTH = { -1,
    //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
        int currMonth = today.getMonth();
        int currDay = today.getDay();
        int currYear = today.getYear();
      
        int currDaysFromJan1 = 0;
        int bDaysFromJan1 = 0;
        int bMonth = birthdate.getMonth();
        int bDay = birthdate.getDay();
        int bYear = birthdate.getYear();
        int ageYears = 0;
        int daysUntilBirthday = 0;
        if (currMonth > bMonth || (currMonth == bMonth && currDay >= bDay)){
            ageYears = currYear - bYear;
            System.out.println("Already bday this year. Age: " + ageYears);
        } 
        else {
            ageYears = currYear - 1 - bYear;
            System.out.println("no birthday yet this year. Age: " + ageYears);
        }
        
        
        //count days of the year passed to current date
        for (int i = 0; i < currMonth; i++){
            currDaysFromJan1 += DAYS_PER_MONTH[i];
        }
        currDaysFromJan1 += currDay;
        
        //count days from Jan 1 to birthdate
        for (int i = 0; i < bMonth; i++){
            bDaysFromJan1 += DAYS_PER_MONTH[i];
        }
        bDaysFromJan1 += bDay;  
        
        //calculate days until next birthday, if bday hasn't passed in calendar year
        if (bDaysFromJan1 > currDaysFromJan1){
            daysUntilBirthday = bDaysFromJan1 - currDaysFromJan1;
            
        }
        //calculate days until next birthday if birthday has passed during calendar year
        else {
            daysUntilBirthday = (365 - currDaysFromJan1) + bDaysFromJan1;
            
        }
        // Hint: count the days from today's date until the user's next birthday
        // If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
        if (currMonth == bMonth && currDay == bDay){
            System.out.println("Happy Birthday! You are now age " + ageYears + ".");
        }
        else {
            System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
        }
        
    }
    
        
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
        
        int daysOld = 0;
        SampleDate today = new SampleDate();
        int bMonth = birthdate.getMonth();
        int bDay = birthdate.getDay();
        int currMonth = today.getMonth();
        int currDay = today.getDay();
        int currYear = today.getYear();
        int bYear = birthdate.getYear();
        int bToEOY = 0;
        int jan1ToT = 0;
        int[] DAYS_PER_MONTH = { -1,
    //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
        // Hint: count the days from birthdate to today's date
        //count days from birthday to end of year
        for (int i = bMonth; i <=12; i++){
            bToEOY += DAYS_PER_MONTH[i];
        }
        bToEOY -= bDay;
        //add day if born before Feb 29 during leap year
        if (birthdate.isLeapYear() && bMonth < 3){
            bToEOY += 1;
        }
              
        //count days from Jan 1 to current date
        for (int i = 1; i < currMonth; i++){
            jan1ToT += DAYS_PER_MONTH[i];
        }
        jan1ToT += currDay;
        //add full years, then days for birthyear and current year
        for (int i = bYear + 1; i < currYear; i++){
            if (i % 4 == 0 && i != 1800 && i != 1900) {
                daysOld += 366;
            }
            else {
                daysOld += 365;
            }
        }
        daysOld = daysOld + bToEOY + jan1ToT;
        
        
        System.out.println("You are " + daysOld + " days old.");
    }
}