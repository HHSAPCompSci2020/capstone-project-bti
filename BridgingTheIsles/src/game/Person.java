package game;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

import processing.core.PApplet;
import processing.core.PImage;

/** Represents Person as he/she walks across OriginalBridge and Isle
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 1
*/
public class Person{

	private float x;
	private float y;

	private double xVelocity;
	private double yVelocity;
	
	public Person(int x, int y) {
		this.x = x;
		this.y = y;
		xVelocity = 0;
	}
	
	public void draw(PApplet surface) {
		surface.circle(x, y, 40);
		surface.line(x, y+20, x, y+50); 
		surface.line(x-15, y+35, x+15, y+35); 
		surface.line(x, y+50, x-15, y+65); 
		surface.line(x, y+50, x+15, y+65); 
	}
	

	
	public void walk(int dir) {
		if (xVelocity <= 10 && xVelocity >= -10)
			xVelocity += dir;
	}
	
	public void shift() {
		x = 20; 
	}
	
	public void loseLife(int dir) {
		if (yVelocity <= 10 && yVelocity >= -10)
			yVelocity += dir;
	}
	
	public void act() {

	}
	
	
	
	
}
