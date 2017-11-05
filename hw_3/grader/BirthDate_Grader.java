import java.lang.reflect.Method;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.List; 
import java.util.ArrayList; 
import java.util.Calendar;

// needs to test
    // 1. getBirthDate method
            // should take in month, day, year
            // return SampleDate object
    // 2. details(SampleDate) method
            // should print: "You were born on _______ which was a _______"
            // might print: "___(year)___ was a leap year."
    // 3. daysUntilBirthday(SampleDate)
            // should print a happy birthday message
                // or
            // the number of days until the next birthday
    // 4. daysOld(SampleDate)
            // should print: "You are _______ days old."


public class BirthDate_Grader {

        // set input
        public static InputStream originalInput = System.in;
        // FileInputStream in = new FileInputStream(new File("input"));

        // get output
        public static PrintStream originalOutput = System.out;
        public static ByteArrayOutputStream baos = new ByteArrayOutputStream();
        public static PrintStream output = new PrintStream(baos);

    public static void main (String[] args) throws Exception {
        int totalPoints = 0;
        int sectionTotal = 0;
        int outOf = 0;
        // test classes
        System.out.println("BirthDate Class Tests:");
        BirthDateSolution birthDate_Solution = new BirthDateSolution();
        BirthDate birthDate_Student = new BirthDate();
        
        // main() test
        // mainTest();

        // getBirthdate() test (9)
        sectionTotal += getBirthDateTest(birthDate_Solution, birthDate_Student);
        // details() test (9)
        sectionTotal += getDetails(birthDate_Solution, birthDate_Student);
        // daysUntilBirthday test (6)
        sectionTotal += getDaysUntilBirthday(birthDate_Solution, birthDate_Student);
        // daysOld test (3)
        sectionTotal += getDaysOld(birthDate_Solution, birthDate_Student);
        outOf += 27;
        totalPoints += sectionTotal;
        System.out.println(" Section Total: " + sectionTotal + "/" + outOf);

        // CalendarDate test
        sectionTotal = 0;
        System.out.println("\nCalendarDate Class Tests:");
        // getDay() test (3)
        sectionTotal += getDayTest();
        // getMonth() test (3)
        sectionTotal += getMonthTest();
        // getYear() test (3)
        sectionTotal += getYearTest();
        // getDayOfWeek() test (6)
        sectionTotal += getDayOfWeekTest();
        // isLeapYear() test (6)
        sectionTotal += isLeapYearTest();
        // nextDay() test
        sectionTotal += nextDayTest();

        // toString() test (YYYY/DD/MM or YYYY/D/M)

        outOf += 9;
        totalPoints += sectionTotal;
        System.out.println(" Section Total: " + sectionTotal + "/" + 9);
        System.out.println("Total Grade: " + totalPoints + "/" + outOf);
    }

    public static int nextDayTest() {
        int points = 0;
        int full = 3;
        System.out.println("\tTesting nextDay()");
        SampleDate answer_random = new SampleDate(1924, 9, 12);
        SampleDate answer_new_month = new SampleDate(1969, 4, 30);
        SampleDate answer_new_year = new SampleDate(1998, 12, 31);
        try {
            CalendarDate student_random = new CalendarDate(1924, 9, 1);
            CalendarDate student_new_month = new CalendarDate(1969, 4, 3);
            CalendarDate student_new_year = new CalendarDate(1998, 12, 3);

            answer_random.nextDay();answer_new_month.nextDay();answer_new_year.nextDay();answer_new_year.nextDay();
            student_random.nextDay();student_new_month.nextDay();student_new_year.nextDay();student_new_year.nextDay();
            
            List<Integer> dates_random = new ArrayList<>();
            dates_random.add(answer_random.getMonth());
            dates_random.add(answer_random.getDay());
            dates_random.add(answer_random.getYear());

            List<Integer> dates_new_month = new ArrayList<>();
            dates_new_month.add(answer_new_month.getMonth());
            dates_new_month.add(answer_new_month.getDay());
            dates_new_month.add(answer_new_month.getYear());
            
            List<Integer> dates_new_year = new ArrayList<>();
            dates_new_year.add(answer_new_year.getMonth());
            dates_new_year.add(answer_new_year.getDay());
            dates_new_year.add(answer_new_year.getYear());

            if(!( dates_random.contains(student_random.getMonth()) && 
                    dates_random.contains(student_random.getDay()) && 
                    dates_random.contains(student_random.getYear()) 
                )) {
                System.out.println("\t\tMethod ran but wrong output - " + (full / 2) + "/" + full);
                System.out.println("\t\t\tYour output with day change " + studentToString(student_random));
                System.out.println("\t\t\tExpected output with day change " + answer_random);
                points += full / 2;
            }
            else {
                points += full;
                System.out.println("\t\tCorrect " + studentToString(student_random) + " - " + full + "/" + full);                
            }

            if(!( dates_new_month.contains(student_new_month.getMonth()) && 
                    dates_new_month.contains(student_new_month.getDay()) && 
                    dates_new_month.contains(student_new_month.getYear()) 
                )) {
                System.out.println("\t\tMethod ran but wrong output - " + (full / 2) + "/" + full);
                System.out.println("\t\t\tYour output with month change " + studentToString(student_new_month));
                System.out.println("\t\t\tExpected output with month change " + answer_new_month);
                points += full / 2;
            }
            else {
                points += full;
                System.out.println("\t\tCorrect " + studentToString(student_new_month) + " - " + full + "/" + full);                
            }


            if(!( dates_new_year.contains(student_new_year.getMonth()) && 
                    dates_new_year.contains(student_new_year.getDay()) && 
                    dates_new_year.contains(student_new_year.getYear()) 
                )) {
                System.out.println("\t\tMethod ran but wrong output - " + (full / 2) + "/" + full);
                System.out.println("\t\t\tYour output with year change " + studentToString(student_new_year));
                System.out.println("\t\t\tExpected output with year change " + answer_new_year);
                points += full / 2;
            }
            else {
                points += full;
                System.out.println("\t\tCorrect " + studentToString(student_new_year) + " - " + full + "/" + full);                
            }


        }
        catch (Exception e) {
            System.out.println("\t\tError running CalendarDate.isLeapYear()");
        }
        System.out.println("\t\t" + points + "/" + (full * 3));

        return points;
    }

    public static int isLeapYearTest() {
        int points = 0;
        int full = 3;
        System.out.println("\tTesting isLeapYear()");
        SampleDate answer_no = new SampleDate(1797, 2, 3);
        SampleDate answer_yes = new SampleDate(1872, 11, 12);
        try {
            CalendarDate student_no = new CalendarDate(1797, 2, 3);
            CalendarDate student_yes = new CalendarDate(1872, 11, 12);
            if(!(answer_no.isLeapYear() == student_no.isLeapYear())) {
                System.out.println("\t\tMethod ran but wrong output - " + (full / 2) + "/" + full);
                System.out.println("\t\t\tYour output for year " + answer_no.getYear() + ": " + student_no.isLeapYear());
                System.out.println("\t\t\tExpected output for year " + answer_no.getYear() + ": " + answer_no.isLeapYear());
                points += full / 2;
            }
            else {
                points += full;
                System.out.println("\t\tCorrect " + student_no.isLeapYear() + " - " + full + "/" + full);                
            }
            if(!(answer_yes.isLeapYear() == student_yes.isLeapYear())) {
                System.out.println("\t\tMethod ran but wrong output - " + (full / 2) + "/" + full);
                System.out.println("\t\t\tYour output for year " + answer_yes.getYear() + ": " + student_yes.isLeapYear());
                System.out.println("\t\t\tExpected output for year " + answer_yes.getYear() + ": " + answer_yes.isLeapYear());
                points += full / 2;
            }
            else {
                points += full;
                System.out.println("\t\tCorrect " + student_yes.isLeapYear() + " - " + full + "/" + full);                
            }


        }
        catch (Exception e) {
            System.out.println("\t\tError running CalendarDate.isLeapYear()");
        }
        System.out.println("\t\t" + points + "/" + (full * 2));

        return points;
    }

    public static int getDayOfWeekTest() {
        int points = 0;
        int full = 6;
        int half = 2;

        System.out.println("\tTesting getDayOfWeek()");
        SampleDate answer = new SampleDate(1988, 3, 26);
        try {
            CalendarDate student = new CalendarDate(1988, 3, 26);
            String answerDay = answer.getDayOfWeek().toUpperCase();
            String studentDay = student.getDayOfWeek().replaceAll("\\s", "").toUpperCase();

            if(!answerDay.equalsIgnoreCase(studentDay)) {
                List<String> DAY_NAMES = new ArrayList<>();
                DAY_NAMES.add("SUNDAY");DAY_NAMES.add("MONDAY");DAY_NAMES.add("TUESDAY");
                DAY_NAMES.add("WEDNESDAY");DAY_NAMES.add("THURSDAY");DAY_NAMES.add("FRIDAY");DAY_NAMES.add("SATURDAY");
                int answerIndex = DAY_NAMES.indexOf(answerDay);        
                int studentIndex = DAY_NAMES.indexOf(studentDay);

                if(Math.abs(answerIndex - studentIndex) == 1 || Math.abs(answerIndex - studentIndex) == 6) {
                    System.out.println("\t\tOne day off - " + (full - 1) + "/" + full);
                    points += full - 1;
                }
                else if(Math.abs(answerIndex - studentIndex) == 2 || Math.abs(answerIndex - studentIndex) == 5) {
                    System.out.println("\t\tTwo days off - " + (full - 2) + "/" + full);
                    points += full - 2;
                }
                else if(Math.abs(answerIndex - studentIndex) == 3 || Math.abs(answerIndex - studentIndex) == 4) {
                    System.out.println("\t\tThree days off - " + (full - 3) + "/" + full);
                    points += full - 3;
                }
                else {
                    System.out.println("\t\tMethod ran but returned incorrect day of the week - " + (full / 2) + "/" + full);
                    points += (full / 2);
                }
                System.out.println("\t\t\tYour Output: " + studentDay);
                System.out.println("\t\t\tExpected Output: " + answerDay);
            }
            else {
                points += full;
                System.out.println("\t\tCorrect " + studentDay + " - " + full + "/" + full);
            }
        }
        catch (Exception e) {
            System.out.println("\t\tError running CalendarDate.getDayOfWeek()");
        }
        System.out.println("\t\t" + points + "/" + full);

        return points;
    }

    public static int getYearTest() {
        int points = 0;
        int full = 3;
        int half = 2;

        System.out.println("\tTesting getYear()");

        SampleDate answer = new SampleDate(1954, 3, 12);
        try {
            CalendarDate student = new CalendarDate(1954, 3, 12);
            if(answer.getYear() != student.getYear()) {
                if(answer.getYear() == student.getDay() || answer.getYear() == student.getMonth()) {
                    System.out.println("\t\tYear is correct but formatted incorrectly - " + half + "/" + full);
                    points += half;
                }
                else {
                    System.out.println("\t\tMethod ran but incorrect year returned - " + (full / 2) + "/" + full);
                    points += (full / 2);
                }
                System.out.println("\t\t\tYour Output: " + student.getYear());
                System.out.println("\t\t\tExpected Output: " + answer.getYear());
            }
            else {
                points += full;
                System.out.println("\t\tCorrect " + student.getYear() + " - " + full + "/" + full);
            }
        }
        catch (Exception e) {
            System.out.println("\t\tError running CalendarDate.getYear()");
        }
        System.out.println("\t\t" + points + "/" + full);

        return points;
    }

    public static int getMonthTest() {
        int points = 0;
        int full = 3;
        int half = 2;

        System.out.println("\tTesting getMonth()");

        SampleDate answer = new SampleDate(1952, 10, 22);
        try {
            CalendarDate student = new CalendarDate(1952, 10, 22);
            if(answer.getMonth() != student.getMonth()) {
                if(answer.getMonth() == student.getDay() || answer.getMonth() == student.getYear()) {
                    System.out.println("\t\tMonth is correct but formatted incorrectly - " + half + "/" + full);
                    points += half;
                }
                else {
                    System.out.println("\t\tMethod ran but incorrect month returned - " + (full / 2) + "/" + full);
                    points += (full / 2);
                }
                System.out.println("\t\t\tYour Output: " + student.getMonth());
                System.out.println("\t\t\tExpected Output: " + answer.getMonth());
            }
            else {
                points += full;
                System.out.println("\t\tCorrect " + student.getMonth() + " - " + full + "/" + full);
            }
        }
        catch (Exception e) {
            System.out.println("\t\tError running CalendarDate.getMonth()");
        }
        System.out.println("\t\t" + points + "/" + full);

        return points;
    }

    public static int getDayTest() {
        int points = 0;
        int full = 3;
        int half = 2;

        System.out.println("\tTesting getDay()");

        SampleDate answer = new SampleDate(1983, 5, 21);
        try {
            CalendarDate student = new CalendarDate(1983, 5, 21);
            if(answer.getDay() != student.getDay()) {
                if(answer.getDay() == student.getMonth() || answer.getDay() == student.getYear()) {
                    System.out.println("\t\tDay is correct but formatted incorrectly - " + half + "/" + full);
                    points += half;
                }
                else {
                    System.out.println("\t\tMethod ran but incorrect day returned - " + (full / 2) + "/" + full);
                    points += (full / 2);
                }
                System.out.println("\t\t\tYour Output: " + student.getDay());
                System.out.println("\t\t\tExpected Output: " + answer.getDay());
            }
            else {
                points += full;
                System.out.println("\t\tCorrect " + student.getDay() + " - " + full + "/" + full);
            }
        }
        catch (Exception e) {
            System.out.println("\t\tError running CalendarDate.getDay()");
        }
        System.out.println("\t\t" + points + "/" + full);

        return points;
    }

    public static int getDaysOld(BirthDateSolution solution, BirthDate student) {
        restoreOutput();
        int points = 0;
        int full = 3;
        int half = 2;

        SampleDate sd = new SampleDate(1988, 7, 12);
        System.out.println("\tTesting daysOld()");

        resetOutputStream();
        solution.daysOld(sd);
        String answer = baos.toString();
        resetOutputStream();
        String student_answer = "";
        try {
            sd = new SampleDate(1988, 7, 12);
            student.daysOld(sd);
            student_answer = baos.toString();
            resetOutputStream();
        }
        catch(Exception e){
            restoreOutput();
            System.out.println("Error running daysOld()");
        }
        restoreOutput();

        String student_num = "";
        String answer_key = extractRegexFromString("\\d+", answer);
        student_num = extractRegexFromString("\\d+", student_answer);

        if(!answer_key.equals(student_num)) {
            if(!student_num.equals("")) {
                System.out.println("\t\tMethod ran but incorrect value returned - " + half + "/" + full);
                    points += half;
            }
            else
                System.out.println("\t\tUnable to get value from method - 0/" + full);
            System.out.println("\t\t\tYour Output: " + student_num);
            System.out.println("\t\t\tExpected Output: " + answer_key);
        }
        else {
            System.out.println("\t\tCorrect " + student_num + " - " + full + "/" + full);
            points += full;
        }

        System.out.println("\t\t" + points + "/" + full);

        return points;
    }

    public static int getDaysUntilBirthday(BirthDateSolution solution, BirthDate student) {
        int points = 0;
        int full = 3;
        int half = 2;

        SampleDate sd = new SampleDate(1977, 7, 27);
        SampleDate sd_birthday = new SampleDate(1977,  Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        System.out.println("\tTesting daysUntilBirthday()");

        resetOutputStream();
        solution.daysUntilBirthday(sd);
        String answer = baos.toString();
        resetOutputStream();
        solution.daysUntilBirthday(sd_birthday);
        String answer_birthday = baos.toString();
        resetOutputStream();
        
        String student_answer = "";
        String student_answer_birthday = "";
        try {
            sd = new SampleDate(1977, 7, 27);
            student.daysUntilBirthday(sd);
            student_answer = baos.toString();
            resetOutputStream();
            sd_birthday = new SampleDate(1977,  Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
            student.daysUntilBirthday(sd_birthday);
            student_answer_birthday = baos.toString();
        }
        catch(Exception e){
            restoreOutput();
            System.out.println("Error running daysUntilBirthday()");
        }
        restoreOutput();
        String[] answer_key = new String[2];
        String[] student_answers = new String[2];
        answer_key[0] = extractRegexFromString("\\d+", answer);
        answer_key[1] = extractRegexFromString("happy birthday", answer_birthday).replaceAll("\\s", "").toUpperCase();
        student_answers[0] = extractRegexFromString("\\d+", student_answer);
        student_answers[1] = extractRegexFromString("happy birthday", student_answer_birthday).replaceAll("\\s", "").toUpperCase();

        // tests
        // student_answers[0] = "23";
        // student_answers[1] = null;

        for(int i = 0; i < answer_key.length; i++) {
            if(!answer_key[i].equals(student_answers[i])) {
                if(!student_answers[i].equals("")) {
                    System.out.println("\t\tMethod ran but incorrect value returned - " + half + "/" + full);
                        points += half;
                }
                else
                    System.out.println("\t\tUnable to get value from method - 0/" + full);
                System.out.println("\t\t\tYour Output: " + student_answers[i]);
                System.out.println("\t\t\tExpected Output: " + Arrays.toString(answer_key));
            }
            else {
                System.out.println("\t\tCorrect " + student_answers[i] + " - " + full + "/" + full);
                points += full;
            }
        }
        System.out.println("\t\t" + points + "/" + (full * 2));

        return points;
    }

    public static int getDetails(BirthDateSolution solution, BirthDate student) {
        restoreOutput();
        System.out.println("\tTesting details()");
        int points = 0;
        int full = 3;
        int half = 2;

        SampleDate test_sd = new SampleDate(2004, 11, 18);

        resetOutputStream();
        solution.details(test_sd);
        String solution_string = baos.toString();

        resetOutputStream();
        String student_answer = "";
        try {
            test_sd = new SampleDate(2004, 11, 18);
            student.details(test_sd);
            student_answer = baos.toString();
            restoreOutput();
        }
        catch(Exception e) {
            restoreOutput();
            System.out.println("\t\tError running details()");
        }

        String[] answer_key = new String[3];
        String[] student_answers = new String[3];
        String[] matches = {"\\d{4}/\\d{1,2}/\\d{1,2}",
                            "Monday?|Tuesday?|Wednesday?|Thursday?|Friday?|Saturday?|Sunday?",
                            "leap year?|leapyear?"
                            };

        for(int i = 0; i < answer_key.length; i++) {
            answer_key[i] = extractRegexFromString(matches[i], solution_string).replaceAll("\\s", "").toUpperCase();
            student_answers[i] = extractRegexFromString(matches[i], student_answer.replaceAll("\\s", "").toUpperCase());
        }
        // test values
        // student_answers[1] = "2004/21/18";
        // student_answers[0] = "THUR SDAY";
        // student_answers[2] = "";

        // assign the points
        for(int i = 0; i < student_answers.length; i++){
            if(!Arrays.asList(answer_key).contains(student_answers[i])) {
                if(!student_answers[i].equals("")) {
                    System.out.println("\t\tMethod ran but incorrect value returned - " + half + "/" + full);
                    points += half;
                }
                else
                    System.out.println("\t\tUnable to get value from method - 0/" + full);
                System.out.println("\t\t\tYour Output: " + student_answers[i]);
                System.out.println("\t\t\tExpected Output: " + Arrays.toString(answer_key));
            }
            else {
                System.out.println("\t\tCorrect " + student_answers[i] + " - " + full + "/" + full);
                points += full;
            }
        }
        System.out.println("\t\t" + points + "/" + (full * 3));

        return points;
    }

    public static int getBirthDateTest(BirthDateSolution solution, BirthDate student) {
        restoreOutput();
        System.out.println("\tTesting getBirthdate()");
        int points = 0;
        int full = 3;
        int half = 2;

        System.setIn(bais("2 3 1945"));
        resetOutputStream();
        SampleDate solution_sd = solution.getBirthdate();
        resetInputToken();

        try{
            SampleDate student_sd = student.getBirthdate();
            restoreOutput();
            // check day getDay()
            if(student_sd.getDay() != solution_sd.getDay()) {
                if(student_sd.getDay() == solution_sd.getMonth() || student_sd.getDay() == solution_sd.getYear()) {
                    System.out.println("\t\tDay is correct but in the wrong format - " + half + "/" + full);
                    points += half;
                }
                else
                    System.out.println("\t\tIncorrect Day - 0/" + full);

                System.out.println("\t\t\tYour output: " + student_sd);
                System.out.println("\t\t\tExpected output: " + solution_sd);
            }
            else {
                System.out.println("\t\tCorrect Day - " + full + "/" + full);
                points += full;
            }

            // check month getMonth()
            if(student_sd.getMonth() != solution_sd.getMonth()) {
                if(student_sd.getMonth() == solution_sd.getDay() || student_sd.getMonth() == solution_sd.getYear()) {
                    System.out.println("\t\tMonth is correct but in the wrong format - " + half + "/" + full);
                    points += half;
                }
                else
                    System.out.println("\t\tIncorrect Month - 0/" + full);

                System.out.println("\t\t\tYour output: " + student_sd);
                System.out.println("\t\t\tExpected output: " + solution_sd);
            }
            else {
                System.out.println("\t\tCorrect Month - " + full + "/" + full);
                points += full;
            }
            // check year getYear()
            if(student_sd.getYear() != solution_sd.getYear()) {
                if(student_sd.getYear() == solution_sd.getDay() || student_sd.getYear() == solution_sd.getMonth()) {
                    System.out.println("\t\tYear is correct but in the wrong format - " + half + "/" + full);
                    points += half;
                }
                else
                    System.out.println("\t\tIncorrect Year - 0/" + full);

                System.out.println("\t\t\tYour output: " + student_sd);
                System.out.println("\t\t\tExpected output: " + solution_sd);
            }
            else {
                System.out.println("\t\tCorrect Year - " + full + "/" + full);
                points += full;
            }
        }
        catch(Exception e) {
            restoreOutput();
            System.out.println("\t\tUnable to run getBirthdate()");
        }

        System.out.println("\t\t" + points + "/" + (full * 3));
        return points;
    }

    public static int mainTest() throws Exception {
        System.setIn(bais("12 17 1985"));
        
        // main() answer
        BirthDateSolution.main(null);
        System.out.flush();
        System.setOut(originalOutput);
        String answer_main_string = baos.toString();
        System.out.println(answer_main_string);

        // reset input/output
        baos.reset();
        System.setOut(output);
        System.in.reset();
        
        // main() student
        BirthDate.main(null);
        System.out.flush();
        System.setOut(originalOutput);
        String student_main_string = baos.toString();
        System.out.println(student_main_string);

        // get results
        String[] answer_main_results = mainMatcher(answer_main_string);
        String[] student_main_results = mainMatcher(student_main_string);

        List<String> answerList = Arrays.asList(answer_main_results);
        List<String> studentList = Arrays.asList(student_main_results);

        // Date
        if(studentList.contains(answer_main_results[0]))
            System.out.println("+1!");
        // Day

        // Days Until Birthday

        // Days Old 

        return 0;
    }

    public static String[] mainMatcher(String answer) {
        String [] results = new String[4];
        Pattern main_pattern = Pattern.compile("(.*?)" +
                                                    "(\\d{4}/\\d{1,2}/\\d{1,2})" + "(.*?)" +
                                                    "(Monday?|Tuesday?|Wednesday?|Thursday?|Friday?|Saturday?|Sunday?)" + "(.*?)" +
                                                    "(\\d{1,3})" + "(.*?)" +
                                                    "(\\d+)" + "(.*)", 
                                                     Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        Matcher matcher = main_pattern.matcher(answer);
        matcher.find();
        try{
            results[0] = matcher.group(2);
        }
        catch (Exception e) {
            System.out.println("Couldn't find date in main output - should be in the format YYYY/MM/DD");
        }
        try{
            results[1] = matcher.group(4);
        }
        catch (Exception e) {
            System.out.println("Couldn't find day in main output - looking for Monday, Tuesday,...");
        }
        try{
            results[2] = matcher.group(6);
        }
        catch (Exception e) {
            System.out.println("Couldn't find days until birthday in main output - should be 1 - 3 digit number");
        }
        try{
            results[3] = matcher.group(8);
        }
        catch (Exception e) {
            System.out.println("Couldn't find days old in main output - should be number with more than 3 digits");
        }
        return results;
    }

    /*  finds the regex within the doc string and returns that value.
        regex should be the regex string wishing to be found in doc
        this method wraps the regex in .*?( regex ).*
    */
    public static String extractRegexFromString(String regex, String doc) {
        if(doc.equals(""))
            return "";
        String r = ".*?(" + regex + ").*"; 
        String found;
        Pattern pattern = Pattern.compile(r, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(doc);
        try{
            matcher.find();
            found = matcher.group(1);
        }
        catch(Exception e){
            found = "";
        }
        return found;
    }

    public static void resetInputToken() {
        try {
            System.in.reset();
        }
        catch (Exception e){};     
    }

    public static String studentToString(CalendarDate c) {
        return c.getYear() + "/" + c.getMonth() + "/" + c.getDay();
    }

    /* prepares output to be captured in ByteArrayOutputStream output
        use baos.toString()
    */
    public static void resetOutputStream() {
        baos.reset();
        System.setOut(output);
    }

    public static void restoreOutput() {
        System.setOut(originalOutput);
    }

    /* gives System.in a string for input
    */
    public static ByteArrayInputStream bais(String inpt) {
        try {
            return new ByteArrayInputStream(inpt.getBytes("UTF-8"));
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
/*
    // public static void stealOutput() {
    //     System.setOut(new PrintStream(new ByteArrayOutputStream()));
    // }

    // public static void returnOutput() {
    //     System.setOut(originalPrintStream);
    // }

    // // accessing private methods!
    // Class[] cArg = new Class[1];
    // cArg[0] = SampleDate.class;

    // Method getBirthdate = BirthDateSolution.class.getDeclaredMethod("getBirthdate");
    // Method details = BirthDateSolution.class.getDeclaredMethod("details", cArg);
    // Method daysUntilBirthday = BirthDateSolution.class.getDeclaredMethod("daysUntilBirthday", cArg);
    // Method daysOld = BirthDateSolution.class.getDeclaredMethod("daysOld", cArg);

    // getBirthdate.setAccessible(true);
    // details.setAccessible(true);
    // daysUntilBirthday.setAccessible(true);
    // daysOld.setAccessible(true);

    // // System.setIn(originalInput);
    // System.setIn(bais("7 12 1988"));
    // SampleDate returned = (SampleDate)getBirthdate.invoke(bds);
    // System.out.println();
    
    // details.invoke(bds, returned);
*/
}