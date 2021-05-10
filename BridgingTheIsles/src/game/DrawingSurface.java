package game;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import processing.core.PApplet;

/** Displays the instructions at the start of the game and any other button necessary during the game. 
 * Sets the background at the start of the game.
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 1
*/

public class DrawingSurface extends PApplet{
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	
	private Rectangle screenRect;
	
	private Person person;
	private OriginalBridge bridge;
	private Isle isle;
	private Isle isle2;
	private LifeCounter lives;
	private PointSystem points;
	private Isle[] isles;
	
	
	public DrawingSurface() {
		person = new Person(60, 300);
		isles = new Isle[2];
		isles[0] = new Isle(true, 40);
		bridge = new OriginalBridge(isles[0].getStartX()+isles[0].getWidth());
		isles[1] = new Isle(false, isles[0].getStartX()+isles[0].getWidth());
		points = new PointSystem();
		lives = new LifeCounter();
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
	}

	
	public void setup() {
		//size(0,0,PApplet.P3D);
	}
	
	public void draw() {
		background(255,255,255);
		person.draw(this);
		bridge.draw(this);
		isles[0].draw(this);
		isles[1].draw(this);
	}
	
	public void determineCourse() {
		points.incrementPoints(isles[1].detectBridge(bridge.getEndCoordinate()));
		if (isles[1].detectBridge(bridge.getEndCoordinate()) == 0) {
			person.loseLife();
			lives.removeLife();
		}
		else {
			newLevel();
		}
	}
	
	public void newLevel() {
		if (points.getPoints() % 20 == 0) 
			lives.addLife();
		person.shift(bridge.getEndCoordinate()-isles[1].getStartX());
		isles[0] = isles[1];
		isles[0].shift();
		isles[1] = new Isle(false, isles[0].getStartX()+isles[0].getWidth());
		bridge = new OriginalBridge(isles[0].getStartX()+isles[0].getWidth());
	}
	
	public void keyPressed() {	
		if (keyCode == ' ')
			bridge.build(5);
	}
	
	public void keyReleased() {
		bridge.fall();
		person.walk(bridge.getEndCoordinate());
		determineCourse();
	}

}
