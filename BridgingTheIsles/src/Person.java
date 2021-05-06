
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

import processing.core.PImage;

public class Person extends MovingImage {

	public static final int PERSON_WIDTH = 40;
	public static final int PERSON_HEIGHT = 60;

	private double xVelocity;
	
	public Person(PImage img, int x, int y) {
		super(img, x, y, PERSON_WIDTH, PERSON_HEIGHT);
		xVelocity = 0;
	}
	
	//METHODS
	public void walk(int dir) {
		if (xVelocity <= 10 && xVelocity >= -10)
			xVelocity += dir;
	}
	
	public void loseLife() {
		
	}
	
	public void act() {

	}
	
	
	
}
