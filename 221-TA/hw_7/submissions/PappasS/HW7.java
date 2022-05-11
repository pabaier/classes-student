/*
* Stephen Pappas
 */
import java.util.*;
import java.io.*;
public class HW7 {
    public static void main(String args[]) throws IOException {
        Deque<String> stacky = new ArrayDeque<>();
        Scanner scanny = new Scanner(System.in);
        System.out.println("Enter the name of a file and press enter.");
        String fileName = scanny.nextLine();
        FileInputStream fileByteStream = new FileInputStream(fileName);
        Scanner inFS = new Scanner(fileByteStream);
        while (inFS.hasNext()) {
            String line = inFS.nextLine();
            while (line.contains(" ")) {
                //System.out.println(line);
                stacky.push(line.substring(0, line.indexOf(" ")));
                line = line.substring(line.indexOf(" ") + 1);
            }
            stacky.push(line);

            while (!stacky.isEmpty()) {
                System.out.print(stacky.pop() + " ");
            }

            System.out.println();
        }

        System.out.println();

        fileByteStream = new FileInputStream("/mnt/sda5/School/221/hw_7/grader/input.txt");
        inFS = new Scanner(fileByteStream);

        while (inFS.hasNext()) {
            stacky.push(inFS.nextLine());
            String line = "";
            System.out.print(stacky.peek());
            boolean boo = true;
            while (boo) {
                line = stacky.pop();
                if (line.length() == 0 || line.length() == 1)
                    break;
                else {
                    if (!(Character.toUpperCase(line.charAt(0)) == Character.toUpperCase(line.charAt(line.length() - 1))))
                        boo = false;
                }
                stacky.push(line.substring(1, line.length()-1));
                //System.out.println("\n" + stacky.peek());
            }


            if(boo)
                System.out.print(" is a palindrome.");
            else
                System.out.print(" is not a palindrome.");

            System.out.println();
        }

        System.out.println();

        fileByteStream = new FileInputStream("/mnt/sda5/School/221/hw_7/grader/input.txt");
        inFS = new Scanner(fileByteStream);



        Deque<String> deqy = new ArrayDeque<>();

        while (inFS.hasNext()) {
            while(!stacky.isEmpty())
                stacky.pop();
            while(!deqy.isEmpty())
                deqy.removeFirst();
            String line = inFS.nextLine();
            String eLine = line;
            while (line.contains(" ")) {
                //System.out.println(line);
                deqy.addLast(line.substring(0, line.indexOf(" ")));
                stacky.push(line.substring(0, line.indexOf(" ")));
                line = line.substring(line.indexOf(" ") + 1);
            }
            deqy.addLast(line);
            stacky.push(line);

            boolean boo = true;

            while (boo) {
                if (deqy.isEmpty() && stacky.isEmpty())
                    break;
                else {
                    String sLine = stacky.pop();
                    String qLine = deqy.removeFirst();
                    if (!sLine.equals(qLine))
                        boo = false;
                }

                //System.out.println("\n" + stacky.peek());
                //System.out.println("\n" + deqy.peek());
            }
            System.out.print(eLine);
            if(boo)
                System.out.print(" is a palindrome.");
            else
                System.out.print(" is not a palindrome.");



            System.out.println();
        }

        fileByteStream.close();

    }
}
