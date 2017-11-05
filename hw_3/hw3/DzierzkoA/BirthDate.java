
/*
 * CSCI 221, Fall 2017, HW 3
 *
 * Program to prompt the user for the date of their birth and tell them
 * something about that date.
 *
 * Base code provided by instructor. The following updates
 *
 *    <List updates here>
 *
 * were added by
 *
 *   <Your name goes here>
 */

import java.util.*;

public class BirthDate {
    public static void main(String[] args) {

        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
    }

    /*
     * prompt user for their birthdate and return it as a CalendarDate
     */
    private static SampleDate getBirthdate() {
        int month, day, year;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What month, day, and year were you born? ");
        month = scanner.nextInt();
        day = scanner.nextInt();
        year = scanner.nextInt();
        return new SampleDate(year, month, day);
    }

    // print stats about user's birthdate
    private static void details(SampleDate birthdate) {
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

        if (today.getDay() == birthdate.getDay() && today.getMonth() == birthdate.getMonth()) {
            System.out.println("Happy Birthday!");
        } else {
            int daysUntilBirthday;
            int todayDays = 0;
            int birthdayDays = 0;

            // Calculate days since beginning of the year till today and same for birthday
            todayDays += daysSinceBeginningOfTheYear(today) + today.getDay();
            birthdayDays += daysSinceBeginningOfTheYear(birthdate) + birthdate.getDay();

            daysUntilBirthday = (todayDays > birthdayDays) ? 365 - (todayDays - birthdayDays) : birthdayDays - todayDays;

            System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
        }

    }


    /*
     * count # days old this person is
     */
    private static void daysOld(SampleDate birthdate) {
        SampleDate today = new SampleDate();
        int daysOld = 365 - (daysSinceBeginningOfTheYear(birthdate) + birthdate.getDay());
        for (int i = birthdate.getYear() + 1; i < today.getYear(); i++) {
            SampleDate current = new SampleDate(i, 1, 1);
            daysOld += current.isLeapYear() ? 366 : 365;
        }
        daysOld += daysSinceBeginningOfTheYear(today) + today.getDay();

        System.out.println("You are " + daysOld + " days old.");
    }


    private static int daysSinceBeginningOfTheYear(SampleDate date) {
        // This methods calculates how many days have past since beginning of the year to given month

        int daysSince = 0;
        for (int i = 1; i < date.getMonth(); i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                daysSince = daysSince + 31;
            }
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                daysSince = daysSince + 30;
            }
            // February
            if (i == 2) {
                daysSince = daysSince + 28;
            }
        }
        return daysSince;
    }
}