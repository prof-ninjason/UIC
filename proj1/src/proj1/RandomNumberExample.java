package proj1;

/** --------------------------------------------- 
 * RandomNumberExample.java
 * 
 *     Show how the random number generator works in Java.
 * 
 * System: Java 6, using Eclipse, on Windows 7
 * Class: CS 102, Spring 2012
 * 
 * @version January 19, 2012
 * @author Dale Reed
 */

import java.util.Random;    // library for random number generation

public class RandomNumberExample {

	Random randomNumberGenerator;  					// declare the random number generator
	
	// Don't write code in main, rather chain off to another
	// method to avoid static errors.  This will make more
	// sense later in the semester.
	public static void main(String[] args)
	{
		RandomNumberExample instance = new RandomNumberExample();
		instance.doIt();
	}//end main()
	
	
	// Write your code in the method below
	void doIt()
	{
        // Seed the random number generator using a fixed value of 1.
		// This way the random numbers created are the same each time program runs.
		// If you wanted it to be different each time, remove the 1 from the parenthesis.
        randomNumberGenerator = new Random(1);  
        
		// display identifying information
		System.out.println("Random number example program.");
		
		// generate and display 10 random numbers
		for( int i=0; i<10; i++) {
			// generate a random number in range 0..15, + 1 to put it in range 1..16
			int randomNumber = randomNumberGenerator.nextInt(16) + 1;   
			
			System.out.println( randomNumber);
		}

		System.out.println("Done with program.");
	}//end doIt()
	
}//end class RandomNumberExample
