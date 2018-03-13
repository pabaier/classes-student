
public class BoardState implements Comparable{
	private int[] currentState;
	private BoardState parent;
	private int g;
	private int h;
	
	public BoardState(int[] data){
		this.currentState = new int[9];
		for(int i = 0;i < 9;++i){
			this.currentState[i] = data[i];
		}
		this.parent = null;
		this.g = 0;
		this.h = 0;
	}
	
	public int compareTo(Object item){
		BoardState otherState = (BoardState)item;
		if(this.g + this.h == otherState.getG() + otherState.getH()){
			return 0;
		}else if(this.g + this.h > otherState.getG() + otherState.getH()){
			return 1;	
		}else{
			return -1;
		}
	}
	

	public boolean equals(Object item){
		BoardState otherState = (BoardState)item;
		boolean rtnval = true;
		for(int i = 0; i < this.currentState.length; i++){
			if(this.currentState[i] != otherState.getCurrentState()[i]){
				rtnval = false;
			}
		}
		return rtnval;
	}
	

	public String toString(){
		String rtnval = "";
		for(int i = 0; i < this.currentState.length; i++){
			rtnval += String.valueOf(this.currentState[i]);
			if(i%3 == 2){
				rtnval += "\n";
			}
		}
		return rtnval;
	}
	
	
	public int[] getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int[] currentState) {
		this.currentState = currentState;
	}

	public BoardState getParent() {
		return parent;
	}

	public void setParent(BoardState parent) {
		this.parent = parent;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

 
}
