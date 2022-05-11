/* 
 * Represents a calendar month day, year.
 * Author:  Mary Washington
 * Version: Eclipse Oxygen 4.7
 */ 

import java.util.*;

public class CalendarDate {
    // constants that may be helpful in avoiding "magic numbers"
    // in your code making it more readable and extendable
    private static final int JANUARY  =  1;
    private static final int FEBRUARY =  2;
    private static final int DECEMBER = 12;
    private static final int DAYS_PER_WEEK = 7;
    private static final int FEB_NUM_DAYS_LEAP_YEAR = 29;
    private static final int FOUR_YRS = 4;
    private static final int ONE_HUNDRED_YRS = 100;
    private static final int FOUR_HUNDRED_YRS = 400;
    
    //The actual names of the month
    private static final String[] MONTH_NAMES = {" ",
    	//   1,        2,         3,       4	
    	"January", "February", "March", "April",
    	// 5,     6,      7,     8,          9
    	"May", "June", "July", "August", "September",
    	//   10,        11,        12
    	"October", "November", "December"};
   
    private static final String[] DAY_NAMES = {
        //    0,        1,         2,           3,
        "Sunday", "Monday", "Tuesday", "Wednesday",
        //    4,        5,         6
        "Thursday", "Friday", "Saturday"};

    private static final int[] DAYS_PER_MONTH = { -1,
    //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
    };

    
    private int year;
    private int month;
    private int day;

    // constructor(s)
    
    /*
     * Constructs a new CalendarDate to represent the specified year/month/day.
     */
    public CalendarDate(int year, int month, int day) {
       this.year = year;
       this.month = month;
       this.day = day;
    }
    
    /*
     * Constructs a new CalendarDate to represent today.
     * Don't tinker with this code - it will work as soon as YOU
     *   correctly complete the nextDay method
     */ 
    public CalendarDate() {
        this(1970, JANUARY, 1); // start date here
        // computes days since Jan 1, 1970
        int daysSinceEpoch = (int) ((System.currentTimeMillis() + 
            TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
        for (int i = 0; i < daysSinceEpoch; i++) 
            nextDay(); // changes the date stored
    }

    /*
     * Returns whether the given object is a CalendarDate that refers to the 
     * same year/month/day as this CalendarDate.
     */ 
    public boolean equals(Object o) {
       
        if (o instanceof CalendarDate) {
            CalendarDate other = (CalendarDate) o;
            return day == other.day && month == other.month && 
                   year == other.year;
        } else {
            return false;
        }
    }
    
    // Returns this Date's day.
    public int getDay() {
    	
        return this.day; 
    }
    
    // Returns this Date's month.
    public int getMonth() {
        return this.month; 
    }
    
    // Returns this Date's year.
    public int getYear() {
        return this.year; 
    }

    // Returns the day of the week and starts code on the day before suggested to make a normal week of Sun-Sat
    // Also makes the array easier to work with since the indices are from 0-6
    public String getDayOfWeek() {
    	CalendarDate startDate = new CalendarDate(1752,12,31);
    	int numDays = 0;
    	while(!(this.equals(startDate))) {
    		numDays++;
    		startDate.nextDay();
    	}
    	
    	//uses remainder as day of week
        return DAY_NAMES[numDays%DAYS_PER_WEEK]; 
    }
    //private helper method of getting the actual name of the month
    private String getMonthOfYear() {
    	
    	return MONTH_NAMES[getMonth()];
    }
    
   // Checking to see if a year is divisible by 4 and also if it's divisible by 100 but not 400
    public boolean isLeapYear() {
    	if((year%FOUR_YRS == 0) && !((year%ONE_HUNDRED_YRS == 0) && (year%FOUR_HUNDRED_YRS != 0))){
    		 return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
    // Advances the calendar day to the next day.  Also checks for a leap year since February will then have 29 days    
    public void nextDay() {
       day++;
       //check for day rollover
       if(isLeapYear() && month == FEBRUARY) {
    	   if(day > FEB_NUM_DAYS_LEAP_YEAR) {
    		   month++;
    		   day = 1;
    	   }
    	   
       }
       else {
    	   if(day > DAYS_PER_MONTH[month]) {
    		   month++;
    		   day = 1;
    		   
    	   }
    	   
       }
       //check for month rollover
       if(month > DECEMBER) {
    	   month = 1;
    	   year++;
       }
    }
    
   @Override
   // Returns a String representation of this CalendarDate, such as "March 23, 1953".
    public String toString() {
    	
        return getMonthOfYear() + " " + day + ", " + year;  
    }
    
    //checks to see if the date is even a real date
    public boolean isAValidDate() {
    	
    	
    	if(month > DECEMBER || month < JANUARY) {
    		return false;
    	}
        if(isLeapYear() && month == FEBRUARY) {
        	if(day > FEB_NUM_DAYS_LEAP_YEAR) {
        		return false;	
        	}
    		
    	}
        else if(day > DAYS_PER_MONTH[month]) {
        	return false;
        }
    	
    	return true;
    }
    
    //Returns the number of days from this date to date d.
    //Precondition: this date comes before d
    public int daysUntil(CalendarDate d) {
    	CalendarDate when = new CalendarDate(year, month, day);
    	int howMany = 0;
    	while(!when.equals(d)) {
    		howMany++;
    		when.nextDay();
    	}
    	return howMany;
    	
    }
   
}