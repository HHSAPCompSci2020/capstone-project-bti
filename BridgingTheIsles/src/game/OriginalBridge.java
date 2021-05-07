package game;
import processing.core.PImage;

/** Represents a straight, flat bridge. Vertically �built� by player when the space button is pressed and 
 * horizontally falls to connect the Person to the adjacent Isle
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 1
*/
public class OriginalBridge extends MovingImage{

	double length;
	
	public OriginalBridge(PImage img, int x, int y, int w, int h) {
		super(img, x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public int getEndCoordinate() {
		return 0;
	}
	
	public void build() {
		
	}
	
	public void draw() {
		
	}
	
	public void fall() {
		
	}
	
}
