/**
 * App.java
 *
 * Purpose: This program calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
 *
 * Input: The program prompts the user to enter two integer values. If an invalid input (i.e., not an integer) 
 * is entered, the program will request the user to enter a valid number.
 *
 * Output: The program outputs the GCD of the two integers both on the console and in a text file named "EuclidAlgo_Results.txt". 
 * The output in the text file is in the format of: "GCD of [first integer] and [second integer] is: [GCD]"
 * 
 * Error Handling: The program has several error handling mechanisms in place to handle unexpected inputs and scenarios.
 * The program handles potential errors that might occur when writing to the text file. If there is an error writing to the file, 
 * an error message is displayed on the console with the specific error message.
 *
 * Additional Notes: The Scanner object and the BufferedWriter object used in the program are properly closed before the program terminates 
 * to avoid resource leaks. The Euclidean algorithm implemented in the gcd() function is a recursive implementation, which is a common approach 
 * for solving this problem.
 * 
 * @author 	John Angelo A. Basilio
 * @author	Dhan Micheal L. Tamparong
 * @author	Robbie Christian Emmanuel E. Espaldon
 * @version 1.0
 * @since   2022-01-26
 */

import java.util.*;
import java.io.*;

public class App {
	
    // Function to calculate the GCD of two integers using the Euclidean algorithm
    public static int gcd(int a, int b) {
    	
        // Base case: return a if b is 0
        if (b == 0) {
            return a;
        } else {
            // Recursive case: call the function again with b and the remainder of a divided by b
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
    	
        // Create a Scanner object to read inputs from the user
        Scanner sc = new Scanner(System.in);
        
        // Prompt the user to enter the first number
        System.out.print("Enter first number: ");
        // Validate the input to make sure it's an integer
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            sc.next();
            System.out.print("Enter a number: ");
        }
        int a = sc.nextInt();
        
        // Prompt the user to enter the second number
        System.out.print("Enter second number: ");
        // Validate the input to make sure it's an integer
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            sc.next();
            System.out.print("Enter a number: ");
        }
        int b = sc.nextInt();
        
        // Call the gcd() function to calculate the GCD of a and b
        int gcd = gcd(a, b);
        
        // Create a BufferedWriter object to write the result to the file
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("EuclidAlgo_Results.txt"));
            // Write the result to the file in the specified format
            writer.write("GCD of " + a + " and " + b + " is: " + gcd);
        } catch (IOException e) {
            // Display an error message if there is an error writing to the file
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            // Make sure the BufferedWriter object is closed even if an exception is thrown
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // Display an error message if there is an error closing the file
                    System.out.println("Error closing file: " + e.getMessage());
                	}
                }
            }
        // Display the result on the console
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        
        // Close the Scanner object to avoid resource leaks
        sc.close();
    }
}
