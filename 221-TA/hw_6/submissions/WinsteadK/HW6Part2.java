/*
 * Name: Kyle Winstead
 */
public class HW6Part2 {

	public static void main(String[] args) {
		SequentialIncrementer sequence = new SequentialIncrementer();
		System.out.println("SequentialIncrementer");
		sequence.increment();
		System.out.println(sequence.getValue());
		
		sequence.increment();
		System.out.println(sequence.getValue());
	
		
		RandomIncrementer random = new RandomIncrementer();
		System.out.println("RandomIncrementer");
		random.increment();
		System.out.println(random.getValue());
		random.increment();
		System.out.println(random.getValue());

	}

}
