package game;
import processing.core.PApplet;

/** 
 * Represents a straight, flat bridge. Vertically built by player when the space button is pressed and 
 * horizontally falls to connect the Person to the adjacent Isle
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 5/10
*/
public class OriginalBridge{

	protected double startX;
	protected double length;
	protected double angle;
	
	/**
	 * Initializes the starting x-coordinate, length and angle of the bridge to pre-set values
	 */
	public OriginalBridge() {
		startX = 40;
		length = 0;
		angle = Math.PI/2;
	}
	
	/**
	 * Initializes the starting x-coordinate, length and angle of the bridge
	 * @param start the starting x-coordinate
	 */
	public OriginalBridge(double start) {
		startX = start;
		length = 0;
		angle = Math.PI/2;
	}
	
	/**
	 * Draws the bridge 
	 * @param surface PApplet onto which the bridge will be drawn
	 */
	public void draw(PApplet surface) {
		surface.strokeWeight(2);
		surface.line((float)startX, 300, (float)(startX+Math.cos(angle)*length), (float)(300-Math.sin(angle)*length));
	}
	
	/**
	 * Returns the end coordinate of the bridge
	 * @return end coordinate of bridge
	 */
	public double getEndCoordinate() {
		return startX+length;
	}
	
	/**
	 * Builds the bridge according to the specified parameter when space key is pressed
	 * @param n increment for the bridge length 
	 */
	public void build(int n) {
		length+=n;
	}
	
	/**
	 * Displays the bridge falling
	 * @param pass whether the bridge passes to next level
	 */
	public void fall(boolean pass) {
		if (!pass) {
			while (angle >= 0)
			angle-=0.01;
		}
		else {
			while(angle >= -Math.PI/2)
				angle-=0.01;
		}
			
	}
}
