import java.util.ArrayList;

// import jdk.nashorn.internal.parser.JSONParser;
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import static java.lang.Math.toIntExact;


public class Server  {

	public static void main(String[] args) throws Exception {
        System.out.println(" Server is Running ");
        ServerSocket mysocket = new ServerSocket(5555);

        while(true) {
            Socket connectionSocket = mysocket.accept();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
            writer.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			// read client info
			String tempInfo = reader.readLine();
			JSONParser parser = new JSONParser();
			Object temp = parser.parse(tempInfo);
			JSONObject infoFromClient = (JSONObject)temp;

			long indexTemp = (long)infoFromClient.get("id");
			int index = toIntExact(indexTemp);
			String initialState = (String)infoFromClient.get("initial");
			String goalState = (String)infoFromClient.get("goal");

			// GET SOLUTION
			String solution = ServerWorker(
				new PriorityQueueHeap(),
				stringToIntArray(initialState),
				stringToIntArray(goalState));

			// send client info
			// {“id”: 1234, “solution”: “012345678102345678120345678”}
			JSONObject infoToClient = new JSONObject();
			infoToClient.put("id", index);
			infoToClient.put("solution", solution);

			writer.write(infoToClient.toJSONString());
			writer.newLine();
			writer.flush();
			System.out.println("Done job: " + index);
            connectionSocket.close();
        }
	}
	
	private static String ServerWorker(PriorityQueue<BoardState> dataStructure, int[] initialState, int[] Goal){
		PriorityQueue<BoardState> openNodesQueue = dataStructure;
		BoardState GoalState = new BoardState(Goal);
		
		// Do the EightPuzzle/A* algorithm:
		openNodesQueue.empty();
		Map<String, BoardState> closedNodes = new HashMap<String, BoardState>();
		
		boolean goalFound = false;
		openNodesQueue.PriorityEnqueue(new BoardState(initialState));
		while(!goalFound){
			BoardState current = openNodesQueue.PriorityDequeue();
			if(GoalState.equals(current)){
				return printPath(current, ""); //ANSWER IS IN HERE!
				// goalFound = true;
			}else{
				closedNodes.putIfAbsent(makeKey(current), current);
				BoardState child;
				child = move(current, 0, 1);
				if(child != null && closedNodes.get(makeKey(child)) == null){
					openNodesQueue.PriorityEnqueue(child);
				}						
				child = move(current, 0, -1);
				if(child != null && closedNodes.get(makeKey(child)) == null){
					openNodesQueue.PriorityEnqueue(child);
				}
				child = move(current, 1, 0);
				if(child != null && closedNodes.get(makeKey(child)) == null){
					openNodesQueue.PriorityEnqueue(child);
				}
				child = move(current, -1, 0);
				if(child != null && closedNodes.get(makeKey(child)) == null){
					openNodesQueue.PriorityEnqueue(child);
				}					
			}
		}
		return "error in solution algorithm";
	}

	private static String makeKey(BoardState current){
		String retval = "";
		for(int i = 0;i< current.getCurrentState().length;++i){
			retval += current.getCurrentState()[i];
		}
		return retval;
	}
	
	private static BoardState move(BoardState current, int rowMove, int colMove){
		int index = 0;
		int[] newBoard = new int[9];
		for(int i = 0;i < 9;++i){
			newBoard[i] = current.getCurrentState()[i];
			if(current.getCurrentState()[i] == 0){
				index = i;
			}				
		}
		int newrow = index/3 + rowMove; 
		int newcol = index%3 + colMove;
		if(newrow >= 0 && newrow <= 2 && newcol >= 0 && newcol <= 2){
			newBoard[index] = newBoard[index+3*rowMove+colMove];
			newBoard[index+3*rowMove+colMove] = 0;
		}else{
			return null;
		}
		BoardState NewChild = new BoardState(newBoard);
		NewChild.setG(current.getG()+1);
		NewChild.setH(manhattan(NewChild.getCurrentState(), current.getCurrentState()));
		NewChild.setParent(current);
		return NewChild;
	}
	
	private static int manhattan(int[] initialState, int[] endState){
		// return manhattan distance between these two states
		int distance = 0;
		for(int i = 0; i < initialState.length; i++){
			for(int j = 0; j < endState.length; j++){
				if(initialState[i] == endState[j] && initialState[i] != 0){
					distance = distance + Math.abs(j/3 - i/3) + Math.abs(j%3 - i%3);
				}
			}
		}
		return distance;
	}

	private static String printPath(BoardState current, String ans){
		if(current != null){
			String boardString = intArrayToString(current.getCurrentState());
			ans = boardString + printPath(current.getParent(), ans);
		}
		return ans;
	}
	
	private static int[] stringToIntArray(String s) {
        int[] i = new int[s.length()];
        try{
            int j = 0;
            for(char c : s.toCharArray()) {
                i[j] = Character.getNumericValue(c);
                j++;
            }
        }catch(Exception e){return new int[]{-1};}
        return i;
	}
	
	private static String intArrayToString(int[] list) {
        String result = "";
        for(int i : list)
            result += i;
        return result;
    }
}
