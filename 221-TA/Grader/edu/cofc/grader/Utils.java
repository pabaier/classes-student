package edu.cofc.grader;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.lang.reflect.Field;
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

    /**
     * Finds and returns a field of the desired type in the given class.
     * Returns null if not found
     * @param given the class to search
     * @param desired the target class being searched for
     * @return the field of the desired type
     */
    public static Field getFieldOfType(Class given, Class desired) {
        Field[] allFields = given.getDeclaredFields();
        for(Field f : allFields) {
            if(f.getType().equals(desired))
                return f;
        }
        return null;
    }
}