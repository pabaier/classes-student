import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueueHeap<T extends Comparable<T>> extends PriorityQueue<T> {

	

	PriorityQueueHeap(){
		super();
	}
	
	public T PriorityDequeue(){

		T retval;
		if(getData().size() == 0){
			System.out.println("Error - calling dequeue on empty Heap");
			return null;
		}else{
			 retval = getData().remove(0);
		}
		if(getData().size() == 0){
			return retval;
		}else{
			getData().add(0, getData().remove(getData().size()-1));
			boolean inserted = false;
			int index = 0;

			while(!inserted){
				int left = 2*index+1;
				int right = 2*index+2;
				
				int newIndex = -1;
				if(left < getData().size() && right < getData().size()){
					if(getData().get(left).compareTo(getData().get(right)) <= 0){
						newIndex = left;
					}else{
						newIndex = right;
					}
				}else if(left < getData().size() && right >= getData().size()){
					newIndex = left;
				}
				
				if(newIndex != -1 && getData().get(index).compareTo(getData().get(newIndex)) > 0){
					Collections.swap(getData(), index, newIndex);
					index = newIndex;
				}else{
					inserted = true;
				}
				}
			}
		return retval;
	}
	
	public void PriorityEnqueue(Comparable<T> item){
		
		getData().add(getData().size(), (T)item);
		boolean inserted = false;
		int index = getData().size()-1;
		while(!inserted){
			int parent = (index-1)/2;
			if(index == 0){
				inserted = true;
			}else if(getData().get(parent).compareTo(getData().get(index)) <= 0){
					inserted = true;
			}else{
				Collections.swap(getData(), parent, index);
				index = parent;
			}
		}
	}
	

	
	
}
