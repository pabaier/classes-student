import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println(" Server is Running ");
        ServerSocket mysocket = new ServerSocket(5555);

        while(true) {
            Socket connectionSocket = mysocket.accept();
            ObjectOutputStream writer = new ObjectOutputStream(connectionSocket.getOutputStream());
            writer.flush();
            ObjectInputStream reader = new ObjectInputStream(connectionSocket.getInputStream());
            writer.writeObject("*** Welcome to the Calculation Server (Addition Only) ***\n");
            writer.flush();
            writer.writeObject("*** Please type in the first number and press Enter: \n");
            writer.flush();
            String data1 = (String)reader.readObject();
            writer.writeObject("*** Please type in the second number and press Enter: \n");
            writer.flush();
            String data2 = (String)reader.readObject();


            int num1 = Integer.parseInt(data1);
            int num2 = Integer.parseInt(data2);

            int result = num1 + num2;

            writer.writeObject("\r\n=== Result is: " + result);
            writer.flush();
            connectionSocket.close();
        }
    }
}