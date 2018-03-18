import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter server ip addresses\n(x to finish)\n (d for localhost only)");
		String input = in.nextLine();
		
		int[] is = new int[]{0,1,2,3,4,5,6,7,8};
		Client c = new Client(is);

		while(!input.equalsIgnoreCase("x")) {
			if(input.equalsIgnoreCase("d")){
				c.addServerIp("localhost");
				input = "x";
			}
			else{
				c.addServerIp(input);
				input = in.nextLine();
			}

		}
		// c.addServerIp("192.168.1.128");
		// c.addServerIp("192.168.1.146");
		c.generateSolutions();
	}
}
