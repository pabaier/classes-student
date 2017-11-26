package edu.cofc.grader;

/**
 * C provides set of constant ANSI color codes used to color Bash output.
 * The default is for colors to be off.
 * @author Paul Baier
 */
public class C {

    public static final String RESET_VALUE = "\u001B[0m";
    
    public static final String BLACK = "\u001b[30m";
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String BLUE = "\u001b[34m";
    public static final String MAGENTA = "\u001b[35m";
    public static final String CYAN = "\u001b[36m";
    public static final String WHITE = "\u001b[37m";

    public static final String BRIGHT_BLACK = "\u001b[30m;1m";
    public static final String BRIGHT_RED = "\u001b[31m;1m";
    public static final String BRIGHT_GREEN = "\u001b[32m;1m";
    public static final String BRIGHT_YELLOW = "\u001b[33m;1m";
    public static final String BRIGHT_BLUE = "\u001b[34m;1m";
    public static final String BRIGHT_MAGENTA = "\u001b[35m;1m";
    public static final String BRIGHT_CYAN = "\u001b[36m;1m";
    public static final String BRIGHT_WHITE = "\u001b[37m;1m";

    public static final String BACKGROUND_BLACK = "\u001b[40m";
    public static final String BACKGROUND_RED = "\u001b[41m";
    public static final String BACKGROUND_GREEN = "\u001b[42m";
    public static final String BACKGROUND_YELLOW = "\u001b[43m";
    public static final String BACKGROUND_BLUE = "\u001b[44m";
    public static final String BACKGROUND_MAGENTA = "\u001b[45m";
    public static final String BACKGROUND_CYAN = "\u001b[46m";
    public static final String BACKGROUND_WHITE = "\u001b[47m";

    public static final String BACKGROUND_BRIGHT_BLACK = "\u001b[40m;1m";
    public static final String BACKGROUND_BRIGHT_RED = "\u001b[41m;1m";
    public static final String BACKGROUND_BRIGHT_GREEN = "\u001b[42m;1m";
    public static final String BACKGROUND_BRIGHT_YELLOW = "\u001b[43m;1m";
    public static final String BACKGROUND_BRIGHT_BLUE = "\u001b[44m;1m";
    public static final String BACKGROUND_BRIGHT_MAGENTA = "\u001b[45m;1m";
    public static final String BACKGROUND_BRIGHT_CYAN = "\u001b[46m;1m";
    public static final String BACKGROUND_BRIGHT_WHITE = "\u001b[47m;1m";

    public static final String BOLD = "\u001b[1m";
    public static final String UNDERLINE = "\u001b[4m";
    public static final String REVERSED = "\u001b[7m";

    public static String RESET = "";
    public static String CORRECT = "";
    public static String PARTCORRECT = "";
    public static String INCORRECT = "";
    public static String TITLE = "";
    public static String RESULT = "";

    public static String[] TITLES = {""};
    public static String[] RESULTS = {""};

    /**
     * Sets the ANSI color code values for results levels
     * @param colors a string array of ANSI color codes
     */
    public static void setResultsArray(String[] colors) {
        RESULTS = colors;
    }
    /**
     * Sets the ANSI color code values for title levels
     * @param colors a string array of ANSI color codes
     */
    public static void setTitlesArray(String[] colors) {
        TITLES = colors;
    }
    /**
     * Sets the ANSI color code value of Reaet
     * @param toggle true sets RESET to ANSI reset value,
     * false sets RESET to an empty string (default)
     */
    public static void setReset(boolean toggle) {
        if(toggle)
            RESET = RESET_VALUE;
        else
            RESET = "";
    }
    /**
     * Sets the ANSI color code value of RESULT
     * @param ansi the ANSI color code
     */
    public static void setResult(String ansi) {
        RESULT = ansi;
    }
    /**
     * Sets the ANSI color code value of TITLE
     * @param ansi the ANSI color code
     */
    public static void setTitle(String ansi) {
        TITLE = ansi;
    }
    /**
     * Sets the ANSI color code value of INCORRECT
     * @param ansi the ANSI color code
     */
    public static void setIncorrect(String ansi) {
        INCORRECT = ansi;
    }
    /**
     * Sets the ANSI color code value of PARTCORRECT
     * @param ansi the ANSI color code
     */
    public static void setPartCorrect(String ansi) {
        PARTCORRECT = ansi;
    }
    /**
     * Sets the ANSI color code value of CORRECT
     * @param ansi the ANSI color code
     */
    public static void setCorrect(String ansi) {
        CORRECT = ansi;
    }
    /**
     * Toggle colors to be on or off
     * @param toggle true turns colors on, false turns colors off
     */
    public static void colors(boolean toggle) {
        if(toggle) {
            RESET = RESET_VALUE;
            CORRECT = GREEN;
            PARTCORRECT = BLUE;
            INCORRECT = RED;
            TITLE = MAGENTA;
            RESULT = CYAN;
            TITLES = new String[] {BLUE, MAGENTA, CYAN};
            RESULTS = new String[] {BACKGROUND_CYAN + YELLOW + BOLD,
                        BACKGROUND_YELLOW + BLUE,
                        BACKGROUND_MAGENTA + WHITE + BOLD};
        }
        else {
            RESET = "";
            CORRECT = "";
            PARTCORRECT = "";
            INCORRECT = "";
            TITLE = "";
            RESULT = "";
            TITLES = new String[] {""};
            RESULTS = new String[] {""};
        }
    }

}