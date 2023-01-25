/**
 * App.java
 *
 * Purpose: The purpose of this program is to calculate the factorial of a given positive number
 * and write the result to a file called "Factorial_Results.txt" and also print it to the console. 
 * The program also formats the result to scientific notation if the number of digits in the factorial exceeds 10.
 *
 * Input: The program prompts the user to enter a number, which should be a non-negative integer.
 *
 * Output: The program calculates the factorial of the input number using recursion and writes the result
 * to a file called "Factorial_Results.txt" and also print it to the console. 
 * If the number of digits in the factorial exceeds 10, the program formats the result to scientific notation.
 * 
 * Error Handling: The program has several error handling mechanisms in place to handle unexpected inputs and scenarios.
 * - If the user enters an invalid input (e.g. a string instead of a number), the program will display an error message 
 * and prompt the user to enter a valid input.
 * - If the user enters a negative number, the program will throw an IllegalArgumentException with a message 
 * "Input number should be non-negative"  and prompt the user to enter a non-negative number.
 * - If an IOException occurs while trying to write to the file, the program will catch the exception and display an error message 
 * indicating that there was an error writing to the file.
 * - The program also closes the BufferedWriter object in a finally block, to make sure that the resources are closed even in case of an exception.
 *
 * Additional Notes:
 * - The program uses the `Scanner` class to read input from the user and the `BigInteger` class for the factorial calculation.
 * - The program also uses the `BufferedWriter` and `FileWriter` classes to write to a file.
 * - The program also uses the DecimalFormat class to format the factorial to scientific notation.
 * - The program uses recursion to calculate the factorial of a number.
 * - The program also validates the user input to ensure that it is a non-negative integer.
 * 
 * @author 	John Angelo A. Basilio
 * @author	Dhan Micheal L. Tamparong
 * @author	Robbie Christian Emmanuel E. Espaldon
 * @version 1.0
 * @since   2022-01-25
 */

// Instantiation
import java.util.*; 
import java.io.*;
import java.math.*;
import java.text.*;

public class App {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	
    	// Create a new scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");

        // Validate user input
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            sc.next();
            System.out.print("Enter a number: ");
        }
        int inputNum = sc.nextInt();
        
        //Check if the input number is negative
        while (inputNum < 0) {
        try {
            if(inputNum < 0) {
                throw new IllegalArgumentException("Invalid input! Please enter a positive number.");
            }
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.print("Enter a positive number: ");
            inputNum = sc.nextInt();
        	}
        }
        
        // Calculate factorial using recursion
        BigInteger factorial = recursion(inputNum);
        
        // Format factorial to scientific notation if necessary
        String factorialString;
        if(factorial.toString().length()>=10){
            DecimalFormat scientificFormat = new DecimalFormat("0.###E0");
            factorialString = scientificFormat.format(factorial);
        } else {
            factorialString = factorial.toString();
        }
        
        // Write the result to a file and print it to the text file
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("Factorial_Results.txt"));
            writer.write("Factorial(" + inputNum + ") = " + factorialString);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                	}
                }
            }
        	System.out.println("Factorial(" + inputNum + ") = " + factorialString);
        	sc.close();
        }
    
    // Recursive function to calculate factorial
    public static BigInteger recursion(int inputNum) {
        if (inputNum == 0) {
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(inputNum).multiply(recursion(inputNum - 1));
    }
}
