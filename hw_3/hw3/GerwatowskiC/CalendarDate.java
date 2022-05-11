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
        int yearsSince = this.year-1753;
        int daysSince = 1;
        int currYear = this.year-1;
        for (int i=1753; i<this.year; i++) {
            if (i%4==0 && (!(i%100==0 && i%400!=0))) {
                daysSince += 366;
            }
            else {
                daysSince += 365;
            }
        }
        for (int i=1; i<this.month; i++) {
            if (i==2){
                if (currYear%4==0 && (!(currYear%100==0 && currYear%400!=0))) {
                    daysSince += 29;
                    currYear++;
                }
                else {
                    daysSince += 28;
                    currYear++;
                }
            }
            else {
                daysSince += DAYS_PER_MONTH[i];
                currYear++;
            }
        }
        for (int i=1; i<this.day; i++) {
            daysSince += 1;
        }
        int dayOfWeek = (daysSince%7);
        return DAY_NAMES[dayOfWeek]; // right now, every day is Sunday
    }
    
    // Returns whether this Date occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
        boolean leap = false;
        if (this.year%4==0){
            if (this.year%100==0 && this.year%400!=0)
                leap = false;
            else {
                leap = true;
            }  
        }
        else {
            leap = false;
        }
        return leap;  // every year is leap year until you fix this
    }
    
    // Advances this CalendarDate to the next day.
    // This may cause a wrap-around into the next month or year.
    
    private boolean lastMonthDay() {
        return (this.day == DAYS_PER_MONTH[this.month]);
    }
    
    public void nextDay() {
        if (!isLeapYear()){
            if (lastMonthDay()){
                if (this.month == 12){
                    this.day=1;
                    this.month = 1;
                    this.year++;
                }
                else {
                    this.day=1;
                    this.month++;}
                } 
            else {
                this.day++;
            }
        }
        else {
            if (this.month!=2 && lastMonthDay()){
                if (this.month == 12){
                    this.day=1;
                    this.month = 1;
                    this.year++;
                }
                else {
                    this.day=1;
                    this.month++;}
                } 
            else if (this.month==2) {
                if (this.day==29){
                    this.day=1;
                    this.month++;
                }
                else if (lastMonthDay()){
                    this.day=29;
                }
                else {
                    this.day++;
                }
            }
            else {
                this.day++;
            }
        }
        // your solution goes here
    }
    
    // Returns a String representation of this CalendarDate, such as "2005/9/22".
    public String toString() {
        return (this.year + "/" + this.month + "/" + this.day);  // fix to return correctly formatted date
    }
    
    // Add any helper methods here - they must be declared to be private
}