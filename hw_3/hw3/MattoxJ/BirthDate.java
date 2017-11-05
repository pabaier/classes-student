
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  * Updated methods except main and details with functional code
  * 
  * were added by
  * 
  *  Jacob Mattox <Your name goes here>
  */ 

import java.util.*;

public class BirthDate {
    public static void main(String[] args) {
        
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
       
    }
    //private method that grabs the user input and assigns to correct variables then creates an object
    private static SampleDate getBirthdate() {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter your birthday in the month day year form: ");
        int month = scnr.nextInt();
        int day = scnr.nextInt();
        int year = scnr.nextInt();
        SampleDate dateBorn = new SampleDate(year, month, day);
        return dateBorn; 
    }
    
    // print stats about user's birthdate
    private static void details(SampleDate birthdate) {
        System.out.print("You were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek() + ".");
        if (birthdate.isLeapYear()) {
            System.out.println(birthdate.getYear() + " was a leap year.");
        }
    }
    //determines how many days until next birthday
    private static void daysUntilBirthday(SampleDate birthdate) {
        SampleDate today = new SampleDate();
        int daysUntilBirthday = 0;
        int year = today.getYear();
        int month = birthdate.getMonth();
        int day = birthdate.getDay();
        SampleDate nextBirthday;
        
        if((birthdate.getMonth() == today.getMonth()) && (birthdate.getDay() == today.getDay()))
        {
            System.out.printf("Happy Birthday! You are now %d years old. \n", today.getYear() - birthdate.getYear());
        }
        else{
           if(today.getMonth() < birthdate.getMonth()){
               year = today.getYear();
        }
            else if((today.getMonth() > birthdate.getMonth()) || (today.getMonth() == birthdate.getMonth()
            && (today.getDay() > birthdate.getDay()))){
                year = today.getYear() + 1;
        }
        }
        nextBirthday = new SampleDate(year, month, day);//used to find next birthday when compared to current day
        
        while(!(today.equals(nextBirthday))){
            daysUntilBirthday++;
            today.nextDay();
        }
        System.out.printf("%d days until your birthday.\n", daysUntilBirthday);
    }
    //calculates number of days from birthdate to today
    private static void daysOld(SampleDate birthdate) {
        SampleDate today = new SampleDate();
        int daysOld = 0;
        while(!(birthdate.equals(today))){
            birthdate.nextDay();
            daysOld++;
        }
        System.out.println("You are " + daysOld + " days old.");
    }
}