/**
 * class Board
 * 		Implement the functionality for a location-guessing game.  
 * The program displays a grid of 25 circles on the screen.  
 * Selecting the "Randomize" button changes the colors of the
 * circles and increments the move number.  The user can then
 * enlist someone to click on a single circle to change its 
 * color (while they are not watching of course).  Then the user
 * identifies which circle it was by again clicking on the 
 * same circle.  
 * 
 * If the user succeeds, a counter is updated and displayed.
 * 
 * The secret is to use a parity check in both row and column.
 * The "move number" determines if parity is even or odd.  By
 * observing the row and column with changed parity, the user
 * can correctly identify which circle was changed.
 * 
 * Class: CS 107, Spring 2010
 * Lab: Billie Joe Armstrong, Wed. 6:00 AM
 * System: Eclipse 3.4.2, jsdk 1.6, Windows XP

 * @author Dale Reed 
 * @version February 28, 2010
 * 
 */

package proj3;

import java.util.Scanner; // allows user input from the keyboard
import java.util.Random; // allows getting a random number

public class Board {
	// Create the random number generator. "Seed" this with the value 1.
	// Removing the value from the parenthesis will give a different result
	// every
	// time, which isn't what we want when we are debugging.
	Random randomNumberGenerator = new Random(1);

	// declare squares to be displayed
	Square randomizeButton; // randomize board
	Square exitButton; // users presses this to exit program

	// declare the 25 circles to be displayed on the screen, in a 5 x 5 array
	Circle c0, c1; // you will need 25 of these ...

	// Constructor to create the board
	Board() {

		// make the board background
		Square boardBackground = null; // make a Square reference that we can
										// reuse
		boardBackground = new Square(40, 40, 270, "black", true, ""); // background
																		// large
																		// black
																		// outline
		boardBackground = new Square(50, 50, 250, "lightGray", true, ""); // lightGray
																			// board
																			// background

		// create the two circles
		c0 = new Circle();
		// change the values and make it visible
		c0.setPosition(55, 55);
		c0.setDiameter(40);
		c0.setColor("gray");
		c0.setLabel("s" + 0); // will be "s0"
		c0.makeVisible();

		c1 = new Circle();
		// change the values and make it visible
		c1.setPosition(100, 55);
		c1.setDiameter(40);
		c1.setColor("gray");
		c1.setLabel("s" + 1); // will be "s1"
		c1.makeVisible();

		// create the "Redo" and "Exit" squares near the bottom right of the
		// board
		randomizeButton = new Square(250, 350, 40, "lightGray", true, "Redo");
		exitButton = new Square(300, 350, 40, "lightGray", true, "  Exit");

	}// end method doIt()

	// Handle each mouse click. This code should call other methods that you
	// write.
	void handleMouseClick(int mouseX, int mouseY) {
		// Find out if the mouse was in the "Exit" button
		if ((mouseX >= exitButton.getX()) && (mouseX <= (exitButton.getX() + exitButton.getSize()))
				&& (mouseY >= exitButton.getY()) && (mouseY <= (exitButton.getY() + exitButton.getSize()))) {
			// For debugging, uncomment the following line. Found the square, so
			// print it's label
			System.out.println("Clicked on Square: " + exitButton.getLabel());
			// Since the "Exit" square was clicked, exit the program
			System.out.println("Exiting the program...");
			System.exit(0); // exit the program
		}
		// Find out if the mouse was in the "Redo" button
		if ((mouseX >= randomizeButton.getX()) && (mouseX <= (randomizeButton.getX() + randomizeButton.getSize()))
				&& (mouseY >= randomizeButton.getY())
				&& (mouseY <= (randomizeButton.getY() + randomizeButton.getSize()))) {
			// Call the code to randomize the board
			randomizeBoard();
		}

		// you will need further code here to check for mouse clicks on other
		// Squares and Circles
		// ...

	}// end handleMouseClick(...)

	void randomizeBoard() {
		// make a reference to a Circle, which can point to any circle (s0, s1,
		// etc)
		Circle theCircle = null;

		// choose circle 0 or circle 1
		int whichCircle = randomNumberGenerator.nextInt(2); // get random number
															// 0..1

		// Make the circle reference point to the randomly chosen numbered
		// circle
		if (whichCircle == 0) {
			theCircle = c0; // variable theCircle is now a synonym for Circle c0
		} else {
			theCircle = c1; // variable theCircle is now a synonym for Circle c1
		}

		// change the color of the circle
		if (theCircle.getColor().equals("gray")) {
			theCircle.setColor("red");
		} else {
			theCircle.setColor("gray");
		}

	}

}// end class Board()
