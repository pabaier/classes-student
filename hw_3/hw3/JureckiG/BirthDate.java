
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  *
  * Gabe Jurecki
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
        System.out.println("What month, day, and year were you born on?:");
        Scanner scnr = new Scanner(System.in);
        int month= scnr.nextInt();
        int day= scnr.nextInt();
        int year= scnr.nextInt();
        SampleDate birthdate = new SampleDate(year, month, day);
        return birthdate;
    }
    
    // print stats about user's birthdate
    private static void details(SampleDate birthdate) {
        System.out.print("You were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek()+".");
        if (birthdate.isLeapYear()) {
            System.out.println(birthdate.getYear() + " was a leap year.");
        }

    }
    
    /*
     * Count # days until next birthday
     * Complete the following method
     */ 
    private static void daysUntilBirthday(SampleDate birthdate) {
        SampleDate today = new SampleDate();
        int daysOld = 0;
        int startYear = birthdate.getYear();
        int startMonth = birthdate.getMonth();
        int startDay = birthdate.getDay();
        int daysUntilBirthday = 0;
        yearLoop:
        if(birthdate.getMonth() + birthdate.getDay() == today.getDay() + today.getMonth()){
            int age;
            age = today.getYear() - birthdate.getYear();
            System.out.println("Happy birthday! You are now age " + age);
        }else {
            for (int year = birthdate.getYear(); year <= today.getYear() - (today.getYear() - birthdate.getYear()); year++) {

                int month = 1;
                if (year == startYear) {
                    month = startMonth;
                }
                while (month <= 12) {
                    int day = 1;
                    if (year == startYear && month == startMonth) {
                        day = startDay;
                    }
                    int daysInMonth = 30;
                    //this will decide daysInMonth regarding how many days are in the current month
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                        daysInMonth = 31;

                    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                        daysInMonth = 30;
                    } else if (month == 2) {
                        daysInMonth = 28;
                    }
                    while (day <= daysInMonth) {
                        daysUntilBirthday++;
                        if (year == today.getYear() && month == today.getMonth() && day == today.getDay()) {
                            break yearLoop;

                        }


                        day++;
                    }

                    month++;
                }
            }
        }


        System.out.println("It will be your birthday in "+daysUntilBirthday+" days.");
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
        int startYear = birthdate.getYear();
        int startMonth = birthdate.getMonth();
        int startDay = birthdate.getDay();
        yearLoop:
        for(int year = startYear; year <= today.getYear() + 1;year++ ){
            int month = 1;
            if(year == startYear){
                month = startMonth;
            }
            while(month <= 12){
                int day = 1;
                if(year == startYear && month == startMonth){
                    day = startDay;
                }
                int daysInMonth = 30;
                //this will decide daysInMonth regarding how many days are in the current month
                if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                    daysInMonth = 31;

                } else if(month == 4 || month == 6 || month == 9 || month == 11){
                    daysInMonth = 30;
                } else if(month == 2){
                    daysInMonth = 28;
                }
                while(day <= daysInMonth ){
                    daysOld++;
                    if(year == today.getYear() && month == today.getMonth() && day == today.getDay()){
                        break yearLoop ;

                    }


                    day++;
                }

                month++;
            }
        }
        // Hint: count the days from birthdate to today's date
        System.out.println("You are " + daysOld + " days old.");
    }


}