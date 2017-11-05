/*
 * Represents a calendar year/month/day date.
 * Dustin Cragg
 */ 

import java.util.*;

public class CalendarDate {
 
    private static final int JANUARY  =  1;
    private static final int FEBRUARY =  2;
    private static final int DECEMBER = 12;
    private static final int DAYS_PER_WEEK = 7;
    
   
    private static final String[] DAY_NAMES = {
     
        "Sunday", "Monday", "Tuesday", "Wednesday",
     
        "Thursday", "Friday", "Saturday"};

    private static final int[] DAYS_PER_MONTH = { -1,
    //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
    };

    
    private int year;
    private int month;
    private int day;

   
    
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
        // a well-behaved equals method returns false for null and non-CalendarDates
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
        return this.day; // fix this
    }
    
    // Returns this Date's month.
    public int getMonth() {
        return this.month; // fix this
    }
    
    // Returns this Date's year.
    public int getYear() {
        return this.year;
    }

    
    public String getDayOfWeek() {
    	 int index = 1;
         SampleDate temp = new SampleDate(1753, 1, 1);
         while (!temp.equals(this)) {
             temp.nextDay();
             index = (index + 1) % 7;
         }
         return DAY_NAMES[index];
 
       
    }
    
   
    public boolean isLeapYear() {
      return this.year % 400 == 0 || this.year % 4 == 0 && this.year % 100 != 0;  // every year is leap year until you fix this
    }
    

    public void nextDay() {

    	   ++this.day;
           if (this.day > this.getDaysInMonth()) {
               ++this.month;
               this.day = 1;
               if (this.month > 12) {
                   ++this.year;
                   this.month = 1;
               }
           }
    }
    
   
    public String toString() {
    	 return "" + this.year + "/" + this.month + "/" + this.day;
        
    }
    private int getDaysInMonth() {
        int result = DAYS_PER_MONTH[this.month];
        if (this.month == 2 && this.isLeapYear()) {
            ++result;
        }
        return result;
    }
}
  