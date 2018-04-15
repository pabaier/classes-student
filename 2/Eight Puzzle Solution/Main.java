import java.util.*;
import java.net.*;
import java.io.IOException;
import java.net.InetAddress;

public class Main {

	public static void main(String[] args) {
		String input = "";
		try{
			input = args[0];
		}
		catch(Exception e){
			System.out.println("Enter '-l', '-m', '-a', or '-h' as arguments");
			System.out.println("Resorting to default `-l', localhost");
			input = "-l";
		}

		int[] is = new int[]{0,1,2,3,4,5,6,7,8}; // initial state
		Client c = new Client(is);

		switch (args[0]){
			case "-l":
				System.out.println("localhost");
				localHost(c);
				break;
			case "-a":
				int start, end;
				System.out.println("auto");
				try{
					start = Integer.parseInt(args[1]);
					end = Integer.parseInt(args[2]);
				}
				catch(Exception e){
					start = 0;
					end = 30;
				}
				autoDetect(c, start, end);
				break;
			case "-m":
				System.out.println("manual");
				manualEntry(c);
				break;
			case "-h":
				printHelp();
				return;
			default:
				System.out.println("localhost");
				localHost(c);
		}

		c.generateSolutions();
	}

	public static void localHost(Client c){
		c.addServerIp("localhost");
	}

	public static void manualEntry(Client c){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter server ip addresses\n(x to finish)\n");
		String input = in.nextLine();

		while(!input.equalsIgnoreCase("x")) {
			c.addServerIp(input);
			input = in.nextLine();
		}
	}

	public static void autoDetect(Client c, int start, int end){
		for(int i = start; i<end; i++){			
			try{
				String ip = "192.168.1." + i;
				InetAddress i4 = Inet4Address.getByName(ip);
				if(i4.isReachable(500)){
					System.out.println("found: " + i4);
					c.addServerIp(ip);
				}
			}
			catch(Exception e){System.out.print("x");}
		}
	}

	public static void printHelp(){
		System.out.println("help: ");
		System.out.println("     no arguments defaults to '-l'");
		System.out.println("     -a: automatic detection");
		System.out.println("         defaults to checking 192.168.1.0 - 30");
		System.out.println("         optional start end values for custom range other than 0 - 30");
		System.out.println("     -m: manual entry (enter 'x' to end)");
		System.out.println("     -l: for localhost only");
		System.out.println("         for local host and others, do manual and enter 'localhost'");
		System.out.println("     -h: to see this help menu");
	}
}
