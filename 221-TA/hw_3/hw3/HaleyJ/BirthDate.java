
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    to the main(), getBirthdate(), daysUntilBirthday(SampleDate birthdate), 
  *    and daysOld(SampleDate birthdate) methods
  * were added by
  * 
  *   Carter Haley
  */ 

import java.util.*;

public class BirthDate {
    public static void main(String[] args) {
        System.out.println("What month, day, and year were you born? ");
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
    }
    /*
     * prompt user for their birthdate and return it as a SampleDate
     */ 
    private static SampleDate getBirthdate() {
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        int day = input.nextInt();
        int year = input.nextInt();
        
        SampleDate birthdate = new SampleDate(year, month, day);
        
        return birthdate;
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
        SampleDate currDay = new SampleDate();

        int today = currDay.getDay();
        int month = currDay.getMonth();
        int year = currDay.getYear();

        int birthmonth = birthdate.getMonth();
        int birthday = birthdate.getDay();
        int birthyear = birthdate.getYear();
        
        int bdayIn = 1;
        if(birthday == today && birthmonth == month){
            System.out.println("Happy Birthday!  You are now " + (year - birthyear) + ".");
        
        }
        else if (birthmonth >= month ) {
            for (int i = month; i <= birthmonth; i++) {
                //System.out.println("It will be your birthday in " + bdayIn + " days.");
                if (i == birthmonth) {
                    bdayIn += birthday;
                }
                else if(i == month && i % 2 == 0 && i != 2) {
                    bdayIn += 31 - today;
                }
                else if(i == month && i % 2 == 1) {
                    bdayIn += 30 - today;
                }
                else if (i == month && i ==2 && (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)){
                    bdayIn += 29-today;
                }
                else if (i == month && i ==2){
                    bdayIn += 28-today;
                }
                else if (i % 2 == 0 && i != 2 && i!= month) {
                    bdayIn += 31;
                } else if (i % 2 == 1&& i!= month) {
                    bdayIn += 30;
                } else if (i == 2 && (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)&& i!= month) {
                    bdayIn += 29;
                } else if (i==2 && i!=month){
                    bdayIn += 28;
                }else{}
            }
            System.out.println("It will be your birthday in " + bdayIn + " days.");
            bdayIn+=1;
        }
        else if(birthmonth <= month){
            for (int i = month; i<= 12; i++){
                if (i%2 == 1 && i==month){
                    bdayIn += 31 - today;
                }
                else if(i%2 == 0 && i != 2 && i==month){
                    bdayIn +=30 -today;
                }
                else if (i==month && (birthyear % 400 == 0 || birthyear % 4 == 0 && birthyear % 100 != 0) && i== 2 ){
                    bdayIn += 29-today;
                }
                else if (i == 2 && i == month){
                    bdayIn += 28-today;
                }
                else if (i%2 == 1){
                    bdayIn += 31;
                }
                else if(i%2 == 0 && i != 2 && i!=month){
                    bdayIn +=30;
                }
                else if ((birthyear % 400 == 0 || birthyear % 4 == 0 && birthyear % 100 != 0) && i== 2 ){
                    bdayIn += 29;
                }
                else if (i == 2){
                    bdayIn += 28;
                }
            }
            for (int i = 1; i<= birthmonth; i++){
                if (i == birthmonth){
                    bdayIn += birthday;
                }
                else if (i == 2 && (year+1 % 400 == 0 || year+1 % 4 == 0 && year+1 % 100 != 0)&& i!=birthmonth){
                    bdayIn += 29;
                }
                else if(i == 2 && i!=birthmonth){
                    bdayIn += 28;
                }
                else if (i%2 == 0 && i!=birthmonth){
                    bdayIn += 30;
                }
                else if (i%2 == 1 && i!=birthmonth){
                    bdayIn += 31;
                }
                else{
                }
            }
            System.out.println("It will be your birthday in " + bdayIn + " days.");
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
        int birthmonth = birthdate.getMonth();
        int birthday = birthdate.getDay();
        int birthyear = birthdate.getYear();
        
        SampleDate currDay = new SampleDate();
        
        int today = currDay.getDay();
        int currMonth = currDay.getMonth();
        int currYear = currDay.getYear();
        int daysOld = 1;
        
        if (birthmonth % 2 == 0 && birthmonth !=2){
                daysOld += (30 - birthday);
            }
            else if (birthmonth % 2 == 1){
                daysOld += (31 - birthday);
            }
            else if (birthmonth == 2 && (birthyear% 400 == 0 || birthyear % 4 == 0 && birthyear % 100 != 0)){
                daysOld += (29 - birthday);
            }
            else {
                daysOld += (28 - birthday);
            }
        for (int i = birthmonth+1; i<=12; i++){
            if(i%2 == 0 && i != 2){
                daysOld +=30;
            }
            else if ((birthyear % 400 == 0 || birthyear % 4 == 0 && birthyear % 100 != 0) && i== 2 ){
                daysOld += 29;
            }
            else if (i == 2){
                daysOld += 28;
            }
            else{
                daysOld += 31;
            }
        }
        for(int i = birthyear+1; i<currYear; i++){
            if (i % 400 == 0 || i % 4 == 0 && i % 100 != 0){
                daysOld += 366;
            }
            else{
                daysOld+=365;
            }
        }
        for (int i= 1; i<=currMonth; i++){
                if (i == currMonth){
                    daysOld += today;
                }
                else if (i == 2 && (currYear % 400 == 0 || currYear % 4 == 0 && currYear % 100 != 0)){
                    daysOld += 29;
                }
                else if(i == 2){
                    daysOld += 28;
                }
                else if (i%2 == 0){
                    daysOld += 30;
                }
                else if (i%2 == 1){
                    daysOld += 31;
                }
                else{
                }
            }
        System.out.println("You are " + daysOld + " days old.");
        }
    }