package game;
import processing.core.PApplet;

/** Represents an isle in the game. Allows for new isle form when bridge has been made to previous isle.
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 5/10
*/

public class Isle{

	protected double startX;
	protected double width;
	
	public Isle() {
		width = Math.random() * 200+20; 
		startX = Math.random() * 400 + 40; 
	}
	
	public Isle(boolean start, double bounds) {
		width = Math.random() * 200 + 20; 
		if (start)
			startX = bounds;
		else
			startX = bounds+Math.random()*200+40;
	}
	
	public int detectBridge(double x) {
		double middle = startX+width/2;
		if (x >= middle-width/6 && x <= middle+width/6) 
			return 3;
		else if (x >= middle-width/3 && x <= middle+width/3) 
			return 2;
		else if (x >= startX && x <= startX+width) 
			return 1;
		else
			return 0;
	}
	
	public void draw(PApplet surface) {
		surface.strokeWeight(1);
		surface.fill(204, 255, 204);
		surface.rect((float)startX, 300, (float)width, 150);
	}
	
	public void shift() {
		startX = 40; 
	}
}
