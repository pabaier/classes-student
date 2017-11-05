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
        System.setOut(output);

        // test classes
        System.out.println("BirthDate Class Tests:");
        BirthDateSolution birthDate_Solution = new BirthDateSolution();
        BirthDate birthDate_Student = new BirthDate();
        
        // main() test
        // mainTest();

        // getBirthdate() test
        totalPoints += getBirthDateTest(birthDate_Solution, birthDate_Student);

        // details() test
        totalPoints += getDetails(birthDate_Solution, birthDate_Student);

        // daysUntilBirthday test
        // getBirthDateTest(birthDate_Solution, birthDate_Student);

        // daysOld test
        // getBirthDateTest(birthDate_Solution, birthDate_Student);
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
            student.details(test_sd);
            student_answer = baos.toString();
            restoreOutput();
        }
        catch(Exception e) {
            restoreOutput();
            System.out.println("\t\tError running details() method");
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
                    System.out.println("\t\tUnable to get value from method = 0/" + full);
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

    /*  finds the regex within the doc string and returns that value.
        regex should be the regex string wishing to be found in doc
        this method wraps the regex in .*?( regex ).*
    */
    public static String extractRegexFromString(String regex, String doc) {
        String r = ".*?(" + regex + ").*"; 
        String found;
        Pattern pattern = Pattern.compile(r, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(doc);
        try{
            matcher.find();
            found = matcher.group(1);
        }
        catch(Exception e){
            found = null;
        }
        return found;
    }

    public static int getBirthDateTest(BirthDateSolution solution, BirthDate student) {
        restoreOutput();
        System.out.println("\tTesting getBirthdate()");
        int points = 0;
        int full = 3;
        int half = 2;

        resetInputOutput();
        System.setIn(bais("2 3 1945"));
        SampleDate solution_sd = solution.getBirthdate();
        resetInputOutput();
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

    public static void resetInputToken() {
        try {
            System.in.reset();
        }
        catch (Exception e){};     
    }

    public static void resetOutputStream() {
        baos.reset();
        System.setOut(output);
    }

    /*  resets the input token back to the beginning and
        clears the byte array output stream
    */
    public static void resetInputOutput() {
        baos.reset();
        System.setOut(output);
        try {
            System.in.reset();
        }
        catch (Exception e){};
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