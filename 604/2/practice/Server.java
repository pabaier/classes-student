import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println(" Server is Running ");
        ServerSocket mysocket = new ServerSocket(5555);

        while(true) {
            Socket connectionSocket = mysocket.accept();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            writer.write("*** Welcome to the Calculation Server (Addition Only) ***\n");
            writer.write("*** Please type in the first number and press Enter: \n");
            writer.flush();
            String data1 = reader.readLine().trim();

            writer.write("*** Please type in the second number and press Enter: \n");
            writer.flush();
            String data2 = reader.readLine();
            writer.write("x");
            writer.flush();

            int num1 = Integer.parseInt(data1);
            int num2 = Integer.parseInt(data2);

            int result = num1 + num2;

            writer.write("\r\n=== Result is: " + result);
            writer.flush();
            connectionSocket.close();
        }
    }
}