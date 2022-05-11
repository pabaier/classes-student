/*Tyler Gray
 * HW6Part2
 * Tests the incrementer class
 * Displays ten results for each class
 * 
 */
public class HW6Part2 {

	public static void main(String[] args) {
		
		//Test Random
		RandomIncrementer randInc = new RandomIncrementer();
		for(int i = 0; i < 10; i++) {
		System.out.println(randInc.getValue());
		randInc.increment();
		}
		//Test SequentialIncrementer
		SequentialIncrementer seqInc = new SequentialIncrementer();
		for(int i = 0; i < 10; i++) {
		System.out.println(seqInc.getValue());
		seqInc.increment();
		}

	}

}
