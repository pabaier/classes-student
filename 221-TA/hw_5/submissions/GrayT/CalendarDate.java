
/*
 * Represents a calendar year/month/day date.
 * 
 * Tyler Gray
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
    
    private String monthNames[] = {"January" , "February" , "March", "April", "May", "June", "July", "August", "September","October","November","December"};
    
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
    
    // Returns the number of days from this date to date d.
    // Added per instructions / not used by my program
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
    //used to determine days between purchase and actual event day
    public int getDaysBetween(CalendarDate purchaseDate) {
	 
		
		int ct = 0;
		CalendarDate tempDate = purchaseDate;
		while(!tempDate.equals(this)) {
			ct ++;
			tempDate.nextDay();
		}
		return ct;
	}
    
    // Returns this Date's day.
    public int getDay() {
        return day; 
    }
    
    // Returns this Date's month.
    public int getMonth() {
        return month;
    }
    
    // Returns this Date's year.
    public int getYear() {
        return year; 
    }

    //Returns boolean to validate if a date is valid in terms of month and day
    public boolean isAValidDate() {
    	
    	switch(month) {
    		case 1:
    		case 3:
    		case 5:
    		case 7:
    		case 8:
    		case 10:
    		case 12:
    			if(day > 31) {
    				return false;
    			}
    			break;
    		case 4: 
    		case 6:
    		case 9:
    		case 11:
    			if(day > 30) {
    				return false;
    			}
    			break;
    			
    		case 2:
    			if(isLeapYear()) {
    				if(day > 29) {
    					return false;
    				}
    			}
    			else if(day > 28) {
    				return false;
    			}
    			
    			break;
    		default:
    			return false;
 
    	
    	}
    	

    	return true;
    }
    // Returns the day of the week on which this Date occurred,
    // such as "Sunday" or "Wednesday".
    // Hint: 1753/1/1 was a Monday (1)
    public String getDayOfWeek() {
 
    	int day = 1;
    	//CAlcualte days since Monday, then % by 7 to get what day into week it is
    	CalendarDate date = new CalendarDate(1753, 1,1);
    	while(!date.equals(this)) {
    		date.nextDay();
    		day = (day + 1) % DAYS_PER_WEEK; //Make sure the value stays under 7
    	}
    	
    		
    	
        return DAY_NAMES[day]; // right now, every day is Sunday
    }
    
    // Returns whether this Date occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
    	return (((year % 4 == 0) && (year % 100 != 0) || year % 400 == 0));  // every year is leap year until you fix this
    }
    
    // Advances this CalendarDate to the next day.
    // This may cause a wrap-around into the next month or year.
    public void nextDay() {
    	day++;
    	//Check to see if says go outside month
        if (day > getNumDaysInMonth())
        {
        	day = 1;
        	month++;
          //check to see if months go outside year
          if (month > 12)
          {
        	month = 1;
            year++;
          }
        }
    }
    
    // Returns a String representation of this CalendarDate, such as "2005/9/22".
    public String toString() {
    	
    	// ?? ??? ?? ??? ???
    	//Nicer output
    	String dayString = "";
    	switch(day%10) {
    	case 1:
    		dayString = "st";
    		break;
    	case 2:
    		dayString = "nd";
    		break;
    	case 3:
    		dayString = "rd";
    		break;
    	case 4:
    	case 5:
    	case 6:
    	case 7:
    	case 8:
    	case 9:
    	case 0:
    		dayString = "th";
    		break;
    		
    		
    		
    	}
    	return monthNames[month-1] +" " + day + dayString + ", " + year; 
        //return year + "/" + month + "/" + day; 
    }
    
    // Add any helper methods here - they must be declared to be private
    private int getNumDaysInMonth()
    {

      //Check for weird February month days
      if ((month == 2) && (isLeapYear())) {
        return DAYS_PER_MONTH[month] + 1;
      }
      else {
    	  return DAYS_PER_MONTH[month];
      }

    }
}