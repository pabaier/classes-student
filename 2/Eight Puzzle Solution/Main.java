import java.util.*;
import java.net.*;
import java.io.IOException;
import java.net.InetAddress;

public class Main {

	public static void main(String[] args) {

		int[] is = new int[]{0,1,2,3,4,5,6,7,8}; // initial state
		Client c = new Client(is);

		for(int i = 0; i<30; i++){			
			try{
				String ip = "192.168.1." + i;
				InetAddress i4 = Inet4Address.getByName(ip);
				if(i4.isReachable(250)){
					System.out.println(i4);
					c.addServerIp(ip);
				}
			}
			catch(Exception e){System.out.print("x");}
		}

		c.generateSolutions();

		// ---------------------THIS WORKS, DO NOT CHANGE vvv ---------------------------
		
		// Scanner in = new Scanner(System.in);
		// System.out.println("Enter server ip addresses\n(x to finish)\n (d for localhost only)");
		// String input = in.nextLine();

		// int[] is = new int[]{0,1,2,3,4,5,6,7,8}; // initial state
		// Client c = new Client(is);
		// while(!input.equalsIgnoreCase("x")) {
		// 	if(input.equalsIgnoreCase("d")){
		// 		c.addServerIp("localhost");
		// 		input = "x";
		// 	}
		// 	else{
		// 		c.addServerIp(input);
		// 		input = in.nextLine();
		// 	}

		// }

		// c.addServerIp("192.168.1.128");
		// c.addServerIp("192.168.1.146");
		// c.generateSolutions();
	}
}
