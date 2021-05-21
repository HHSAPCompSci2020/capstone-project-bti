package game;
import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;

/** 
 * Displays the instructions at the start of the game and any other button necessary during the game. 
 * Sets the background at the start of the game.
 * 
 * @author Riya Gupta
 * @version 5/14
*/

public class DrawingSurface extends PApplet implements ScreenSwitcher{
	
	/**
	 * Ratio of the width and height of the screen to the active screen 
	 */
	public float ratioX, ratioY;
	private Main w; 
	private ArrayList<Integer> keys;
	private Screen activeScreen;
	protected ArrayList<Screen> screens;
	
	/**
	 * Instantiates all the objects of the game
	 */
	public DrawingSurface(Main w) {
		this.w = w;
		screens = new ArrayList<Screen>();	
		keys = new ArrayList<Integer>();
		
		MenuScreen screen1 = new MenuScreen(this, w);
		screens.add(screen1);
		
		GameScreen screen2 = new GameScreen(this, 1, w);
		screens.add(screen2);
		
		GameScreen screen3 = new GameScreen(this, 2, w);
		screens.add(screen3);
		
		GameScreen screen4 = new GameScreen(this, 3, w);
		screens.add(screen4);
		
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
		
		ratioX = (float)width / activeScreen.DRAWING_WIDTH;
		ratioY = (float)height / activeScreen.DRAWING_HEIGHT;

		pushMatrix();
		scale(ratioX, ratioY);	
		activeScreen.draw();
		popMatrix();
	}

	/**
	 * When a key is pressed, it is added to ArrayList keys
	 */
	public void keyPressed() {
		keys.add(keyCode);
	}

	/**
	 * When keys contain the specified key, 
	 * it will be removed and the keyReleased for the activeScreen 
	 * will be called
	 */
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
		activeScreen.keyReleased();
	}

	/**
	 * 
	 * @param code the key that is supposedly pressed
	 * @return if the specified key is pressed
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	/**
	 * Calls the mousePressed() of the activeScreen
	 */
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	/**
	 * Converts actual coordinates to the assumed
	 * @param actual the actual point
	 * @return the button point
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX() / ratioX) , (int)(actual.getY() / ratioY));
	}

	
	@Override
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}
