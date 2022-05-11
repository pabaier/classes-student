import java.util.ArrayList;

public abstract class PriorityQueue<T> {

	private ArrayList<T> data;
	
	PriorityQueue(){
		this.data = new ArrayList<T>();
	}
	abstract T PriorityDequeue();
	
	abstract void PriorityEnqueue(Comparable<T> item);
	
	public void empty(){
		this.data = new ArrayList<T>();
	}
	
	public ArrayList<T> getData(){
		return this.data;
	}
}
