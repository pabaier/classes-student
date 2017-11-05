/*
 * Represents a calendar year/month/day date.
 * Gabe Jurecki
 *
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

    /*------------------------FIRST PART-----------------------------------*/
    // Returns this Date's day.
    public int getDay() {
        int day = this.day;
        return day; // fix this
    }

    // Returns this Date's month.
    public int getMonth() {
        int month = this.month;
        return month; // fix this
    }

    // Returns this Date's year.
    public int getYear() {
        int year = this.year;
        return year; //
    }


    // Returns a String representation of this CalendarDate, such as "2005/9/22".
    public String toString() {
        int day = this.day;
        int month = this.getMonth();
        int year = this.year;

        return year+ "/" + month + "/" + day;  // fix to return correctly formatted date
    }
    // Returns the day of the week on which this Date occurred,
    // such as "Sunday" or "Wednesday".
    // Hint: 1753/1/1 was a Monday (1)

    /*-----------------------END FIRST PART-------------------------------*/

    /*-----------------------SECOND PART----------------------------------*/
    // Returns whether this Date occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
        boolean leap = true;
        if(this.year % 100 != 0 && (this.year % 400 == 0 || this.year % 4 == 0)){
            leap = true;
        } else{
            leap = false;
        }
        return leap;  // every year is leap year until you fix this
    }
    /*-----------------------END SECOND PART-----------------------------*/

    /*-----------------------THIRD PART----------------------------------*/
    // Advances this CalendarDate to the next day.
    // This may cause a wrap-around into the next month or year.
    public void nextDay() {
       if(this.month == 1 ||this.month == 3 ||this.month == 5 ||this.month == 7 ||this.month == 8 ||this.month == 10){
           if(this.day == 31){
               this.month++;
               this.day = 1;
           }else{
               this.day++;
           }
       }
       else if(this.month == 4 ||this.month == 6 ||this.month == 9 ||this.month == 11){
           if(this.day == 30){
               this.month++;
               this.day = 1;
           }else{
               this.day++;
           }
       }
       else if(month == 2){
           if(this.day == 28){
               this.month++;
               this.day = 1;
           }else{
               this.day++;
           }
       }else if(this.month == 12){
           if(this.day == 31) {
               this.day = 1;
               this.month = 1;
               this.year++;
           }else{
               this.day++;
           }
       }

    }
    /*-----------------------END THIRD PART------------------------------*/

    /*-----------------------FOURTH PART---------------------------------*/
    // Returns the day of the week on which this Date occurred,
    // such as "Sunday" or "Wednesday".
    // Hint: 1753/1/1 was a Monday (1)
    public String getDayOfWeek() {

        int startDay = 1;
        int startMonth = 1;
        int startYear = 1753;
        CalendarDate startDate = new CalendarDate(startYear, startMonth, startDay);
        int i = 1;
        while(!startDate.equals(this)) {
            if (i == 8) {
                i = 1;

            }

            i++;
            startDate.nextDay();
        }

        return DAY_NAMES[i]; // right now, every day is Sunday
    }
    /*-----------------------END FOURTH PART-----------------------------*/

    // Add any helper methods here - they must be declared to be private
}
