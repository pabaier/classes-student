 /* 
  * CSCI 221, Fall 2017, HW 3
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * Base code provided by instructor. The following updates 
  *    <UPDATES:  daysOld + daysUntilBirthday + getBirthdate + > 
  * 
  * were added by
  * <Stefan N. Veloff>
  */ 

import java.util.*;
//BirthDate class:
public class BirthDate {
    public static void main(String[] args) {
        
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
    }
    
    /*
     * prompt user for their birthDate and return it as a CalendarDate
     */ 
    private static SampleDate getBirthdate() {
    		//print statement:
        System.out.print("What month, day, and year were you born? ");
        //create scanner:
		Scanner input = new Scanner(System.in);
		//Scans input (month, day and year):
        int month = input.nextInt();
        int day = input.nextInt();
        int year = input.nextInt();
        SampleDate date = new SampleDate (year, month, day);
        SampleDate today = new SampleDate();
        //return statement:
        return date; 
    }
    
    // print stats about user's birthdate
    private static void details(SampleDate birthdate) {
        System.out.print("You were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek() + ".");
        //if statement for leapyear:
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
        SampleDate birthdateCheck = birthdate;
        //initialize variables:
        int daysUntilBirthday = 0;
        int years = today.getYear();
        int yearTwo = years + 1;
        int day = birthdate.getDay();
        int monthPrev = birthdate.getMonth();
        int yearThree = birthdate.getYear();
        int monthNew = today.getMonth();
        int yearsOld = 0;
        SampleDate todayNew = today;
        SampleDate BirthdayOne = new SampleDate(years, monthPrev, day);
        SampleDate Birthday2 = new SampleDate(yearTwo, monthPrev, day);

        //if previous month less than the current:
        if(monthPrev < monthNew) {
        	//while loop not equal 
        	while(!Birthday2.equals(todayNew)) {
        		todayNew.nextDay();
        		daysUntilBirthday++;
        	}
        	yearsOld = yearTwo - yearThree;
        }
        else {
        	while(!BirthdayOne.equals(todayNew)) {
        		todayNew.nextDay();
        		daysUntilBirthday++;
        	}
      yearsOld = years - yearThree;
        }
      //if statement:
      if (daysUntilBirthday !=0) {
    	  System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
      }
      //else:
      else {
    	  System.out.println("Happy Birthday! You are now age " + yearsOld + " years old.");
        
        	}
        }
        // Hint: count the days from today's date until the user's next birthday
        // If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
    
        
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
    	SampleDate today = new SampleDate();
    	SampleDate birthdateNew = birthdate;
        //initialize daysOld: 
        int daysOld = 0;
        //do while loop:
        do {
        		birthdate.nextDay();
        		//increment daysOld:
        		daysOld++;
        }
        //while loop (loop while not equal to new date)
        while(!birthdateNew.equals(today));
        //print statement:
        System.out.print("You are " + daysOld + " days old." );
    }
}