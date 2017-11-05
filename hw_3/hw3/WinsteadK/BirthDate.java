
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    updated getBirthdate method, daysUntilBirthdate, daysOld methods
  *    updated CalendarDate, equals, getDay, getMonth, getYear,getDaysOfWeek, isLeapYear, nextDay, toString, getDaysInMonth constructors and methods 
  * 
  * were added by
  *  Kyle Winstead
  */ 

import java.util.*;

public class BirthDate {
    public static void main(String[] args) {
        int year=0;
        int day=0;
        int month=0;
        SampleDate birthdate = getBirthdate(year, month, day);
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
    }
    
    /*
     * prompt user for their birthdate and return it as a CalendarDate
     */ 
    private static SampleDate getBirthdate(int year, int month, int day) {
        /* Your solution goes here and change the return */
    	Scanner input= new Scanner(System.in);
   	    System.out.println("What month, day, and year were you born?  ");
        System.out.println("Please enter month: ");
        month = input.nextInt();
        System.out.println(month);
        System.out.println("Please enter day: ");
		 day = input.nextInt();
		 System.out.println(day);
		 System.out.print("Please enter year: ");
		 year = input.nextInt();
		 System.out.println(year);
		 SampleDate date  = new SampleDate(year, month, day);
		 
        return date; 
    }
    
    // print stats about user's birthdate
    private static void details(SampleDate birthdate) {
    	int year = 0;
    	int month=0;
    	int day=0;
    	SampleDate date  = new SampleDate(year, month, day);
        SampleDate today= new SampleDate();
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
      SampleDate today = new SampleDate();
      SampleDate today2 = today;
      
      int daysUntilBirthday = 0;
      int dayOne = birthdate.getDay();
      int monthOne = birthdate.getMonth();
      int monthTwo = today.getMonth();
      int todayDate=today.getYear();
      int yearTwo = todayDate + 1;
      int birthYear = birthdate.getYear();
      int yearsOld=0;
      SampleDate guessBday1 = new SampleDate(todayDate, monthOne, dayOne);
      SampleDate guessBday2 = new SampleDate (yearTwo, monthOne, dayOne);
      
      if(monthOne < monthTwo) {
    	  while(!guessBday2.equals(today2)) {
    		  today2.nextDay();
    		  ++daysUntilBirthday;
    	  }
    	  yearsOld = yearTwo - birthYear;
      }
      else{
    	  while(!guessBday1.equals(today2)) {
    		  today2.nextDay();
    		  ++daysUntilBirthday;
    	  }
    	  yearsOld = todayDate - birthYear;
      }
      if(daysUntilBirthday !=0) {
    	  System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
      }
      else {
    	  System.out.println("Happy birthday! you are now age " + yearsOld + " years old");
      }
    }
    
        
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
    	SampleDate today = new SampleDate();
    	SampleDate bdate = birthdate; 
    	int daysOld = 0;
    	
    		
    	do {
    		bdate.nextDay();
    		++daysOld;
    	}while(!bdate.equals(today));
    		System.out.println("You are " + daysOld + " days old");
    	}
}
		

    
