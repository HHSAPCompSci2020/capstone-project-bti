package game;
import processing.core.PApplet;

/** 
 * Represents Person as he/she walks across OriginalBridge and Isle
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 5/11
*/
public class Person {

	protected double x;
	protected double y;
	private boolean walking;
	private boolean dying;
	private boolean shifting;
	private double endSpot;
	private double beginSpot;

	public Person() {
		x = 60;
		y = 300;
		walking = false;
		dying = false;
		shifting = false;
		endSpot = 0;
		beginSpot = 0;
	}
	
	/**
	 * Initializes the coordinates of the Person 
	 * @param x the x-coordinate to which the Person should be instantiated 
	 * @param y the y-coordinate to which the Person should be instantiated 
	 */
	public Person(int x, int y) {
		this.x = x;
		this.y = y; 
		walking = false;
		dying = false;
		shifting = false;
		endSpot = 0;
		beginSpot = 0;
	}
	
	/**
	 * Draws the Person onto the window 
	 * @param surface PApplet onto which the Person will be drawn
	 */
	public void draw(PApplet surface) {
		surface.fill(255, 102, 102);
		surface.strokeWeight(1);
		surface.circle((float)x-10, (float)y-55, 20);
		surface.line((float)x-10, (float)y-45, (float)x-10, (float)y-15); 
		surface.line((float)x-20, (float)y-30, (float)x, (float)y-30); 
		surface.line((float)x-10, (float)y-15, (float)x-20, (float)y); 
		surface.line((float)x-10, (float)y-15,(float)x, (float)y); 
	}
	
	/**
	 * Person walks to the next Isle
	 * @param endSpot where Person should stop walking
	 */
	public void walk(double end) {
		endSpot = end;
		walking = true;
	}
	
	/**
	 * Shifts Person when new Isle pops up on screen 
	 * @param spotOnIsle x-coordinate to which Person should be teleported to
	 */
	public void shift(double spotOnIsle) {
		beginSpot = spotOnIsle;
		shifting = true;
	}
	
	/**
	 * Person falls when life is lost
	 */
	public void loseLife() {
		dying = true;
	}
	
	public void act() {
		if (dying) {
			y += 5;
			if (y <= 0) 
				dying = false;
		}
		else if(walking) {
			x+= 5;
			if (x >= endSpot)
				walking = false;
		}
		else if(shifting) {
			x-=10;
			if (x <= 60+beginSpot)
				shifting = false;
		}
	}

}
