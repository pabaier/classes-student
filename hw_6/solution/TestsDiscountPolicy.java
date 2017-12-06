import edu.cofc.grader.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestsDiscountPolicy {
    public static class Constructor extends SingleTest{
        public void exec() {
            System.out.print(indent() + "Abstract? - ");
            try{
                DiscountPolicy test = new DiscountPolicy();
            }
            catch(Throwable t) {
                try{
                    DiscountPolicy test = new DiscountPolicy(null);
                }
                catch(Throwable u) {
                    try{
                        DiscountPolicy test = new DiscountPolicy(null, null);
                    }
                    catch(Throwable v) {
                        System.out.println(C.CORRECT + "yes!");
                    }

                }
            }
        }

    }


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

    // returns a file as a string
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
        return totalFile.toString();
    }
}