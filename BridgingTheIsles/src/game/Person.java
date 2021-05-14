package game;
import processing.core.PApplet;

/** 
 * Represents Person as he/she walks across OriginalBridge and Isle
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 5/14
*/
public class Person {

	protected double x;
	protected double y;
	private boolean walking;
	private boolean dying;
	private boolean shifting;
	private boolean reviving;
	private double endSpot;
	private double shiftSpot;

	/**
	 * Initializes the coordinates of the Person and its other attributes
	 */
	public Person() {
		x = 80;
		y = 400;
		walking = false;
		dying = false;
		shifting = false;
		reviving = true;
		endSpot = 0;
		shiftSpot = 0;
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
		reviving = true;
		endSpot = 0;
		shiftSpot = 0;
	}
	
	/**
	 * Draws the Person onto the window 
	 * @param surface PApplet onto which the Person will be drawn
	 */
	public void draw(PApplet surface) {
		surface.fill(255, 102, 102);
		surface.stroke(0, 0, 0);
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
	 * @param spotOnIsle x-coordinate to which Person should be shift to
	 */
	public void shift(double spotOnIsle) {
		shiftSpot = spotOnIsle+60;
		shifting = true;
	}
	
	/**
	 * Person falls when life is lost
	 */
	public void loseLife() {
		dying = true;
	}
	
	public void revive() {
		reviving = true;
	}
	
	/**
	 * Determines if the person is walking, dying or shifting. 
	 */
	public void act() {
		if (walking) {
			x += 4;
			if (x >= endSpot-4) {
				walking = false;
			}
		}
		else if (dying) {
			y += 4;
			if (y >= 671) {
				if(reviving) {
					x = 80;
					y = 400;
					reviving = false;
				}
				dying = false;
			}
		}
		else if (shifting) {
			x-=10;
			if (x <= shiftSpot+10)
				shifting = false;
		}
	}

}
