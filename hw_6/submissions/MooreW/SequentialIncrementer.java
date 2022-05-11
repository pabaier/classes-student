//Elex Moore
public class SequentialIncrementer implements Incrementable{
	private int sValue = 0;
	
	public void increment(int value) {
		sValue += value;
		this.sValue ++;
	}
	
	public int getValue(){
		return this.sValue;
	}

}
