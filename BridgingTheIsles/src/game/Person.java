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
		surface.circle((float)x, (float)y-55, 20);
		surface.line((float)x, (float)y-45, (float)x, (float)y-15); 
		surface.line((float)x-10, (float)y-30, (float)x+10, (float)y-30); 
		surface.line((float)x, (float)y-15, (float)x-10, (float)y); 
		surface.line((float)x, (float)y-15,(float)x+10, (float)y); 
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
