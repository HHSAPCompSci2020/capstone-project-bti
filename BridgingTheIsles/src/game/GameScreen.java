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
	private LifeCounter lives;
	private PointSystem points;
	
	public GameScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		
		person = new Person(60, 300);
		isle1 = new Isle(true, 40);
		bridge = new OriginalBridge(isle1.startX+isle1.width);
		isle2 = new Isle(false, isle1.startX+isle1.width);
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
		person.draw(surface);
		bridge.draw(surface);
		isle1.draw(surface);
		isle2.draw(surface);

		surface.fill(50);
		surface.text(("Points: " + Double.toString(points.points)), 40, 40, 70, 80);  // Text wraps within text box
		surface.text(("Lives left: " + Double.toString(lives.lifeCount)), 40, 60, 70, 80);  // Text wraps within text box
	
		if(surface.isPressed(KeyEvent.VK_SPACE)) {
			bridge.build(10);
		}
		if(surface.isPressed(KeyEvent.VK_ENTER)) {
			bridge.fall(false);
			person.walk(bridge.getEndCoordinate());
			determineCourse();
		}
	}
	
	
	/**
	 * Determines if Person dies or moves to next level
	 */
	private void determineCourse() {
		points.incrementPoints(isle2.detectBridge(bridge.getEndCoordinate()));
		if (isle2.detectBridge(bridge.getEndCoordinate()) == 0) {
			person.loseLife();
			lives.removeLife();
			bridge.fall(true);
		}
		else {
			newLevel();
		}
	}
	
	/**
	 * Creates new Isle and OriginalBridge once Person overcomes previous one
	 */
	private void newLevel() {
		if (points.points % 20 == 0) 
			lives.addLife();
		person.shift(bridge.getEndCoordinate()-isle2.startX);
		isle1 = isle2;
		isle1.shift();
		isle2 = new Isle(false, isle1.startX+isle1.width);
		bridge = new OriginalBridge(isle1.startX+isle1.width);
	}
	

	
}