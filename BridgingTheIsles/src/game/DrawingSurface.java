package game;
import java.awt.Point;
import java.util.ArrayList;

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

public class DrawingSurface extends PApplet implements ScreenSwitcher{
	
	public float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	/**
	 * Instantiates all the objects of the game
	 */
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		
		keys = new ArrayList<Integer>();
		
		MenuScreen screen1 = new MenuScreen(this);
		screens.add(screen1);
		
		GameScreen screen2 = new GameScreen(this);
		screens.add(screen2);
		
		activeScreen = screens.get(0);
		
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
		
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		pushMatrix();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		popMatrix();
	}

	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}
	
	@Override
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
		
	}

}
