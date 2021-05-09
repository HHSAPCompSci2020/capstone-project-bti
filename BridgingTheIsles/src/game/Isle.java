package game;
import processing.core.PImage;

/** Represents an isle in the game. Allows for new isle form when bridge has been made to previous isle.
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 1
*/

public class Isle{

	double startX;
	double width;
	
	public Isle() {
		width = Math.random() * 50; 
		startX = Math.random() * 50 + 50; 
	}
	
	public void detectBridge() {
		
	}
	
	public void draw() {
		
	}
	
	public void shift() {
		startX = 40; 
	}
	
	public double getStartX() {
		return startX;
	}
	
	public double getWidth() {
		return width; 
	}
	
}
