package game;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;
import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Displays the game 
 * @author Samantha Sung
 * @author Kasturi Sinha
 * @version 5/14
 */
public class GameScreen extends Screen {
	
	
	private DrawingSurface surface;
	private Person person;
	private OriginalBridge bridge;
	private Isle isle1;
	private Isle isle2;
	private Isle tempIsle;
	private PointSystem points;
	private LifeCounter lives;
	
	private Rectangle restart;
	private Rectangle backToMenu; 
	
	/**
	 * Instantiates all of GameScreen's fields 
	 * @param surface PApplet onto which the game will be drawn 
	 */
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
		
		restart = new Rectangle(580, 150, 180, 40);
		backToMenu = new Rectangle(580, 200, 180, 40); //come back later
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

		surface.fill(204, 255, 255);
		surface.rect(580, 30, 180, 90);
		surface.fill(50);
		surface.textSize(20);
		surface.text(("Points: " + Integer.toString(points.points)), 600, 40, 800, 80);
		surface.text(("Lives left: " + Integer.toString(lives.lifeCount)), 600, 80, 700, 120); 

		if(surface.isPressed(KeyEvent.VK_SPACE)) {
			bridge.startX = isle1.startX+isle1.width;
			bridge.build(5);
		}
		
		surface.fill(255, 255, 255);
		surface.rect(restart.x, restart.y, restart.width, restart.height, 10, 10, 10, 10);
		surface.fill(50);
		surface.textSize(20);
		String str = "Restart";
		float w = surface.textWidth(str);
		surface.text(str, restart.x + restart.width / 2 - w / 2, restart.y + restart.height / 2 + 5);
		
		surface.fill(255, 255, 255);
		surface.rect(backToMenu.x, backToMenu.y, backToMenu.width, backToMenu.height, 10, 10, 10, 10);
		surface.fill(50);
		surface.textSize(20);
		String str2 = "Back to Menu";
		float w1 = surface.textWidth(str2);
		surface.text(str2, backToMenu.x + backToMenu.width / 2 - w1 / 2, backToMenu.y + backToMenu.height/2 + 5);
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
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (restart.contains(p)) {
			surface.screens.set(1, new GameScreen(surface));
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		} else if (backToMenu.contains(p)) {
			//surface.screens.set(0, new MenuScreen(surface));
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		}
	}
	
}
	
