
/* 
 * CSCI 221, Fall 2017, HW 3
 * 
 * Program to prompt the user for the date of their birth and tell them 
 * something about that date.
 * 
 * Base code provided by instructor. The following updates 
 * 
 *    Method SampleDate getBirthday
 *    Method daysUntilBirthday SampleDate 
 *    Method daysOld
 *    Class CalendarDate
 * 
 * were added by
 * 
 *   Jonathan Rabiu
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
        /* Your solution goes here and change the return */
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter your birthday as m/d/yyyy");
        int month = scnr.nextInt();
        int day = scnr.nextInt();
        int year = scnr.nextInt();
        SampleDate date = new SampleDate (year, month, day);
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
        int daysUntilBirthday = 0;
        // Hint: count the days from today's date until the user's next birthday
        // If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
        SampleDate today = new SampleDate ();
        int nextYear = 0;
        if (today.getMonth() < birthdate.getMonth()){
            nextYear = today.getYear();
        }else if(today.getMonth() == birthdate.getMonth()){
            if(today.getDay() < birthdate.getDay()){
             nextYear = today.getYear();  
            }else if (today.getDay() > birthdate.getDay()){
             nextYear = today.getYear() + 1;
            }else if (today.getDay() == birthdate.getDay()){
             System.out.print("Happy Birthday! ");
             int age = 0;
             age = today.getYear() - birthdate.getYear();
             System.out.println("You are now age " + age + ".");
             return;
            } 
        }else if(today.getMonth() > birthdate.getMonth()){
            nextYear = today.getYear() + 1;
        }
        SampleDate countDate = new SampleDate (today.getYear(), today.getMonth(), today.getDay());
        SampleDate nextBirthday = new SampleDate (nextYear, birthdate.getMonth(), birthdate.getDay());
        while(!countDate.equals(nextBirthday)){
            countDate.nextDay();
            daysUntilBirthday++;
        }
        System.out.println("Number of days until your birthday: " + daysUntilBirthday);
        }
    

    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate){
        int daysOld = 0;
        SampleDate today = new SampleDate();
        SampleDate countDate = new SampleDate(birthdate.getYear(), birthdate.getMonth(), birthdate.getDay());
        // Hint: count the days from birthdate to today's date
        while(!countDate.equals(today)){
            countDate.nextDay();
            daysOld++;
        }
        System.out.println("You are " + daysOld + " days old.");
    }
   
    
}
