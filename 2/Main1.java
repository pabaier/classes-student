import java.net.*;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws Exception {
        URL web = new URL("http://153.9.205.25/~CSIS604h/");
        URLConnection webconnect = web.openConnection();
        Scanner input = new Scanner(webconnect.getInputStream());

        while (input.hasNext())
            System.out.println(input.nextLine());
        input.close();
    }
}