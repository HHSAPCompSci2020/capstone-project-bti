package game;

/**
 * Represents a screen in the game
 * @author Riya Gupta
 * @version 5/13
 *
 */
public abstract class Screen{

	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	
	/**
	 * Initializes dimensions of the screen
	 * @param width width of the screen
	 * @param height height of the screen
	 */
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	
	/**
	 * Sets up the game in the beginning 
	 */
	public void setup() {	
	}
	
	/**
	 * Draws all of the objects onto the DrawingSurface
	 */
	public void draw() {
		
	}
	
	/**
	 * Acts according to which button is pressed
	 */
	public void mousePressed() {
		
	}
	
	/**
	 * Acts according to whether the space button is released
	 */
	public void keyReleased() {
		
	}
	
	
}
