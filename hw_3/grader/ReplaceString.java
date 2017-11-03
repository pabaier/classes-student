import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.charset.*;
/*
    This is a small script that goes into the Birthdate.java file and replaces all of
    the words "private" with the word "public" so that these methods can be unit tested.
    Consider taking command line arguments to generalize file_name, search_word, replacement_word.

    only works with Java 7 and higher.
*/


public class ReplaceString {
    public static void main(String[] args) throws Exception {
        String file_name = "BirthDate.java";
        String search_word = "private";
        String replacement_word = "public";

        Path path = Paths.get(file_name);
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll(search_word, replacement_word);
        Files.write(path, content.getBytes(charset));
    }
}