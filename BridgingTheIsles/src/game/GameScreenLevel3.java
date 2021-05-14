package game;
import java.awt.event.*;
import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Displays the game 
 * @author Samantha Sung
 * @author Kasturi Sinha
 * @version 5/14
 */
public class GameScreenLevel3 extends Screen {
	
	
	private DrawingSurface surface;
	private Person person;
	private OriginalBridge bridge;
	private Isle isle1;
	private Isle isle2;
	private Isle tempIsle;
	private PointSystem points;
	private LifeCounter lives;
	
	/**
	 * Instantiates all of GameScreen's fields 
	 * @param surface PApplet onto which the game will be drawn 
	 */
	public GameScreenLevel3(DrawingSurface surface) {
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

		surface.background(102, 255, 255);
		surface.fill(0, 0, 255);
		surface.rect(0, 500, 800, 500);
		
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
			bridge.startX = isle1.startX+isle1.width;
			bridge.build(5);
		}
	}

	/**
	 * Acts according to whether the bridge falls on the island
	 */
	public void keyReleased() {
		int p = isle2.detectBridge(bridge.getEndCoordinate());
		int previous = points.points;
		points.incrementPoints(p);
		int n = points.points/20;
		if (previous < 20*n && points.points >= 20*n) 
			lives.addLife();
		
		person.walk(bridge.getEndCoordinate());
		bridge.fall(bridge.getEndCoordinate()-person.x);
			
		if (p > 0) {
			person.shift(bridge.getEndCoordinate()-isle2.startX);
			tempIsle = isle1;
			tempIsle.dir = 0;
			tempIsle.shift(bridge.getEndCoordinate()-person.x);
			isle1 = isle2;
			isle1.dir = 1;
			isle1.shift(bridge.getEndCoordinate()-person.x);
			isle2 = new Isle(2, 60+isle1.width);
			isle2.shift(bridge.getEndCoordinate()-person.x);
		}	
		if (p == 0) {
			bridge.fallDown();
			person.loseLife();
			lives.removeLife();
			
			if(lives.lifeCount > 0) {
				bridge.revive();
				person.revive();
			}
		}		
	}
	
}
	
