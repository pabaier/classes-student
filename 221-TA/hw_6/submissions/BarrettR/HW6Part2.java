//Ryan Barrett
//part 2 tester
public class HW6Part2 {
	public static void main(String[]args) {
		RandomIncrementer someNumber = new RandomIncrementer();
		SequentialIncrementer someOtherNumber = new SequentialIncrementer();
		
		for(int i = 0; i < 10; i++)
			someOtherNumber.incrementable();
		
		System.out.println("Value of RandomIncrementer object: " + someNumber.getValue());
		System.out.println("Value of SequentialIncrementer object: " + someOtherNumber.getValue());
		
		someNumber.incrementable();
		System.out.println("New Value of RandomIncrementer object: " + someNumber.getValue());
	}
}