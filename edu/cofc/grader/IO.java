package edu.cofc.grader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * IO is a class that contains static utility methods used to capture student output
 * and set input to test Scanners and various input streams.
 * @author Paul Baier
 */

public class IO {

    // save original input/output
    public static final InputStream originalInput = System.in;
    public static final PrintStream originalOutput = System.out;
    
    // input setup
    public static ByteArrayInputStream input;

    // output setup
    // the printstream is needed for system.out
    // but the data is actually written to the bytearrayoutputstream
    // get it with baos.toString()
    public static ByteArrayOutputStream baos = new ByteArrayOutputStream();
    public static PrintStream output = new PrintStream(baos);
    
    
    // FileInputStream in = new FileInputStream(new File("input"));

    /**
     * Starts capturing output from System.out
     * Use {@link #getOutput()} to retrieve output
     */
    public static void startOutputCapture() {
        baos.reset();
        System.setOut(output);
    }

    /**
     * Gets the output from the outputstream
     * then resets the outputstream 
     * Must start capturing output before use - see {@link #startOutputCapture()}
     * @return The output captured 
     */
    public static String getOutput() {
        String out = baos.toString();
        baos.reset();
        return out;
    }

    /**
     * Resets any output stored in the output stream
     */
    public static void clearOutput() {
        baos.reset();
    }

    /**
     * Restores System.out to its original printstream
     */
    public static void restoreOutput() {
        System.setOut(originalOutput);
    }

    /**
     * Restores System.in to its original inputstream
     */
    public static void restoreInput() {
        System.setIn(originalInput);
    }

    /**
     * Sets the input System.in
     * @param in the value to be passed as input
     */
    public static void setInput(String in) {
        try {
            System.setIn(new ByteArrayInputStream(in.getBytes("UTF-8")));
        }
        catch(Exception e) {}
    }

    /* prepares output to be captured in ByteArrayOutputStream output
        use baos.toString()
    */
    public static void resetOutputStream() {
        baos.reset();
        System.setOut(output);
    }

    /* gives System.in a string for input
     * System.setIn(bais("2 3 1945"));
    */
    // public static ByteArrayInputStream bais(String inpt) {
    //     try {
    //         return new ByteArrayInputStream(inpt.getBytes("UTF-8"));
    //     }
    //     catch (Exception e) {
    //         System.out.println(e);
    //         return null;
    //     }
    // }

    /**
     * Disables output from System.out. To reenable use {@link #restoreOutput()}
     */
    public static void stealOutput() {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }
}