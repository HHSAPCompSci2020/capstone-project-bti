package game;

import processing.core.PApplet;

/** Represents a straight, flat bridge. Vertically built by player when the space button is pressed and 
 * horizontally falls to connect the Person to the adjacent Isle
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 1
*/
public class OriginalBridge{

	private double startX;
	private double length;
	private double angle;
	
	public OriginalBridge() {
		startX = 40;
		length = 0;
		angle = Math.PI/2;
	}
	
	public OriginalBridge(double start) {
		startX = start;
		length = 0;
		angle = Math.PI/2;
	}
	
	public void draw(PApplet surface) {
		surface.line((float)startX, 300, (float)(startX+Math.cos(angle)*length), (float)(300-Math.sin(angle)*length));
	}
	
	public double getEndCoordinate() {
		return startX+length;
	}
	
	public void build(int n) {
		length+=n;
	}
	
	public void fall() {
		while(angle >= 0)
		angle-=0.01;
	}
	
}
