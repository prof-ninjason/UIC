package proj2;

/** --------------------------------------------- 
 * Decrypt.java
 * 
 *     Decrypt or encrypt a secret message using a
 * transposition cipher (1..25). Values wrap around
 * at the end of the alphabet. A transposition
 * of 1 changes "abcz" into "bcda", and a transposition
 * value of 2 changes "abcz" into "cdeb".  The input
 * might also need to be reversed to be decoded. A 
 * potential solution is identified by having a large 
 * number of common English words, taken from:
 *      http://www.duboislc.org/EducationWatch/First100Words.html
 * Encryption selects a transpostion value at random
 * as well as choosing a direction (forward or reverse)
 * at random.
 * 
 * Lab: Sean Deitz, Wed 5 AM
 * System: Java 6, using Eclipse, on Windows 7
 * Class: CS 102, Spring 2012
 * 
 * @version January 19, 2012
 * @author Dale Reed
 */

import java.util.Scanner; // for user input

public class Decrypt {

	// declare Scanner for user input
	Scanner keyboard = new Scanner(System.in);

	// Don't write code in main, rather chain off to another
	// method to avoid static errors. This will make more
	// sense later in the semester.
	public static void main(String[] args) {
		Decrypt instance = new Decrypt();
		instance.doIt();
	}// end main()

	// Write your code in the method below
	void doIt() {
		// display identifying information
		System.out.println("Author: Dale Reed ");
		System.out.println("TA: Sean Deitz, Wed 5am ");
		System.out.println("Program: #2, Decrypt \n");

		// Prompt for and read in input
		System.out.print("Enter input string: ");
		String inputLine = keyboard.nextLine();

		// write your code here...
		System.out.println(inputLine);

		System.out.println("Done with program.");
	}// end doIt()

}// end class Decrypt