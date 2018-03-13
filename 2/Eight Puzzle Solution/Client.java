import java.util.ArrayList;
import java.util.List;

public class Client {

    int[] initialState;
    List<Integer> allReachable;

    public Client(int[] is) {
        initialState = is;
        allReachable = new ArrayList<Integer>();
        BoardState GoalState = new BoardState(is); 
        int[][] allPossibleStates = EPUtil.generateAllPossibleStates();
        for(int i = 0; i < allPossibleStates.length; i++) {
            if(EPUtil.checkReachable(allPossibleStates[i], GoalState.getCurrentState())) {
                allReachable.add(listToInt(allPossibleStates[i]));
            }
        }
    }
    
    private static int listToInt(int[] a){
        String total = "";
        for(int i = 0; i < a.length; i++)
            total += a[i];
        return Integer.parseInt(total);
    }
    private static void printArray(int[] a){
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if((i+1)%3 == 0)
                System.out.println();
        }
    }

}


