package game;
import processing.core.PApplet;

/** 
 * Represents an isle in the game. Allows for new isle form when bridge has been made to previous isle.
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 5/13
*/

public class Isle{

	protected double startX;
	protected double width;
	private boolean shifting;
	private double path;
	protected int dir; //0 = going out of left frame; 1 = going to first position; 2 = going to second position 3 = not moving 4 = not moving first isle
	private double goalX;
	
	/**
	 * Instantiates the width and starting x-coordinate of the island
	 */
	public Isle() {
		width = Math.random() * 200+20; 
		startX = Math.random() * 250 + 60; 
		shifting = false;
		path = 0;
		dir = 1;
		goalX = 700;
	}
	
	/**
	 * Instantiates the width and starting x-coordinate of Isle according to parameters
	 * @param start the starting x-coordinate of Isle 
	 * @param bounds 
	 */
	public Isle(int dir, double bounds) {
		width = Math.random() * 200 + 20; 
		if (dir == 4)
			startX = bounds;
		else 
			startX = bounds+Math.random() * 150 + 60;
		
		if(dir == 2){
			goalX = startX;
			startX = 1000;
		}
		
		shifting = false;
		this.dir = dir;
		path = 0;
	}
	
	/**
	 * Determines how many points the player should receive according to where the bridge lands
	 * @param x x-coordinate of where the bridge lands 
	 * @return the number of points player should recieve
	 */
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
	
	/**
	 * Draws the Isle
	 * @param surface PApplet onto which the Isle will be drawn 
	 */
	public void draw(PApplet surface) {
		surface.strokeWeight(1);
		surface.fill(204, 255, 204);
		surface.rect((float)startX, 400, (float)width, 150);
	}
	
	/**
	 * Shifts the isle over when the player successfully makes it
	 */
	public void shift(double path) {
		shifting = true;
		this.path = path;
	}

	
	public void act() {
		if (shifting) {
			path-=5;
			if(path <= 0) {
				startX -= 10;
				if(dir == 1 && startX <= 60)
					shifting = false;
				else if (dir == 0 && startX <= -1000)
					shifting = false;
				else if (dir == 2 && startX <= goalX) {
					shifting = false;
				}
			}	
		}
	}
}