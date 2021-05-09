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

	private double x;
	private double y;

//	private double xVelocity;
//	private double yVelocity;
	
	public Person(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(PApplet surface) {
		surface.circle((float)x, (float)y, 40);
		surface.line((float)x, (float)y+20, (float)x, (float)y+50); 
		surface.line((float)x-15, (float)y+35, (float)x+15, (float)y+35); 
		surface.line((float)x, (float)y+50, (float)x-15, (float)y+65); 
		surface.line((float)x, (float)y+50,(float)x+15, (float)y+65); 
	}
	

	
	public void walk(double endSpot) {
		while (x < x+endSpot) {
			x+=10;
		}	
	}
	
	public void shift(double spotOnIsle) {
		x = 40+spotOnIsle; 
	}
	
	public void loseLife(int dir) {
		while (y > 0) {
			y-=10;
		}
	}
	
	public void act() {

	}
	
	
	
	
}
