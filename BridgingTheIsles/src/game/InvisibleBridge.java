package game;
import processing.core.PApplet;

/** 
 * Represents a straight, flat bridge. Vertically built by player when the space button is pressed and 
 * horizontally falls to connect the Person to the adjacent Isle
 * 
 * @author Samantha Sung
 * @version 5/15
*/
public class InvisibleBridge extends OriginalBridge {

	/**
	 * Initializes the starting x-coordinate, length, angle, and movement variables of the bridge
	 * @param start the starting x-coordinate
	 */
	public InvisibleBridge(double start) {
		super(start);
	}
	
	/**
	 * Draws the bridge. This will only happen after the player has stopped pressing Space.
	 * @param surface PApplet onto which the bridge will be drawn
	 */
	public void draw(PApplet surface) {
		surface.stroke(102, 51, 0);
		surface.strokeWeight(2);
		if(super.falling || super.fallingAllTheWay) {
			surface.line((float)startX, 400, (float)(startX+Math.cos(angle)*length), (float)(400-Math.sin(super.angle)*length));
		}
		
	}
	
}
