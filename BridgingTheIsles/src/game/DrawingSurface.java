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
	private LifeCounter lives;
	private PointSystem points;
	
	
	public DrawingSurface() {
		super();
		person = new Person(60, 50);
		bridge = new OriginalBridge(60);
		isle = new Isle();
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
	}

//	public void spawnNewPerson() {
//		person = new Person(20, 20);
//	}
	
	public void setup() {
		//size(0,0,PApplet.P3D);
	}
	
	public void draw() {
		background(255,255,255);
		person.draw(this);
		bridge.draw(this);
		isle.draw(this);
		
		
	
	}
	
	public void keyPressed() {	
		if (key == CODED) {
			if (key == ' ') 
			bridge.build();
	}
//	public void keyPressed() {
//		keys.add(keyCode);
//	}
//
//	public void keyReleased() {
//		while(keys.contains(keyCode))
//			keys.remove(new Integer(keyCode));
//	}
//
//	public boolean isPressed(Integer code) {
//		return keys.contains(code);
//	}

	}
}
