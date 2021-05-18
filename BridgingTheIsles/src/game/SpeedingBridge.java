package game;
import processing.core.PApplet;

/** 
 * Represents a straight, flat bridge. Vertically built by player when the space button is pressed and 
 * horizontally falls to connect the Person to the adjacent Isle
 * 
 * @author Samantha Sung
 * @version 5/17
*/
public class SpeedingBridge extends OriginalBridge {

	private double i = 0;

	/**
	 * Initializes the starting x-coordinate, length, angle, and movement variables of the bridge
	 * @param start the starting x-coordinate
	 */
	public SpeedingBridge(double start) {
		super(start);
	}
	
	/**
	 * Builds the bridge increasingly faster
	 * @param n initial increment for the bridge length 
	 */
	public void build(int n) {
		length+=n+i;
		i+=0.3;
	}
	
}