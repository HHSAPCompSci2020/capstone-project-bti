package game;
import processing.core.PApplet;

/** 
 * Represents a straight, flat bridge. Vertically built by player when the space button is pressed and 
 * horizontally falls to connect the Person to the adjacent Isle
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 5/13
*/
public class OriginalBridge{

	protected double startX;
	protected double length;
	private double angle;
	private boolean falling;
	private boolean fallingAllTheWay;
	private boolean reviving;
	private double path;
	
	/**
	 * Initializes the starting x-coordinate, length and angle of the bridge to pre-set values
	 */
	public OriginalBridge() {
		startX = 40;
		length = 0;
		angle = Math.PI/2;
		falling = false;
		fallingAllTheWay = false;
		reviving = false;
		path = 0;
	}
	
	/**
	 * Initializes the starting x-coordinate, length and angle of the bridge
	 * @param start the starting x-coordinate
	 */
	public OriginalBridge(double start) {
		startX = start;
		length = 0;
		angle = Math.PI/2;
		falling = false;
		fallingAllTheWay = false;
		reviving = false;
		path = 0;
	}
	
	/**
	 * Draws the bridge 
	 * @param surface PApplet onto which the bridge will be drawn
	 */
	public void draw(PApplet surface) {
		surface.stroke(102, 51, 0);
		surface.strokeWeight(2);
		surface.line((float)startX, 400, (float)(startX+Math.cos(angle)*length), (float)(400-Math.sin(angle)*length));
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
	 * @param path path of the person so the bridge falls with it
	 */
	public void fall(double path) {
		falling = true;
		this.path = path;
	}
	
	/**
	 * Sets fallingAllTheWay to true
	 */
	public void fallDown() {
		fallingAllTheWay = true;
	}
	
	/**
	 * Sets reviving to true
	 */
	public void revive() {
		reviving = true;
	}

	/**
	 * Determines what to do depending on whether the bridge is falling or falling all the way (reviving)
	 */
	public void act() {
		if (falling) {
			if(angle > 0.04)
				angle -= 0.04;
			path -= 4;
			if(path <= 4) {
				if(!fallingAllTheWay) {
					angle = Math.PI/2;
					length = 0;
				}
				falling = false;
			}
		}
		else if (fallingAllTheWay) {
			angle -= 0.04;
			if (angle <= -Math.PI/2+0.04) {
				if (reviving) {
					angle = Math.PI/2;
					length = 0;
					reviving = false;
				}
				fallingAllTheWay = false;
			}
		}
	}
	
}
