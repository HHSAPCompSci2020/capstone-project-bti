package game;
import processing.core.PApplet;

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
		width = Math.random() * 200; 
		startX = Math.random() * 400 + 40; 
	}
	
	public Isle(double start) {
		width = Math.random() * 200 + 20; 
		startX = start;
	}
	
	public int detectBridge(int x) {
		double middle = startX+width/2;
		if (x >= middle-width/6 && x <= middle+width/6) 
			return 3;
		else if (x >= middle-width/3 && x <= middle+width/3) 
			return 2;
		else if (x >= startX && x >= startX+width) 
			return 1;
		else
			return 0;
	}
	
	public void draw(PApplet surface) {
		surface.rect((float)startX, 300, (float)width, 150);
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
