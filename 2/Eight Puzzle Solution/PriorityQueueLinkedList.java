import java.util.ArrayList;

public class PriorityQueueLinkedList<T extends Comparable<T>> extends PriorityQueue<T>{
	

	PriorityQueueLinkedList(){
		super();
	}
	
	public T PriorityDequeue(){
		if(getData().size() > 0){
			return (T)(getData().remove(0));
		}else{
			System.out.println("Calling DeQueue on an Empty Queue....");
			return null;
		}
		
	}
	
	public void PriorityEnqueue(Comparable<T> item){
		
		boolean inserted = false;
		for(int i = 0; i < getData().size();++i){
			if(item.compareTo((T)getData().get(i)) <= 0){
				getData().add(i, (T)item);
				inserted = true;
				break;
			}	
		}
		if(!inserted){
			getData().add((T)item);
		}
	}

	
}
