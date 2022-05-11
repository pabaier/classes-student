/* Ariel Robinson
 * Represents a calendar year/month/day date.
 * 
 * Tells what day of the week it is, if the year is a leap year,
 * and can increment the days and returns the date
 * 
 */ 

import java.util.*;

public class CalendarDate {
    // constants that may be helpful in avoiding "magic numbers"
    // in your code making it more readable and extendable
    private static final int JANUARY  =  1;
    private static final int FEBRUARY =  2;
    private static final int MARCH=3;
    private static final int APRIL=4;
    private static final int MAY=5;
    private static final int JUNE=6;
    private static final int JULY=7;
    private static final int AUGUST=8;
    private static final int SEPTEMBER=9;
    private static final int OCTOBER=10; 
    private static final int NOVEMBER=11;

    private static final int FEBRUARYNUMDAYS=28;
    private static final int FEBRUARYLEAPNUMDAYS=29;

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
        return day; // fix this
    }

    // Returns this Date's month.
    public int getMonth() {
        return month; // fix this
    }

    // Returns this Date's year.
    public int getYear() {
        return year; // fix this
    }

    // Returns the day of the week on which this Date occurred,
    // such as "Sunday" or "Wednesday".
    // Hint: 1753/1/1 was a Monday (1)
    public String getDayOfWeek() {
        CalendarDate date= new CalendarDate(year,month,day);
        CalendarDate firstDate=new CalendarDate(1753,1,1);
        int currentDay=date.getDay();

        int numWeekDay=0;
        int i=1;
        //the days keep incrementing until it gets to the current date

        while((firstDate.equals(date))==false){
            i++;
            firstDate.nextDay();

        }

        return DAY_NAMES[i%DAYS_PER_WEEK]; // right now, every day is Sunday
    }

    // Returns whether this Date occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
        if(year%4==0 && !(year%100==0)){
            return true;

        }
        else if(year%400==0){
            return true;

        }
        else{
            return false;  
        }
    }

    // Advances this CalendarDate to the next day.
    // This may cause a wrap-around into the next month or year.
    public void nextDay() {
        CalendarDate date= new CalendarDate(year,month,day);
        //if the month has 30 days the day changes to 1 and goes to the next month
        if(day==DAYS_PER_MONTH[4] && (month==APRIL|| month==JUNE || month==SEPTEMBER || month==NOVEMBER)){
            day=1;
            month++;

        }
        //if the month is not December and it has 31 day then it goes to next month 
        //and day changes to 1 
        else if(month!=DECEMBER && day==DAYS_PER_MONTH[1] && (month==JANUARY || month==MARCH || month==MAY || month==JULY|| month==AUGUST || month==OCTOBER)){
            day=1;
            month++;

        }

        //if month is December and its the last day the year changes
        else if(month==DECEMBER && day==DAYS_PER_MONTH[12]){
            year++;
            month=JANUARY;
            day=1;
        }
        //if it is a leap year then the 29 change to March 1 
        else if(month==FEBRUARY && isLeapYear() && day==FEBRUARYLEAPNUMDAYS){
            month=MARCH;
            day=1;

        }
        //if it is February and not a leap year the last day is the 28th 
        else if(month==FEBRUARY && isLeapYear()==false && day==FEBRUARYNUMDAYS){
            month++;
            day=1;

        }
        else{

            day++;

        }

    }

    // Returns a String representation of this CalendarDate, such as "2005/9/22".
    // public String toString() {
    // CalendarDate date= new CalendarDate(year,month,day);
    // return date.getYear()+ "/" + date.getMonth()+ "/" + date.getDay();  // fix to return correctly formatted date
    // }

    public boolean isAValidDate(){
        if (month <1 || month> 12){
            return false;

        }
        if(isLeapYear()==true && month==FEBRUARY && day>29){
            return false;

        }
        if(isLeapYear()==false && month==FEBRUARY && day>28){
            return false;

        }
        if((month==JANUARY ||month==MARCH||month==MAY||month==JULY || month==AUGUST || month==OCTOBER || month==DECEMBER) && (day<1 || day>31))
        {
            return false;

        }
        if((month==APRIL || month==JUNE || month==SEPTEMBER || month==NOVEMBER) && (day>30 || day<1)) 
        {
            return false;

        }
        else{
            return true;
        }

    }
    // Returns the number of days from this date to date d.
    // Precondition: this date comes before d
    public int daysUntil(CalendarDate d) {
        CalendarDate when = new CalendarDate(year, month, day); // copy this
        int howMany = 0;
        while (!when.equals(d)) {
            howMany++;
            when.nextDay();
        }
        return howMany;
    }

    private String monthString(){
        String monthText="";
        if(month==1){
            monthText="January";

        }
        else if(month==2){
            monthText="February";
        }
        else if(month==3){
            monthText="March";
        }

        else if(month==4){
            monthText="April";
        }
        else if(month==5){
            monthText="May";
        }
        else if(month==6){
            monthText="June";

        }
        else if(month==7){
            monthText="July";

        }
        else if(month==8){
            monthText="August";
        }

        else if (month==9){
            monthText="September";

        }
        else if(month==10){
            monthText="October";

        }
        else if(month==11){
            monthText="November";

        }
        else if(month==12){
            monthText="December";
        }
        return monthText;

    }

    public String toString(){
        CalendarDate date= new CalendarDate(year,month,day);
        return date.monthString()+ " " +  date.getDay() +"," +  date.getYear();

    }

}

// Add any helper methods here - they must be declared to be private
