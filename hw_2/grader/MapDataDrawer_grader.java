import java.awt.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NoSuchMethodError;
import java.lang.ArrayIndexOutOfBoundsException;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MapDataDrawer_grader
{
    // note: test data should be 10 x 10

    public static int points = 0;
    public static int totalPoints = 100;
    public static int sectionPoints = 18;
    public static int width = 10;
    public static int height = 10;
    public static MapDataDrawer map;
    public static MapDataDrawer_solution solution;
    public static PrintStream originalPrintStream = System.out;
    
    public static void main(String[] args) throws Exception{

/*
        String lastName = args[0].substring(0,args[0].length() - 2);
        String fileString = getFileString("MapDataDrawer.java");
        Pattern p = Pattern.compile("(?i).*?" + lastName + ".*");
        Matcher m = p.matcher(fileString);
        if(m.find()) {
            System.out.println("\t\t+5" + " Name in file - /5");
            points += 5;
        }
        else {
            System.out.println("\t\t+0" + " Name missing from file - /5");
        }
        
        System.out.println("\t\t+5" + " Submitted Properly - /5");
        points += 5;

        //construct DrawingPanel, and get its Graphics context
        stealOutput();


        DrawingPanel panel = new DrawingPanel(width, height);
        panel.setVisible(false);
        Graphics g = panel.getGraphics();
        // action event to autoexit panel
        ActionEvent a = new ActionEvent(panel, 0, "Exit");

        restoreOutput();

        String[] test_data = {"test_Data_1.dat",
                                "test_Data_2.dat", 
                                "test_Data_3.dat", 
                                "test_Data_4.dat",
                                "test_Data_5.dat" };
        int[] starting_row = {0,3,5,7,8};
        String[] test_cases = {"Testing Given Data Set",
                                "Testing Top Row Path",
                                "Testing Bottom Row Path",
                                "Testing When Choices are the Same",
                                "Testing Random Choice"};
        
        for(int i = 0; i < test_data.length; i++) {
            int loopTotal = 0;
            map = new MapDataDrawer(test_data[i], 10, 10);
            solution = new MapDataDrawer_solution(test_data[i], 10, 10);
            System.out.println();
            System.out.println(test_cases[i]);

            // min test
            loopTotal += minTest();
            // max test
            loopTotal += maxTest();
            // minRow test
            loopTotal += minRowTest();
            // map.drawMap(g);
            // drawLowestElevationPath test
            loopTotal += drawLowestElevPathTest(g, starting_row[i]);
            // indexOfLowestElevPath test
            loopTotal += indexOfLowestElevPathTest(g);
            restoreOutput();
            // draw a greedy path test
            // g.setColor(Color.WHITE); //can set the color of the 'brush' before drawing, then method doesn't need to worry about it

            //Test Step 5 - draw the best path   
            // g.setColor(Color.RED);
            // int bestRow = map.indexOfLowestElevPath(g);

            // g.setColor(Color.GREEN);
            // totalChange = map.drawLowestElevPath(g, bestRow);
            System.out.println("\tsection total: " + loopTotal + "/" + sectionPoints);
        }
        System.out.println("Total Score: " + points + "/" + totalPoints);
        // exit panel
        panel.actionPerformed(a);
        System.exit(0);
*/
    }

    public static int minTest() {
        int outOf = 2;
        int p = 0;
        System.out.println("\tfindMin() test - /" + outOf);

        stealOutput();
        int min_solution = solution.findMin();
        restoreOutput();
        int min = 0;
        try {
            stealOutput();
            min = map.findMin();
            restoreOutput();
            if (min == min_solution) {
                System.out.println("\t\t+" + outOf + " Passed!");
                points += outOf;
                p +=  outOf;
            }
            else {
                System.out.println("\t\t+" + (outOf/2) + " for running method");
                System.out.println("\t\t Values Incorrect");
                System.out.println("\t\tExpected Value: " + min_solution);
                System.out.println("\t\tReturned Value: " + min);
                points += (outOf/2);
                p +=  (outOf/2);
            }
        }
        catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
            System.out.println("\t\t+0 Error running test");
        }
        return p;
    }

    public static int maxTest() {
        int outOf = 2;
        int p = 0;
        System.out.println("\tfindMax() test - /" + outOf);

        stealOutput();
        int solution_value = solution.findMax();
        restoreOutput();
        
        int submission_value = 0;
        try {
            stealOutput();
            submission_value = map.findMax();
            restoreOutput();
            
            if (submission_value == solution_value) {
                System.out.println("\t\t+" + outOf + " Passed!");
                points += outOf;
                p += outOf;
            }
            else {
                System.out.println("\t\t+" + (outOf/2) + " for running method");
                System.out.println("\t\t Values Incorrect");
                System.out.println("\t\tExpected Value: " + solution_value);
                System.out.println("\t\tReturned Value: " + submission_value);
            }
        }
        catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
            System.out.println("\t\t+0 Error running test");
        }
        return p;
    }

    public static int minRowTest() {
        int outOf = 2;
        int p = 0;

        Random rand = new Random();
        int r = rand.nextInt(width);
        System.out.println("\tindexOfMinRow() test - /" + outOf);
        
        stealOutput();
        int solution_value = solution.indexOfMinRow(r);
        restoreOutput();
        
        int submission_value = 0;
        try {
            stealOutput();
            submission_value = map.indexOfMinRow(r);
            restoreOutput();

            if (submission_value == solution_value) {
                System.out.println("\t\t+" + outOf + " Passed!");
                points += outOf;
                p+= outOf;
            }
            else {
                System.out.println("\t\t+" + (outOf/2) + " for running method");
                System.out.println("\t\t Values Incorrect");
                System.out.println("\t\tExpected Value: " + solution_value);
                System.out.println("\t\tReturned Value: " + submission_value);
            }
        }
        catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
            System.out.println("\t\t+0 Error running test");
        }
        return p;
    }

    public static int drawLowestElevPathTest(Graphics g, int minRow) {
        int outOf = 9;
        int p = 0;

        System.out.println("\tdrawLowestElevPath() test - /" + outOf);

        // special case for the last test with random paths - when testing row 8, the last test in the array...

        if(minRow == 8) {
            int[] possibleValues = new int[2];
            possibleValues[0] = solution.drawLowestElevPath(g, minRow);

            // get possible outputs (should only be 2 options - check test_Data_5 paths)
            for(int i = 0; i < 20; i++) {
                int new_value = solution.drawLowestElevPath(g, minRow);
                if(new_value != possibleValues[0])
                    possibleValues[1] = new_value;
            }

            boolean firstValue = false;
            boolean secondValue = false;
            boolean otherValue = false;
            boolean error = false;

            for(int i = 0; i < 20; i++) {
                try {
                    stealOutput();
                    int submission_value = map.drawLowestElevPath(g, minRow);
                    restoreOutput();
                    
                    if (submission_value == possibleValues[0]) {
                        firstValue = true;
                    }
                    else if (submission_value == possibleValues[1]) {
                        secondValue = true;
                    }
                    else {
                        otherValue = true;
                    }
                }
                catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
                    System.out.println("\t\t Error running test");
                    error = true;

                }
            }

            // tally the score
            if (firstValue && secondValue && !otherValue) {
                System.out.println("\t\t+" + outOf + " Passed! Two of two random paths taken");
                points += outOf;
                p += outOf;
            }
            else if (firstValue || secondValue && !otherValue) {
                System.out.println("\t\t+" + ((outOf * 2)/3) + " One of two correct random paths taken");
                p += (outOf * 2)/3;
                points += (outOf * 2)/3;
            }
            else if (firstValue || secondValue && otherValue) {
                System.out.println("\t\t+" + ((outOf / 2) + 1) + " One of two random paths and one wrong path taken");
                p += ((outOf / 2) + 1);
                points += ((outOf / 2) + 1);
            }
            else if (otherValue && !error) {
                System.out.println("\t\t+" + (outOf/2) + " for running method");
                System.out.println("\t\t Values Incorrect");
            }
            else if (error) {
                System.out.println("\t\t+0 Error running test");
            }

            return p;
        }
        else {
            stealOutput();
            int solution_value = solution.drawLowestElevPath(g, minRow);
            restoreOutput();

            int submission_value = 0;
            try {
                stealOutput();
                submission_value = map.drawLowestElevPath(g, minRow);
                restoreOutput();
                
                if (submission_value == solution_value) {
                    System.out.println("\t\t+" + outOf + " Passed!");
                    points += outOf;
                    p += outOf;
                }
                else {
                    points += (outOf/2);
                    p += (outOf/2);
                    System.out.println("\t\t+" + (outOf/2) + " for running method");
                    System.out.println("\t\t Values Incorrect");
                    System.out.println("\t\tExpected Value: " + solution_value);
                    System.out.println("\t\tReturned Value: " + submission_value);
                }
            }
            catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
                System.out.println("\t\t+0 Error running test");
            }
            return p;
        }
    }

    public static int indexOfLowestElevPathTest(Graphics g) {
        int outOf = 3;
        int p = 0;

        System.out.println("\tindexOfLowestElevPath() test - /" + outOf);

        stealOutput();
        int solution_value = solution.indexOfLowestElevPath(g);
        restoreOutput();
        int submission_value = 0;
        try {
            stealOutput();
            submission_value = map.indexOfLowestElevPath(g);
            restoreOutput();
            
            if (submission_value == solution_value) {
                System.out.println("\t\t+" + outOf + " Passed!");
                points += outOf;
                p += outOf;
            }
            else {
                points += (outOf/2);
                p += (outOf/2);
                System.out.println("\t\t+" + (outOf/2) + " for running method");
                System.out.println("\t\t Values Incorrect");
                System.out.println("\t\tExpected Value: " + solution_value);
                System.out.println("\t\tReturned Value: " + submission_value);
            }
        }
        catch (NoSuchMethodError | ArrayIndexOutOfBoundsException e) {
            restoreOutput();
            System.out.println("\t\t+0 Error running test");
        }
        return p;
    }

    public static void stealOutput() {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));

    }

    public static void restoreOutput() {
        System.setOut(originalPrintStream);
    }

    public static String getFileString(String name) {
        StringBuilder fileContents = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            String line;
            while((line = reader.readLine()) != null) {
                fileContents.append(line);
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println("File not found: " + name);
        }

        
        return fileContents.toString();
    }
}