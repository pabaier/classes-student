package edu.cofc.grader;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.io.IOException;

/**
 * Utils is a utility class with various static methods that are
 * useful when grading
 * @author Paul Baier
 */

public class Utils {

    /**
     * Gets the contents of a file as a String
     * @param path file path to the file
     * @return the contents of the file as a String, null if IOException
     */
    public static String getFileText(String path) {
        Path file = Paths.get(path);
        StringBuilder totalFile = new StringBuilder();
        Stream<String> lines;
        try {
            lines = Files.lines(file);
        }
        catch (IOException ex) {
            return null;
        }
        lines.forEach(s -> totalFile.append(s));
        lines.close();
        return totalFile.toString();
    }

    /**
     * Searches through the doc String for the regular expression
     * @param regex a regular expression being searched for within doc
     * @param doc the string to search
     * @@return true if regex is found in doc, otherwise false
     */
    // searches through the doc string for regex
    public static boolean isRegexInString(String regex, String doc) {
        if(doc.equals(""))
            return false;
        String r = ".*?(" + regex + ").*";
        try {
            Pattern pattern = Pattern.compile(r, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Matcher matcher = pattern.matcher(doc);
            return matcher.find();
        }
        catch(Exception e) {
            return false;
        }
    }
}