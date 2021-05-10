package game;
import processing.core.PApplet;

/** Displays the instructions at the start of the game and any other button necessary during the game. 
 * Sets the background at the start of the game.
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 5/10
*/

public class DrawingSurface extends PApplet{
		
	private Person person;
	private OriginalBridge bridge;
	private Isle isle1;
	private Isle isle2;
	private LifeCounter lives;
	private PointSystem points;
	
	
	public DrawingSurface() {
		person = new Person(60, 300);
		isle1 = new Isle(true, 40);
		bridge = new OriginalBridge(isle1.startX+isle1.width);
		isle2 = new Isle(false, isle1.startX+isle1.width);
		points = new PointSystem();
		lives = new LifeCounter();
	}

	
	public void setup() {
	}
	
	public void draw() {
		background(255,255,255);
		person.draw(this);
		bridge.draw(this);
		isle1.draw(this);
		isle2.draw(this);
		System.out.println(points.points);
		System.out.println(lives.lifeCount);
	}
	
	public void determineCourse() {
		points.incrementPoints(isle2.detectBridge(bridge.getEndCoordinate()));
		if (isle2.detectBridge(bridge.getEndCoordinate()) == 0) {
			person.loseLife();
			lives.removeLife();
		}
		else {
			newLevel();
		}
	}
	
	public void newLevel() {
		if (points.points % 20 == 0) 
			lives.addLife();
		person.shift(bridge.getEndCoordinate()-isle2.startX);
		isle1 = isle2;
		isle1.shift();
		isle2 = new Isle(false, isle1.startX+isle1.width);
		bridge = new OriginalBridge(isle1.startX+isle1.width);
	}
	
	public void keyPressed() {	
		if (keyCode == ' ')
			bridge.build(10);
	}
	
	public void keyReleased() {
		bridge.fall();
		person.walk(bridge.getEndCoordinate());
		determineCourse();
	}

}
