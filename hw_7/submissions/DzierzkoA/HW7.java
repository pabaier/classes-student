/*
    Homework 7: Stack and queue operations
    Author: Adam Dzierzko
 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class HW7 {

    public static void main(String[] args) {
        Deque<String> stringStack = new ArrayDeque<>();
        String filename;
        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = null;

        System.out.println("Enter the name of file: ");
        filename = scanner.next();
        try {
            fileScanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.print("Could not find the file!");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        //Part 1
        System.out.println("\nSentences in reverse (at word level)");

        while (fileScanner.hasNext()) {
            String line;
            line = fileScanner.nextLine();
            String[] separatedLine = line.split(" ");
            for (String aSeparatedLine : separatedLine) {
                stringStack.push(aSeparatedLine);
            }
            while (!stringStack.isEmpty()) {
                System.out.print(stringStack.pop() + " ");
            }
            System.out.println();
        }

        //Part 2
        System.out.println();
        System.out.println("Checking if a string is a palindrome at the character level");

        //Reset the scanner to read from the file again
        try {
            fileScanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.print("Could not find the file!");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        while (fileScanner.hasNext()) {
            Boolean isPalindrome = false;
            String line;
            line = fileScanner.nextLine();
            String saveLine = line; //Line gets modified inside the for loop so I need to save the full line for final output
            stringStack.push(line);
            if (line.length() < 2) {
                isPalindrome = true;
            } else {
                for (int i = 0; i < line.length(); i++) {
                    if (stringStack.peek().charAt(0) == stringStack.pop().charAt(line.length() - 1)) {
                        line = line.substring(1, line.length() - 1);
                        stringStack.push(line);
                        isPalindrome = true;
                    } else {
                        isPalindrome = false;
                        break;
                    }
                }
                String result = isPalindrome ? "is a palindrome" : "is not a palindrome";
                System.out.println(saveLine + " " + result);
            }

        }

        // Part 3
        System.out.println();
        System.out.println("Checking if a string is a palindrome at the word level");


        try {
            fileScanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.print("Could not find the file!");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        Deque<String> queue = new ArrayDeque<>();

        while (fileScanner.hasNext()) {
            Boolean isPalindrome = false;
            String line;
            line = fileScanner.nextLine();
            String saveLine = line;
            String[] separatedLine = line.split(" ");
            for (String aSeparatedLine : separatedLine) {
                queue.push(aSeparatedLine);
            }
            for (int i = 0; i < queue.size(); i++) {
                if (queue.size() < 1) {
                    isPalindrome = true;
                    break;
                } else {
                    if (queue.peekFirst().equals(queue.peekLast())) {
                        isPalindrome = true;
                        queue.removeFirst();
                        queue.removeLast();
                    }
                }
            }

            String result = isPalindrome ? "is a palindrome" : "is not a palindrome";
            System.out.println(saveLine + " " + result);
        }


    }

}



