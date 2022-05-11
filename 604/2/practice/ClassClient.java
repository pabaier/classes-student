import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            String input = "";
            Scanner in = new Scanner(System.in);
            Socket socketClient = new Socket("localhost", 5555);
            System.out.println("Client: "+"Connection Established");
            ObjectOutputStream writer = new ObjectOutputStream(socketClient.getOutputStream());
            ObjectInputStream reader = new ObjectInputStream(socketClient.getInputStream());
            writer.flush();
            String serverMsg;
            // writer.writeObject("8");
            // writer.flush();
            // writer.writeObject("10");
            // writer.flush();
            while((serverMsg = (String)reader.readObject()) != null) {
                System.out.println("Server: " + serverMsg);
                input = in.nextLine();
                writer.writeObject(input);
            }
        }catch(Exception e) {//e.printStackTrace();
        }
    }
}