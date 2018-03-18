import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;
import java.net.*;
import static java.lang.Math.toIntExact;

public class RequestThread extends Thread {
    private int index;
    private String initialState;
    private String goalState;
    private HashMap<Integer, String> solutions; // <index, solution>
    private String ipAddress;

    RequestThread(
        int index,
        String initialState, 
        String goalState, 
        HashMap<Integer, String> solutions,
        String ipAddress)
    {
        this.index = index;
        this.initialState = initialState;
        this.goalState = goalState;
        this.solutions = solutions;
        this.ipAddress = ipAddress;
    }

    public void run() {
        try {
            getSolutionFromServer();
        } catch(Exception e){}
    }

    /** 
     * connect to server
     * send index, initialState, goalState to server as Json
     * {"id":1234, "initial":"0123456789", "goal":"1203456789"}
     * eg: Here      - writer.write(JSON)
     *     In server - reader.readLine()
     * eg: writer.write(JSON)
     * receive from server index, solution as Json
     * eg: In server - writer.write(JSON)
     *     Here      - reader.readLine()
     * {"id":1234, "solution":"01234567802345678120345678"}
     */
    synchronized public void getSolutionFromServer() throws Exception {
        Socket socketClient = new Socket(ipAddress, 5555);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
        writer.flush();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        JSONObject infoToServer = new JSONObject();
        infoToServer.put("id", index);
        infoToServer.put("initial", initialState);
        infoToServer.put("goal", goalState);

        // send server info
        writer.write(infoToServer.toJSONString());
        writer.newLine();
        writer.flush();
        
        // read server info
        String tempInfo = reader.readLine(); // WILL THIS WAIT FOR THE WORK TO BE DONE?
        JSONParser parser = new JSONParser();
        Object temp = parser.parse(tempInfo);
        JSONObject infoFromClient = (JSONObject)temp;

        long indexTemp = (long)infoFromClient.get("id");
        int index = toIntExact(indexTemp);
        String solution = (String)infoFromClient.get("solution");

        solutions.put(index, solution);
        System.out.println(index + ": ");
        printSolution(solution);
    }

    private static void printSolution(String solution){
        char[] charSol = solution.toCharArray();
        System.out.print("\t");
        for(int i = 0; i < charSol.length; i++) {
            System.out.print(charSol[i]);
            if((i+1)%3 == 0) {System.out.println();System.out.print("\t");}
            if((i+1)%9 == 0) {System.out.println();System.out.print("\t");}
        }
        System.out.println();
    }

}