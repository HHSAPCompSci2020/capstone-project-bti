package game;
import processing.core.PApplet;

/**
 * Switches between screens
 * @author Samantha Sung
 * @version 5/13
 *
 */
public abstract class Screen{

	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		
	}
	
	public void mousePressed() {
		
	}
	
	public void keyReleased() {
		
	}
	
	
}
