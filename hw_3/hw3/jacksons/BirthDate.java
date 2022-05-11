
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
  *   Sydney Jackson
  */ 

import java.util.*;
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
        /* Your solution goes here and change the return */
        Scanner scnr = new Scanner(System.in);
        System.out.println("What month, day and year were you born? ");
        int birthMonth = scnr.nextInt();
        int birthDay = scnr.nextInt();
        int birthYear = scnr.nextInt();
       
        SampleDate dayOfBirth = new SampleDate(birthYear,birthMonth,birthDay);
        return dayOfBirth;
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
        //System.out.println(today);
        int todayM = today.getMonth();
        int todayD = today.getDay(); 
        int birthM = birthdate.getMonth();
        int birthD = birthdate.getDay();
        int daysUntilBirthday = 0;
        if (todayM == birthM && todayD == birthD){
            System.out.println("Happy Birthday!");
        }
        else{
           while (today.getMonth() != birthdate.getMonth()){
               //daysUntilBirthday+=  - today.getDay();
               daysUntilBirthday++;
               today.nextDay();
               //System.out.println(today);
               while (today.getDay() != birthdate.getDay()){
                   daysUntilBirthday++;
                   today.nextDay();
                }
        }
    }
        //daysUntilBirthday;
    
    
        System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
        
        // Hint: count the days from today's date until the user's next birthday
        // If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
    
    
    }    
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
       SampleDate today = new SampleDate();
        int daysOld = 0;
        int leap = 0;
        while(!(birthdate.equals(today))){
            daysOld++;
            birthdate.nextDay();
            /*if (birthdate.getYear().isLeapYear()){
                leap++;
            }*/
        }
        //System.out.println(leap);
        daysOld -= 12;
        // Hint: count the days from birthdate to today's date
        System.out.println("You are " + daysOld + " days old.");
    }
}