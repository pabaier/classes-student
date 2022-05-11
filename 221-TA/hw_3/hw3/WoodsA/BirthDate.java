
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *   Completed getBirthdate()
  *   Completed daysUntilBirthday()
  *   Completed daysOld()
  * 
  * were added by
  * 
  *  Ashley Woods
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
        Scanner scnr = new Scanner(System.in);
        System.out.print("What month, day, and year were you born? ");
        int birthMonth = scnr.nextInt();
        int birthDay = scnr.nextInt();
        int birthYear = scnr.nextInt();
        SampleDate date = new SampleDate(birthYear, birthMonth, birthDay);
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
        int[] DAYS_PER_MONTH = { -1,
        //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
        };
         SampleDate today = new SampleDate();
         int daysUntilBirthday =0;
        if (today.getDay() == birthdate.getDay() && today.getMonth() == birthdate.getMonth()) {
             System.out.println("Happy Birthday! You are now age " + (today.getYear() - birthdate.getYear()) + ".");
        }
        else {
            int birthMonth = birthdate.getMonth();
            int thisMonth = today.getMonth();
            //count days from this month
            if (today.getMonth() == birthdate.getMonth()) {
                for (int i=today.getDay(); i<birthdate.getDay(); i++) {
                    daysUntilBirthday += 1;
                }
            }
            else{
                for (int i=today.getDay(); i<=DAYS_PER_MONTH[today.getMonth()]; i++) {
                    daysUntilBirthday += 1;
                    if (birthMonth==2 && birthdate.isLeapYear()) {
                        daysUntilBirthday += 1;
                    }
                }
                //count days from inbetween months
                if (birthMonth < thisMonth) {
                    birthMonth += 12;
                    for (int i=birthMonth-1; i> thisMonth; i--) {
                        if (i>12) {
                            int x = i-12;
                            daysUntilBirthday += DAYS_PER_MONTH[x];
                            SampleDate countingYear = new SampleDate((today.getYear()+1),1,1);
                            if (x==2 && countingYear.isLeapYear()) {
                                daysUntilBirthday += 1;
                            }
                        }
                        else {
                            daysUntilBirthday += DAYS_PER_MONTH[i];
                            if (i==2 && today.isLeapYear()) {
                                daysUntilBirthday += 1;
                            }
                        }
                    }
                }
                else {
                    for (int i=thisMonth+1; i<birthMonth; i++) {
                        daysUntilBirthday += DAYS_PER_MONTH[i];
                        if (i==2 && today.isLeapYear()) {
                            daysUntilBirthday += 1;
                        }
                    }
                }
                //count days from current birth month
                for (int i=1; i<birthdate.getDay(); i++) {
                    daysUntilBirthday += 1;
                }
            }
            System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
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
        int[] DAYS_PER_MONTH = { -1,
        //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
        };
        SampleDate today = new SampleDate();
        int startYear = birthdate.getYear();
        int endYear = today.getYear();
        //count days from birth month
        for(int i=birthdate.getDay(); i<=DAYS_PER_MONTH[birthdate.getMonth()]; i++){
            daysOld += 1;
        }
        if (birthdate.getMonth()==2 && birthdate.isLeapYear()){
            daysOld +=1;
        }
        //count days from months until end of birthyear
        for (int i=birthdate.getMonth()+1; i<=12; i++){
            daysOld += DAYS_PER_MONTH[i];
            if (i == 2 && birthdate.isLeapYear()) {
                daysOld += 1;
            }
        }
        //count days from years until this year
        for (int i=startYear+1; i<endYear; i++) {
            SampleDate countingYear = new SampleDate(i,1,1);
            if (countingYear.isLeapYear()) {
                daysOld += 366;
            }
            else {
                daysOld += 365;
            }
        }
        //count days from months until this month
        for (int i = 1; i<today.getMonth(); i++) {
            daysOld += DAYS_PER_MONTH[i];
            if (i==2 && today.isLeapYear()) {
                daysOld += 1;
            }
        }
        //count days from this month up until today
        for (int i=1; i<today.getDay(); i++) {
            daysOld += 1;
        }
        System.out.println("You are " + daysOld + " days old.");
    }
}