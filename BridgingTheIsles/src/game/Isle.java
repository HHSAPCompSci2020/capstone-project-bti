package game;
import processing.core.PApplet;

/** 
 * Represents an isle in the game. Allows for new isle form when bridge has been made on the previous isle.
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @version 5/14
 */

public class Isle{

	protected double startX;
	protected double width;
	private boolean shifting;
	private double path;
	protected int dir; 
	private double goalX;
	private double middle; 

	/**
	 * Instantiates the width, starting x-coordinate, and other vars of Isle according to parameters
	 * @param dir the direction the island will go (0 = going out of left frame, 1 = going to first position, 2 = going to second position, 3 = not moving, 4 = not moving first isle)
	 * @param bounds the most left spot the island can be
	 */
	public Isle(int dir, double bounds) {
		width = Math.random() * 200 + 20; 
		if (dir == 4)
			startX = bounds;
		else 
			startX = bounds+Math.random() * 300 + 60;

		if(dir == 2){
			goalX = startX;
			startX = 1000;
		}

		shifting = false;
		this.dir = dir;
		path = 0;
		middle = startX + width / 2;
	}

	/**
	 * Determines how many points the player should receive according to where the bridge lands
	 * @param x x-coordinate of where the bridge lands 
	 * @return the number of points player should receive
	 */
	public int detectBridge(double x) {
		if (x >= middle - width / 6 && x <= middle + width / 6) 
			return 3;
		else if (x >= middle - width / 3 && x <= middle + width / 3) 
			return 2;
		else if (x >= startX && x <= startX + width) 
			return 1;
		else
			return 0;	
	}

	/**
	 * Draws the Isle
	 * @param surface PApplet onto which the Isle will be drawn 
	 */
	public void draw(PApplet surface) {
		middle = startX + width / 2;
		surface.strokeWeight(1);
		surface.fill(204, 255, 51);
		surface.stroke(0, 0, 0);
		surface.rect((float)startX, 400, (float)width, 150);
		
		surface.strokeWeight(6);
		surface.stroke(255, 51, 0);
		surface.line((float)startX, 400f, (float)(startX + width), 400f);
		surface.stroke(255, 153, 0);
		surface.line((float)(middle - width / 3), 400f, (float)(middle + width / 3), 400f);
		surface.stroke(0, 255, 0);
		surface.line((float)(middle - width / 6) , 400f, (float)(middle + width / 6), 400f);
 
	}

	/**
	 * Shifts the isle over when the player successfully makes it
	 * @param path the path of the person to make sure the island moves with it
	 */
	public void shift(double path) {
		shifting = true;
		this.path = path;
	}

	/**
	 * Shifts the Isle as necessary
	 */
	public void act() {
		if (shifting) {
			path-=4;
			if(path <= 4) {
				startX -= 10;
				if(dir == 1 && startX <= 70)
					shifting = false;
				else if (dir == 0 && startX <= -800)
					shifting = false;
				else if (dir == 2 && startX <= goalX + 10) {
					shifting = false;
				}
			}	
		}
	}
}