//Elex Moore
public class HW6Part2 {

	public static void main(String[] args) {
		SequentialIncrement seq = new SequentialIncrement();
		seq.increment(5);
		System.out.println(seq.getValue());
		
		RandomIncrementer randI = new RandomIncrementer();
		randI.increment(4);
		System.out.println(randI.getValue());
		
		

	}

}
