/**
* A circle that can be manipulated and that draws itself on a canvas.
* This has been modified by DFR to allow drawing text within the Circle.
* 
* @author  Michael Kolling and David J. Barnes
* @version 1.0  (15 July 2000)
*/

package proj3;

import java.awt.*;
import java.awt.geom.*;

public class Circle {
	private int diameter;
	private int xPosition;
	private int yPosition;
	private String color;
	private boolean isVisible;
	private String label;

	/**
	 * Create a new circle at default position with default color.
	 */
	public Circle() {
		diameter = 30;
		xPosition = 20;
		yPosition = 60;
		color = "blue";
		isVisible = false;
		label = "";
		draw();
	}

	/**
	 * Create a new circle with supplied values
	 */
	public Circle(int x, int y, int theDiameter, String theColor, boolean visibility, String theLabel) {
		xPosition = x;
		yPosition = y;
		diameter = theDiameter;
		color = theColor;
		isVisible = visibility;
		this.label = theLabel;
		draw();
	}

	/**
	 * Make this circle visible. If it was already visible, do nothing.
	 */
	public void makeVisible() {
		isVisible = true;
		draw();
	}

	/**
	 * Make this circle invisible. If it was already invisible, do nothing.
	 */
	public void makeInvisible() {
		erase();
		isVisible = false;
	}

	/**
	 * Move the circle a few pixels to the right.
	 */
	public void moveRight() {
		moveHorizontal(20);
	}

	/**
	 * Move the circle a few pixels to the left.
	 */
	public void moveLeft() {
		moveHorizontal(-20);
	}

	/**
	 * Move the circle a few pixels up.
	 */
	public void moveUp() {
		moveVertical(-20);
	}

	/**
	 * Move the circle a few pixels down.
	 */
	public void moveDown() {
		moveVertical(20);
	}

	/**
	 * Move the circle horizontally by 'distance' pixels.
	 */
	public void moveHorizontal(int distance) {
		erase();
		xPosition += distance;
		draw();
	}

	/**
	 * Move the circle vertically by 'distance' pixels.
	 */
	public void moveVertical(int distance) {
		erase();
		yPosition += distance;
		draw();
	}

	/**
	 * Slowly move the circle horizontally by 'distance' pixels.
	 */
	public void slowMoveHorizontal(int distance) {
		int delta;

		if (distance < 0) {
			delta = -1;
			distance = -distance;
		} else {
			delta = 1;
		}

		for (int i = 0; i < distance; i++) {
			xPosition += delta;
			draw();
		}
	}

	/**
	 * Slowly move the circle vertically by 'distance' pixels.
	 */
	public void slowMoveVertical(int distance) {
		int delta;

		if (distance < 0) {
			delta = -1;
			distance = -distance;
		} else {
			delta = 1;
		}

		for (int i = 0; i < distance; i++) {
			yPosition += delta;
			draw();
		}
	}

	/**
	 * Get x
	 */
	public int getX() {
		return xPosition;
	}

	/**
	 * Get y
	 */
	public int getY() {
		return yPosition;
	}

	/**
	 * Get the color
	 * 
	 * @return the color of the circle
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Get the diameter
	 */
	public int getDiameter() {
		return diameter;
	}

	/**
	 * Get the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Change the position
	 */
	public void setPosition(int x, int y) {
		xPosition = x;
		yPosition = y;
		draw();
	}

	/**
	 * Change the label
	 */
	public void setLabel(String newLabel) {
		label = newLabel;
		draw();
	}

	/**
	 * Change the Diameter
	 */
	public void setDiameter(int theDiameter) {
		diameter = theDiameter;
		draw();
	}

	/**
	 * Change the Color
	 */
	public void setColor(String theColor) {
		color = theColor;
		draw();
	}

	/*
	 * Draw the circle with current specifications on screen.
	 */
	private void draw() {
		if (isVisible) {
			Canvas canvas = Canvas.getCanvas();
			/*
			 * Comment out this old version that displayed the label, since we
			 * don't want to display it canvas.draw(this, color, new
			 * Ellipse2D.Double(xPosition, yPosition, diameter, diameter),
			 * label);
			 */
			canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition, diameter, diameter), "");
			canvas.wait(0);
		}
	}

	/*
	 * Erase the circle on screen.
	 */
	private void erase() {
		if (isVisible) {
			Canvas canvas = Canvas.getCanvas();
			canvas.erase(this);
		}
	}
}
