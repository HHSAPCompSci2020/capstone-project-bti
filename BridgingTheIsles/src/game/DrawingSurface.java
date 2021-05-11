package game;
import processing.core.PApplet;

/** 
 * Displays the instructions at the start of the game and any other button necessary during the game. 
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
	
	/**
	 * Instantiates all the objects of the game
	 */
	public DrawingSurface() {
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
		background(255,255,255);
		person.draw(this);
		bridge.draw(this);
		isle1.draw(this);
		isle2.draw(this);

		fill(50);
		text(("Points: " + Double.toString(points.points)), 40, 40, 70, 80);  // Text wraps within text box
		text(("Lives left: " + Double.toString(lives.lifeCount)), 40, 60, 70, 80);  // Text wraps within text box
	}
	
	
	/**
	 * Determines if Person dies or moves to next level
	 */
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
	
	/**
	 * Creates new Isle and OriginalBridge once Person overcomes previous one
	 */
	public void newLevel() {
		if (points.points % 20 == 0) 
			lives.addLife();
		person.shift(bridge.getEndCoordinate()-isle2.startX);
		isle1 = isle2;
		isle1.shift();
		isle2 = new Isle(false, isle1.startX+isle1.width);
		bridge = new OriginalBridge(isle1.startX+isle1.width);
	}
	
	/**
	 * Builds the bridge when the space key is pressed
	 */
	public void keyPressed() {	
		if (keyCode == ' ')
			bridge.build(10);
	}
	
	/**
	 * When space key is released, the OriginalBridge falls, Person walks and the course is determined 
	 */
	public void keyReleased() {
		bridge.fall();
		person.walk(bridge.getEndCoordinate());
		determineCourse();
	}

}
