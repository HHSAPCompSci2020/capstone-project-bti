package game;


import java.awt.event.*;
import java.util.ArrayList;

import processing.core.PApplet;



public class GameScreen extends Screen {
	
	
	private DrawingSurface surface;
	
	private Person person;
	private OriginalBridge bridge;
	private Isle isle1;
	private Isle isle2;
	private Isle tempIsle;
	private PointSystem points;
	private LifeCounter lives;
	
	public GameScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		
		person = new Person(80, 400);
		isle1 = new Isle(4, 60);
		bridge = new OriginalBridge(isle1.startX+isle1.width);
		isle2 = new Isle(3, isle1.startX+isle1.width);
		tempIsle = isle1;
		points = new PointSystem();
		lives = new LifeCounter();
	}
	
	
	
	/**
	 * Sets up the game in the beginning 
	 */
	public void setup() {
		//perhaps unnecessary
	}
	
	/**
	 * Draws all of the objects onto the DrawingSurface
	 */
	public void draw() {

		surface.background(255);
		isle1.draw(surface);
		isle2.draw(surface);
		tempIsle.draw(surface);
		bridge.draw(surface);
		person.draw(surface);
		
		bridge.act();
		isle1.act();
		isle2.act();
		tempIsle.act();
		person.act();

		surface.fill(50);
		surface.text(("Points: " + Integer.toString(points.points)), 40, 40, 70, 80);  // Text wraps within text box
		surface.text(("Lives left: " + Integer.toString(lives.lifeCount)), 40, 60, 70, 80);  // Text wraps within text box

		if(surface.isPressed(KeyEvent.VK_SPACE)) {
			bridge.startX = 58+isle1.width;
			bridge.build(5);
		}
	}

	public void keyReleased() {
		int p = isle2.detectBridge(bridge.getEndCoordinate());
		int previous = points.points;
		points.incrementPoints(p);
		int n = points.points/20;
		if (previous < 20*n && points.points >= 20*n) 
			lives.addLife();
		
		bridge.fall(0);
		person.walk(bridge.getEndCoordinate());
			
		if (p > 0) {
			person.shift(bridge.getEndCoordinate()-isle2.startX);
			tempIsle = isle1;
			tempIsle.dir = 0;
			tempIsle.doNotShift(bridge.getEndCoordinate()-person.x);
			tempIsle.shift();
			isle1 = isle2;
			isle1.dir = 1;
			isle1.doNotShift(bridge.getEndCoordinate()-person.x);
			isle1.shift();
			isle2 = new Isle(2, 58+isle1.startX);
			isle2.doNotShift(bridge.getEndCoordinate()-person.x);
			isle2.shift();
		}	
		if (p == 0) {
			bridge.fall(-Math.PI/2);
			person.loseLife();
			lives.removeLife();
		}
			
	}
	
}
	
