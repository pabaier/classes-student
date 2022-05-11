
/* 
 * CSCI 221, Fall 2017, HW 3
 * 
 * Program to prompt the user for the date of their birth and tell them 
 * something about that date.
 * 
 * Base code provided by instructor. The following updates 
 * 
 * completd the daysUntilBirthday and daysOld method
 * completed the getbirthdate method by adding a scanner to get user input
 * 
 * were added by
 * Ariel Robinson
 */ 

import java.util.*;
import java.util.Scanner;

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
        System.out.println("Enter the month, day and year of your birthday: ");
        Scanner userInput=new Scanner(System.in);
        int month=userInput.nextInt();
        int day =userInput.nextInt();
        int year= userInput.nextInt();
        SampleDate date= new SampleDate(year, month, day);

        /* Your solution goes here and change the return */
        return date; 
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

        SampleDate today= new SampleDate();

        int daysUntilBirthday = 0;

        //stores the birth month, and birth year and birthday
        int birthYear=birthdate.getYear();
        int birthMonth= birthdate.getMonth();
        int dayOfBirth=birthdate.getDay();

        //stores this year, the current day and month
        int dayNow= today.getDay();
        int thisMonth=today.getMonth();
        int thisYear=today.getYear();
        int nextYear=thisYear+1;
        //stores the beginning of every month which is 1
        int startingDay=1;

        //stores the last day of the month for the birth month and the current
        //current month
        int birthEndingDay=0;
        int currentEndingDay=0;

        if(birthMonth==4 || birthMonth==6|| birthMonth==9 || birthMonth==11){
            birthEndingDay=30;

        }
        else if (birthMonth == 2){
            birthEndingDay=28;

        }
        else {
            birthEndingDay=31;

        }
        if(thisMonth==4 || thisMonth==6|| thisMonth==9 || thisMonth==11){
            currentEndingDay=30;

        }
        else if (thisMonth == 2){
            currentEndingDay=28;

        }
        else {
            currentEndingDay=31;

        }

        //if today is user birthday they will get a happy birthday message
        if (today.getMonth()==birthdate.getMonth() && today.getDay()==birthdate.getDay()){
            int age= Math.abs(thisYear-birthYear);
            System.out.println("Happy Birthday! You are now " + age + " years old.");
            daysUntilBirthday=365;

        }
        //if birthday is during the current month

        else if(birthMonth==thisMonth && dayOfBirth<dayNow){
            daysUntilBirthday= 365-(dayNow-dayOfBirth);

        }
        //if the birth month equals this month and the day of birth hasn't happened
        //then the days will count until that day 
        else if(birthMonth==thisMonth && dayOfBirth>dayNow){

            daysUntilBirthday=Math.abs(dayOfBirth-dayNow);
        }
        else{
            //if birthday is before this month or after this month

            //counts until the current day gets to the end of the month
            for(int i=dayNow+1; i<=currentEndingDay;i++){
                daysUntilBirthday+=1;

            }
            thisMonth++;
            while(thisMonth!=birthMonth){
                if(thisMonth== 4 || thisMonth==6 ||thisMonth==9 || thisMonth==11){
                    daysUntilBirthday+=30;

                }
                else if(thisMonth==2){
                    daysUntilBirthday+=28;

                }
                else{
                    daysUntilBirthday+=31;

                }
                thisMonth++;

                if(thisMonth==13){
                    thisMonth=1;

                }

            }

            if(thisMonth==birthMonth){
                while(startingDay<=dayOfBirth){
                    startingDay+=1;
                    daysUntilBirthday+=1;

                }

            }

        }
        //prints days until next birthday

        System.out.println("The days until your next birthday: " + daysUntilBirthday);
    }

    /*
     * count # days old this person is
     * if born this year the starting day would be the day after they are born
     * if born in another year the years increment until the current year
    then adds remaining months and days 

     */

    private static void daysOld(SampleDate birthdate) {
        int daysOld = 0;
        SampleDate today= new SampleDate();
        //stores the birth month, birthday and birth year
        int birthYear=birthdate.getYear();

        int birthMonth=birthdate.getMonth();
        int dayOfBirth=birthdate.getDay();
        //stores the current day 
        int dayNow= today.getDay();
        int thisYear=today.getYear();

        //stores the current month
        int currentMonth=today.getMonth();

        int i=0;
        int startingMonth=1;
        int startingDay=1;
        //stores the last month which is decmber
        int endingMonth=12;
        int endingDay=0;
        int remainingDays=0;

        int counter=0;

        //figures out how many days are left in the birth month
        if(birthMonth==4 || birthMonth==6|| birthMonth==9 || birthMonth==11){
            endingDay=30;

        }
        else if(birthMonth==2){
            if ((birthYear%4==0 && !(birthYear%100==0)) || (birthYear%400==0)){

                endingDay=29;
            } 
            else{
                endingDay=28;
            }
        }
        else if (birthMonth == 2){
            endingDay=28;

        }

        else {
            endingDay=31;

        }

        //if the person was born this year the days will add starting from the day they were born
        if(birthYear==thisYear){
            if(birthMonth==currentMonth){

                for(int j=dayOfBirth+1; j<=dayNow; j++){
                    counter++;

                }
                daysOld=counter;
            }

            //if the birth month doesn't equal current month it keeps increasing
            //until it reaches the current month
            else if(birthMonth!=currentMonth){
                //if birthday is in the middle of the month 
                //remaining days are subtracting because below it adds all days in month

                remainingDays=endingDay-Math.abs(dayOfBirth-endingDay);

                while(birthMonth!=currentMonth){
                    if(birthMonth==4 || birthMonth==6|| birthMonth==9 || birthMonth==11){
                        daysOld+=30;

                    }
                    else if (birthMonth == 2){
                        if ((birthYear%4==0 && !(birthYear%100==0)) || (birthYear%400==0)){

                            daysOld+=29;
                        } 
                        else{
                            daysOld+=28;
                        }

                    }
                    else {
                        daysOld+=31;

                    }
                    birthMonth++;
                }
                //increases from the beginning of the month until the end of the month

                for(int k=1; k<=dayNow; k++){
                    daysOld+=1;

                }
            }
            daysOld-=remainingDays;
        }

        //adds the day of age from the day they were born until the last day of the month
        else if(birthYear!=thisYear){
            //increments birth day because the day of birth does not count towards how many days
            dayOfBirth++;

            for(i=dayOfBirth; i<=endingDay;i++){
                daysOld++;
            }
            //starts counting from the next month after their birth
            birthMonth++;

            for(i=birthMonth; i<=endingMonth; i++){
                if(i==4 || i==6|| i==9 || i==11){
                    daysOld+=30;

                }
                else if(i==2){
                    if((birthYear%4==0 && !(birthYear%100==0)) || (birthYear%400==0)){
                        daysOld+=29;

                    }
                    else{
                        daysOld+=28;

                    }
                }

                else  {
                    daysOld+=31;

                }
            }
            //starts counting from the year after their birth
            int forwardYear=birthYear+1;

            while(forwardYear!=thisYear){
                if((forwardYear%4==0 && !(forwardYear%100==0)) || (forwardYear%400==0)  ){
                    daysOld+=366;

                }
                else{
                    daysOld+=365;

                }
                forwardYear++;
            }
            //adds the days from the beginning of the year until the current month
            while(startingMonth!=currentMonth){
                if(startingMonth==4 || startingMonth==6|| startingMonth==9 || startingMonth==11){
                    daysOld+=30;

                }
                //if the month is in feb and a leap year it will add 29 days
                else if (startingMonth == 2){ 
                    if((forwardYear%4==0 && !(forwardYear%100==0))|| (forwardYear%400==0) ) {
                        daysOld+=29;

                    }
                    else{
                        daysOld+=28;

                    }
                }
                else if(startingMonth==2 && (thisYear%4==0 && !(thisYear%100==0)) || (thisYear%400==0)){
                    daysOld+=29;

                }
                else {
                    daysOld+=31;

                }
                //starting month increments until it gets to the current month
                startingMonth++;
            }

            //adds the days from the current month
            for(int k=1; k<=dayNow; k++){
                daysOld+=1;

            }
        }
        //prints out how many days old they are 
        System.out.println("You are " + daysOld + " days old.");
    }
}

