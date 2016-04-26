/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example. This version includes a method to allow the 
 * mouse events to interact with the drawing frame.
 *
 * @author: Bruce Quig
 * @author: Michael Kolling (mik)
 * @author: Dale Reed (updated color list for use in CS 102 & CS 107,
 *              also adds mouse listener to the display frame
 *f
 * @version: 1.6 (shapes)
 */

package proj3;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import java.awt.event.*;

public class Canvas {
	// Note: The implementation of this class (specifically the handling of
	// shape identity and colors) is slightly more complex than necessary. This
	// is done on purpose to keep the interface and instance fields of the
	// shape objects in this project clean and simple for educational purposes.

	private static Canvas canvasSingleton;

	/**
	 * Factory method to get the canvas singleton object.
	 */
	public static Canvas getCanvas() {
		if (canvasSingleton == null) {
			canvasSingleton = new Canvas("CS 102 Program #3 Memory Trainer", 350, 400, Color.white);
		}
		canvasSingleton.setVisible(true);
		return canvasSingleton;
	}

	// ----- instance part -----

	private JFrame frame;
	private CanvasPane canvas;
	private Graphics2D graphic;
	private Color backgroundColour;
	private Image canvasImage;
	private List objects;
	private HashMap shapes;

	/**
	 * Create a Canvas.
	 * 
	 * @param title
	 *            title to appear in Canvas Frame
	 * @param width
	 *            the desired width for the canvas
	 * @param height
	 *            the desired height for the canvas
	 * @param bgClour
	 *            the desired background colour of the canvas
	 */
	private Canvas(String title, int width, int height, Color bgColour) {
		frame = new JFrame();
		canvas = new CanvasPane();
		frame.setContentPane(canvas);
		frame.setTitle(title);
		canvas.setPreferredSize(new Dimension(width, height));
		backgroundColour = bgColour;
		frame.pack();
		objects = new ArrayList();
		shapes = new HashMap();

	}

	public void setMouseListener(MouseListener theInstance) {
		frame.addMouseListener(theInstance);
	}

	/**
	 * Set the canvas visibility and brings canvas to the front of screen when
	 * made visible. This method can also be used to bring an already visible
	 * canvas to the front of other windows.
	 * 
	 * @param visible
	 *            boolean value representing the desired visibility of the
	 *            canvas (true or false)
	 */
	public void setVisible(boolean visible) {
		if (graphic == null) {
			// first time: instantiate the offscreen image and fill it with
			// the background colour
			Dimension size = canvas.getSize();
			canvasImage = canvas.createImage(size.width, size.height);
			graphic = (Graphics2D) canvasImage.getGraphics();
			graphic.setColor(backgroundColour);
			graphic.fillRect(0, 0, size.width, size.height);
			graphic.setColor(Color.black);
		}
		frame.setVisible(visible);
	}

	/**
	 * Draw a given shape onto the canvas.
	 * 
	 * @param referenceObject
	 *            an object to define identity for this shape
	 * @param color
	 *            the color of the shape
	 * @param shape
	 *            the shape object to be drawn on the canvas
	 */
	// Note: this is a slightly backwards way of maintaining the shape
	// objects. It is carefully designed to keep the visible shape interfaces
	// in this project clean and simple for educational purposes.
	public void draw(Object referenceObject, String color, Shape shape) {
		objects.remove(referenceObject); // just in case it was already there
		objects.add(referenceObject); // add at the end
		shapes.put(referenceObject, new ShapeDescription(shape, color));
		redraw();
	}

	public void draw(Object referenceObject, String color, Shape shape, String label) {
		objects.remove(referenceObject); // just in case it was already there
		objects.add(referenceObject); // add at the end
		shapes.put(referenceObject, new ShapeDescription(shape, color, label));
		redraw();
	}

	/**
	 * Erase a given shape's from the screen.
	 * 
	 * @param referenceObject
	 *            the shape object to be erased
	 */
	public void erase(Object referenceObject) {
		objects.remove(referenceObject); // just in case it was already there
		shapes.remove(referenceObject);
		redraw();
	}

	/**
	 * Set the foreground colour of the Canvas.
	 * 
	 * @param newColour
	 *            the new colour for the foreground of the Canvas
	 */
	public void setForegroundColor(String colorString) {
		if (colorString.equals("red"))
			graphic.setColor(Color.red);
		else if (colorString.equals("black"))
			graphic.setColor(Color.black);
		else if (colorString.equals("blue"))
			graphic.setColor(Color.blue);
		else if (colorString.equals("yellow"))
			graphic.setColor(Color.yellow);
		else if (colorString.equals("green"))
			graphic.setColor(Color.green);
		else if (colorString.equals("magenta"))
			graphic.setColor(Color.magenta);
		else if (colorString.equals("cyan"))
			graphic.setColor(Color.cyan);
		else if (colorString.equals("darkGray"))
			graphic.setColor(Color.darkGray);
		else if (colorString.equals("gray"))
			graphic.setColor(Color.gray);
		else if (colorString.equals("lightGray"))
			graphic.setColor(Color.lightGray);
		else if (colorString.equals("orange"))
			graphic.setColor(Color.orange);
		else if (colorString.equals("pink"))
			graphic.setColor(Color.pink);
		else if (colorString.equals("white"))
			graphic.setColor(Color.white);
		else
			graphic.setColor(Color.black); // Default color
	}

	/**
	 * Wait for a specified number of milliseconds before finishing. This
	 * provides an easy way to specify a small delay which can be used when
	 * producing animations.
	 * 
	 * @param milliseconds
	 *            the number
	 */
	public void wait(int milliseconds) {
		if (milliseconds > 0) {
			try {
				Thread.sleep(milliseconds);
			} catch (Exception e) {
				// ignoring exception at the moment
			}
		} // end if( milliseconds...
	}

	/**
	 * Redraw all shapes currently on the Canvas.
	 */
	private void redraw() {
		erase();
		for (Iterator i = objects.iterator(); i.hasNext();) {
			((ShapeDescription) shapes.get(i.next())).draw(graphic);
		}
		canvas.repaint();
	}

	/**
	 * Erase the whole canvas. (Does not repaint.)
	 */
	private void erase() {
		Color original = graphic.getColor();
		graphic.setColor(backgroundColour);
		Dimension size = canvas.getSize();
		graphic.fill(new Rectangle(0, 0, size.width, size.height));
		graphic.setColor(original);
	}

	/************************************************************************
	 * Inner class CanvasPane - the actual canvas component contained in the
	 * Canvas frame. This is essentially a JPanel with added capability to
	 * refresh the image drawn on it.
	 */
	private class CanvasPane extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(canvasImage, 0, 0, null);
		}
	}

	/************************************************************************
	 * Inner class CanvasPane - the actual canvas component contained in the
	 * Canvas frame. This is essentially a JPanel with added capability to
	 * refresh the image drawn on it.
	 */
	private class ShapeDescription {
		private Shape shape;
		private String colorString;
		private String label;

		public ShapeDescription(Shape shape, String color) {
			this.shape = shape;
			colorString = color;
		}

		public ShapeDescription(Shape shape, String color, String label) {
			this.shape = shape;
			this.label = label;
			colorString = color;
		}

		public void draw(Graphics2D graphic) {

			setForegroundColor(colorString);
			graphic.fill(shape);
			setForegroundColor("black");
			Rectangle b = shape.getBounds();
			graphic.drawString(label, (float) (b.getX() + b.getWidth() / 2 - (label.length() / 2 * 6) - 4),
					(float) (b.getY() + b.getHeight() / 2 + 5));
		}
	}

}
