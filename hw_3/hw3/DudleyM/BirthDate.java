
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
  *   <Michael Dudley>
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

        Scanner sc = new Scanner(System.in);
        String birthday = sc.nextLine();
        String[] blank = birthday.split(" ");
        int month = Integer.parseInt(blank[0]);
        int day = Integer.parseInt(blank[1]);
        int year = Integer.parseInt(blank[2]);

        return new SampleDate(year,month,day);
    }
    
    // print stats about user's birthdate
    private static void details(SampleDate birthdate) {
        System.out.print("You were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek() + ".");
        if (birthdate.isLeapYear()) {
            System.out.println(birthdate.getYear() + " was a leap year.");
        }
    }

    private static void daysUntilBirthday(SampleDate birthdate) {

        int daysUntilBirthday = 0;
        SampleDate today = new SampleDate();
        SampleDate tempDate = new SampleDate();
        SampleDate nextBirthday;
        // Hint: count the days from today's date until the user's next birthday
        if (today.getMonth() < birthdate.getMonth()) {
            nextBirthday = new SampleDate(today.getYear(), birthdate.getMonth(), birthdate.getDay());

        } else if (today.getMonth() == birthdate.getMonth() && today.getDay() <= birthdate.getDay()) {
            nextBirthday = new SampleDate(today.getYear(), birthdate.getMonth(), birthdate.getDay());
        } else {
            nextBirthday = new SampleDate(today.getYear() + 1, birthdate.getMonth(), birthdate.getDay());
        }
        while (!tempDate.equals(nextBirthday)) {
            tempDate.nextDay();
            daysUntilBirthday++;
        }
        if(daysUntilBirthday > 0){
            System.out.println("It will be your birthday in " + daysUntilBirthday + " days." );

        }else{
            System.out.println("Happy Birthday! You are now age " + (today.getYear() - birthdate.getYear()) + "." );
        }
    }
    private static void daysOld(SampleDate birthdate) {
        
        int daysOld = 0;
        // Hint: count the days from birthdate to today's date
        SampleDate tempDate = birthdate;
        SampleDate today = new SampleDate();
        while(!tempDate.equals(today)){
            tempDate.nextDay();
            daysOld++;
        }
        System.out.println("You are " + daysOld + " days old.");
    }
}