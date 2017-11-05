
/* 
 * CSCI 221, Fall 2017, HW 3
 * 
 * Program to prompt the user for the date of their birth and tell them 
 * something about that date.
 * 
 * Base code provided by instructor. The following updates 
 * 
 *   -completing getBirthdate()
 *   -completing daysUntilBirthday()
 *   -completing daysOld()
 * 
 * were added by Asa Perryman
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
        System.out.println("What month, day, and year were you born?");
        Scanner scnr = new Scanner(System.in);

        int month = 0;
        int day = 0;
        int year = 0;

        for( int i = 0; i < 3; i++){
            int birthdate = scnr.nextInt();

            if(i == 0){
                month = birthdate;
            }

            if(i == 1){
                day = birthdate;
            }

            if(i == 2){
                year = birthdate;
            }

        }

        SampleDate birthday = new SampleDate(year, month, day);
        return birthday; 
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
        SampleDate today = new SampleDate();

        int year = birthdate.getYear();
        int month = birthdate.getMonth();
        int day = birthdate.getDay();

        SampleDate birthdateNew = new SampleDate(year, month, day);

        int todayYear = today.getYear();
        int birthYear = birthdate.getYear();
        int yearDifference = todayYear - birthYear;

        if( today.getMonth() == birthdateNew.getMonth() && 
        today.getDay() == birthdateNew.getDay()){
            daysUntilBirthday = 0;
        }

        else{ 
            while(today.getMonth() != birthdateNew.getMonth() || 
            today.getDay() != birthdateNew.getDay()){
                birthdateNew.nextDay();
                //System.out.println(birthdateNew);
                daysUntilBirthday = (daysUntilBirthday) + 1;
            }

            daysUntilBirthday = daysUntilBirthday - 365;
            daysUntilBirthday = Math.abs(daysUntilBirthday);
        }

        // Hint: count the days from today's date until the user's next birthday
        // If today is the birthday, print Happy Birthday message
        if(daysUntilBirthday == 0){
            System.out.println("Happy Birthday! You are now age " + 
                yearDifference +".");
        }

        // if not print the message stating the number of days until the user's
        // next birthday
        else{
            System.out.println("It will be your birthday in " 
                + daysUntilBirthday + " days.");
        }
    }

    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {

        int daysOld = 0;
        // Hint: count the days from birthdate to today's date

        SampleDate today = new SampleDate();
        //System.out.println(birthdate);

        while(!(birthdate.equals(today))){
            birthdate.nextDay();
            daysOld = daysOld + 1 ;
        }

        System.out.println("You are " + daysOld + " days old.");
    }
}