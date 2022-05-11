
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    getBirthDate()
  *    daysUntilBirthday()
  *    daysOld()
  * 
  * were added by
  * 
  *   Shaina Mae Mainar
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
        Scanner scnr = new Scanner(System.in);
        System.out.print("What month, day, and year were you born? ");
        int month = scnr.nextInt();
        int day = scnr.nextInt();
        int year = scnr.nextInt();
        SampleDate date = new SampleDate(year, month, day);
        
        return date ; 
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
        int currDay = today.getDay();
        int currMon = today.getMonth();
        int birthDay = birthdate.getDay();
        int birthMon = birthdate.getMonth();
        int daysUntilBirthday = 0;
        int calBDay = 0;
        int calDay = 0;
        
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        switch(currMon){
            case 12: calDay += monthDays[11];
            case 11: calDay += monthDays[10];
            case 10: calDay += monthDays[9];
            case 9: calDay += monthDays[8];
            case 8: calDay += monthDays[7];
            case 7: calDay += monthDays[6];
            case 6: calDay += monthDays[5];
            case 5: calDay += monthDays[4];
            case 4: calDay += monthDays[3];
            case 3: calDay += monthDays[2];
            case 2: calDay += monthDays[1];
            case 1: calDay += monthDays[0] - (monthDays[currMon-1]-currDay);
            break;
                        
            default: break;

        }
        switch(birthMon){
            case 12: calBDay += monthDays[11];
            case 11: calBDay += monthDays[10];
            case 10: calBDay += monthDays[9];
            case 9: calBDay += monthDays[8];
            case 8: calBDay += monthDays[7];
            case 7: calBDay += monthDays[6];
            case 6: calBDay += monthDays[5];
            case 5: calBDay += monthDays[4];
            case 4: calBDay += monthDays[3];
            case 3: calBDay += monthDays[2];
            case 2: calBDay += monthDays[1];
            case 1: calBDay += monthDays[0] -(monthDays[birthMon-1]-birthDay);
            break;
                        
            default: break;

        }
        if(birthMon < currMon){
            daysUntilBirthday = 365 - calDay + calBDay;
        }
        else if(currMon < birthMon){
            daysUntilBirthday = calBDay - calDay;
        }
        if(daysUntilBirthday == 0){
            System.out.println("It's your birthday. Happy Birthday!");
        }
        else{
            System.out.println("Days until your next birthday: " + daysUntilBirthday);
        }
        //System.out.println(calDay);
        //System.out.println(calBDay);
        //System.out.println(today);
        
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
       
        SampleDate today = new SampleDate();
        int currDay = today.getDay();
        int currMon = today.getMonth();
        int currYear = today.getYear();
        int birthDay = birthdate.getDay();
        int birthMon = birthdate.getMonth();
        int birthYear = birthdate.getYear();
        int daysUntilBirthday = 0;
        int calBDay = 0;
        int calDay = 0;
        int diffDay = 0;
        int diffYear = 0;
        
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        switch(currMon){
            case 12: calDay += monthDays[11];
            case 11: calDay += monthDays[10];
            case 10: calDay += monthDays[9];
            case 9: calDay += monthDays[8];
            case 8: calDay += monthDays[7];
            case 7: calDay += monthDays[6];
            case 6: calDay += monthDays[5];
            case 5: calDay += monthDays[4];
            case 4: calDay += monthDays[3];
            case 3: calDay += monthDays[2];
            case 2: calDay += monthDays[1];
            case 1: calDay += monthDays[0] -(monthDays[currMon-1]-currDay);
            break;
                        
            default: break;

        }
        switch(birthMon){
            case 12: calBDay += monthDays[11];
            case 11: calBDay += monthDays[10];
            case 10: calBDay += monthDays[9];
            case 9: calBDay += monthDays[8];
            case 8: calBDay += monthDays[7];
            case 7: calBDay += monthDays[6];
            case 6: calBDay += monthDays[5];
            case 5: calBDay += monthDays[4];
            case 4: calBDay += monthDays[3];
            case 3: calBDay += monthDays[2];
            case 2: calBDay += monthDays[1];
            case 1: calBDay += monthDays[0] -(monthDays[birthMon-1]-birthDay);
            break;
                        
            default: break;

        }
        diffDay = Math.abs(calBDay - calDay);
        diffYear = Math.abs(currYear - birthYear);
        //System.out.println(diffDay + " " + diffYear + " " + today);
        int leap = 0;
        for(int i = 0; i < diffYear; ++i){
            if(i % 4 == 0){
                    leap++;
            }
        }
        if(birthMon > currMon){
            daysOld = (diffYear-1) * 365 + calDay + leap;
        }
        else{
            daysOld = (diffYear*365)+ diffDay + leap;
        }
       // System.out.println(daysOld + " " + leap);
       
           // Hint: count the days from birthdate to today's date
        
        System.out.println("You are " + daysOld + " days old.");
    
    }
}