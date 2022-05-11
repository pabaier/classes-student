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
            Scanner in = new Scanner(System.in);
            String input = "";
            Socket socketClient = new Socket("localhost", 5555);
            System.out.println("Client: Connection Established");

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

            String serverMsg;
            // writer.write("8");
            // writer.newLine();
            // writer.write("10");
            // writer.newLine();
            // writer.flush();
            System.out.println("Server: " + reader.readLine());
            while((serverMsg = reader.readLine()) != null) {
                if(!serverMsg.equals("x")){
                    System.out.println("ServerA: " + serverMsg);
                    input = in.nextLine();
                    writer.write(input);
                    writer.newLine();
                    writer.flush();
                }
                else{
                    break;
                }
            }
            System.out.println("Server: " + reader.readLine());
            socketClient.close();
        }catch(Exception e) {e.printStackTrace();}
    }
}