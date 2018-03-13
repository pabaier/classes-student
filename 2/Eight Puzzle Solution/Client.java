import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
        List<List<Integer>> allReachable = new ArrayList<List<Integer>>();
        List<Integer> reachable = new ArrayList<Integer>();
        BoardState GoalState = new BoardState(new int[]{0,1,2,3,4,5,6,7,8}); 
        int[][] allPossibleStates = EPUtil.generateAllPossibleStates();
        int count = 0;
        for(int i = 0; i < allPossibleStates.length; i++) {
            if(EPUtil.checkReachable(allPossibleStates[i], GoalState.getCurrentState())) {
                reachable.add(listToInt(allPossibleStates[i]));
                // printArray(allPossibleStates[i]);
                System.out.println(reachable.get(count));
                // System.out.println();
                count ++;
                // if((i+1)%10 == 0)
                //     System.out.println();
            }
        }
        
        System.out.println(count);
        System.out.println(allPossibleStates.length);
    }
    
    public static int listToInt(int[] a){
        String total = "";
        for(int i = 0; i < a.length; i++)
            total += a[i];
        // System.out.println(Integer.parseInt(total));
        return Integer.parseInt(total);
    }
    public static void printArray(int[] a){
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i]);
    }

}


