import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EightPuzzle  {
	
	PriorityQueue<BoardState> openNodesQueue;	
	Map<String, BoardState> closedNodes;
	BoardState GoalState;
	int[][] AllPossibleStates;	
	
	public EightPuzzle(PriorityQueue<BoardState> dataStructure, int[] Goal){
		openNodesQueue = dataStructure;
		GoalState = new BoardState(Goal);
		AllPossibleStates = generateAllPossibleStates();
		
		long totalRunTime = 0;
		int statesSolved = 0;
		
		for(int i = 0;i < AllPossibleStates.length;++i){
		
			if(checkReachable(AllPossibleStates[i], GoalState.getCurrentState())){
				// Do the EightPuzzle/A* algorithm:
				openNodesQueue.empty();
				closedNodes = new HashMap<String, BoardState>();
				
				++statesSolved;
				long startTime = System.currentTimeMillis(); 
	
				boolean goalFound = false;
				openNodesQueue.PriorityEnqueue(new BoardState(AllPossibleStates[i]));
				while(!goalFound){
					BoardState current = openNodesQueue.PriorityDequeue();
					if(this.GoalState.equals(current)){
						int numMoves = printPath(current, 0);
						double Time = (System.currentTimeMillis()-startTime)/1000.0;
						totalRunTime += Time;
						System.out.println("==================================================");
						System.out.println("              PREVIOUS SOLUTION DATA              ");
						System.out.printf("Number of moves: %d, Time Needed:  %.2f Seconds\n", numMoves, (System.currentTimeMillis()-startTime)/1000.0);
						System.out.printf("States solved:   %d, Total Running Time: %.2f Minutes\n", statesSolved, totalRunTime/60.0);
						System.out.println("==================================================");
						goalFound = true;
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
				} // end while
			

			} // end if
		} // end for
	} // end EightPuzzle
	
	
	private String makeKey(BoardState current){
		String retval = "";
		for(int i = 0;i< current.getCurrentState().length;++i){
			retval += current.getCurrentState()[i];
		}
		return retval;
	}
	
	private BoardState move(BoardState current, int rowMove, int colMove){
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
	
	public boolean checkReachable(int state1[], int state2[]){
		boolean reachable = false;
		int count1 = 0, count2 = 0; 
		for(int i = 0; i< state1.length; i++){
			for(int j = i+1; j < state1.length; j++ ){
				if(state1[i] > state1[j] && state1[j] != 0){
					count1 += 1;
				}
				if(state2[i] > state2[j] && state2[j] != 0){
					count2 += 1;
				}
			}	
		}
		return count2 % 2 == count1 % 2;
	}
	
	public int manhattan(int[] initialState, int[] endState){
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

	public int printPath(BoardState current, int count){
		if(current != null){
			count = 1 + printPath(current.getParent(), count);
			System.out.print(current.toString() + "---\n");

		}
		return count;
	}
	
	public static int[][] generateAllPossibleStates(){
		System.out.print("Generating All Possible States... ");
		int[][] aps = new int[362880][9];

		
		//int temp[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(0);
		temp.add(1);
		temp.add(2);
		temp.add(3);
		temp.add(4);
		temp.add(5);
		temp.add(6);
		temp.add(7);			
		temp.add(8);

		int count = 0;
		for(int a = 0; a < 9;++a){
			int one = temp.remove(a);
			for(int b = 0; b < 8;++b){
				int two = temp.remove(b);
				for(int c = 0; c < 7;++c){
					int three = temp.remove(c);
					for(int d = 0; d < 6;++d){
						int four = temp.remove(d);
						for(int e = 0; e < 5;++e){
							int five = temp.remove(e);
							for(int f = 0; f < 4;++f){
								int six = temp.remove(f);
								for(int g = 0; g < 3;++g){
									int seven = temp.remove(g);
									for(int h = 0; h < 2;++h){
										int eight = temp.remove(h);
										for(int i = 0; i < 1;++i){
											int nine = temp.remove(i);
											aps[count][0] = one;
											aps[count][1] = two;
											aps[count][2] = three;
											aps[count][3] = four;
											aps[count][4] = five;
											aps[count][5] = six;
											aps[count][6] = seven;
											aps[count][7] = eight;
											aps[count][8] = nine;
											++count;
											temp.add(0, nine);
										}
										temp.add(0, eight);
									}
									temp.add(0, seven);
								}
								temp.add(0, six);
							}
							temp.add(0, five);
						}
						temp.add(0, four);
					}
					temp.add(0, three);
				}
				temp.add(0, two);
			}
			temp.add(0, one);
		}
		System.out.println("Done!\n");
		return aps;
	}
	
	public static void print2DArray(int[][] myArray) {
		for(int i = 0; i < myArray.length; i++) {
			for(int j = 0; j < myArray[0].length; j++) {
				System.out.print(myArray[i][j]);
				if((j+1)%3 == 0)
					System.out.println();
			}
			System.out.println();
		}
	}
	

	
}
