/*
 * Represents a calendar year/month/day date.
 */ 

import java.util.*;

public class CalendarDate {
    // constants that may be helpful in avoiding "magic numbers"
    // in your code making it more readable and extendable
    private static final int JANUARY  =  1;
    private static final int FEBRUARY =  2;
    private static final int DECEMBER = 12;
    private static final int DAYS_PER_WEEK = 7;
    
    // these arrays that might simplify your code - remove if
    // you don't use them
    private static final String[] DAY_NAMES = {
        //    0,        1,         2,           3,
        "Sunday", "Monday", "Tuesday", "Wednesday",
        //    4,        5,         6
        "Thursday", "Friday", "Saturday"};

    private static final int[] DAYS_PER_MONTH = { -1,
    //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
    };

    // fields - should not change
    private int year;
    private int month;
    private int day;

    //variable that counts the number of leap years
    private int leap = 0;
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
        return this.year; // fix this
    }

    // Returns the day of the week on which this Date occurred,
    // such as "Sunday" or "Wednesday".
    // Hint: 1753/1/1 was a Monday (1)
    public String getDayOfWeek() {
        
        CalendarDate thatDay = new CalendarDate(1753, JANUARY, 1);
        String day = DAY_NAMES[0];
        int numDay = 1;
        while(!(thatDay.equals(this))){ 
            //numDay-= leap;
            thatDay.nextDay();
            ++numDay;
            if ((this.isLeapYear()) && (this.getMonth() == FEBRUARY) && (this.getDay() == 28)){
                //++leap;
                //day = DAY_NAMES[numDay - leap];
                day = DAY_NAMES[numDay];
                //System.out.println(day);
            }
            
            else if(numDay == 6){
                numDay = 0;
                day = DAY_NAMES[numDay];
            }
            else if (numDay != 6){
                day = DAY_NAMES[numDay];
            }
            
        }
            
        return day; // right now, every day is Sunday
    }

    
    // Returns whether this Date occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
        if (this.year % 400 == 0){
            //++leap;
            return true;
        }
        else if((this.year % 4 == 0) && (this.year % 100 != 0)){
            return false;
        }
    
        else{
            return false;
        }
    
    }
    
    // Advances this CalendarDate to the next day.
    // This may cause a wrap-around into the next month or year.
    
    public int daysInMonth(){
        int daysOfMonths = DAYS_PER_MONTH.length;
        int days = 0;
            for(int i = 1; i <= daysOfMonths; i++){
                if (this.month == i){
                    days = DAYS_PER_MONTH[i];
                    
                }           
        }
        return days;
    }
    public void nextDay() {
        //if the day is less than the number of days in the month, add 1
        if (this.getDay() < this.daysInMonth()){
            ++this.day;
        }
        //if it is the last day of the month, add 1 to month and set day equal to 1
        else if(this.isLeapYear() && (this.getMonth() == FEBRUARY) && (this.getDay() == 28)){
            ++this.day;
        }
        else if (this.isLeapYear() && this.getMonth() == FEBRUARY && (this.getDay() == 29)){
            ++this.month;
            this.day = 1;
        }
        else if(this.getMonth() < 12 && this.getDay() == this.daysInMonth()){
            ++this.month;
            this.day = 1;
        }
        //if it is the last day of the last month of the year, add 1 to year
        //and set the month and day equal to 1
        else if (this.getMonth() == 12){
            ++this.year;
            this.month = 1;
            this.day = 1;
        }
        
    }
    // Returns a String representation of this CalendarDate, such as "2005/9/22".
    public String toString() {
        return this.year + "/" + this.month + "/" + this.day;  // fix to return correctly formatted date
    }
    
    // Add any helper methods here - they must be declared to be private
    //System.out.println(CalenderDate.nextDay());
}
