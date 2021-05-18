package game;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * Displays the buttons and points after all lives are lost
 * @author Kasturi Sinha
 * @version 5/14
 *
 */
public class DeadScreen extends Screen {

	private DrawingSurface surface;
	private Rectangle restartGame, backToMenu, exit;
	private int points; 
	private int level;
	private Main w; 
	
	/** 
	 * Instantiates all of DeadScreen's fields, including the buttons
	 * @param surface PApplet onto which the menu will be drawn 
	 */
	public DeadScreen(DrawingSurface surface, int points, int level, Main w) {
		super(800,600);
		this.w = w; 
		this.points = points; 
		this.surface = surface;
		this.level = level;
		restartGame = new Rectangle(800/2-100,600/2-80,200,100);
		backToMenu = new Rectangle(800/2-100,600/2+30,200,100);
		exit = new Rectangle(800/2-100,600/2+140,200,100);
	}

	/**
	 * Draws all of the objects onto the DrawingSurface
	 */
	public void draw() {
		surface.pushStyle();	
		surface.background(255,255,255);
		
		surface.fill(255);
		surface.rect(restartGame.x, restartGame.y, restartGame.width, restartGame.height, 10, 10, 10, 10);
		surface.rect(backToMenu.x, backToMenu.y, backToMenu.width, backToMenu.height, 10, 10, 10, 10);
		surface.rect(exit.x, exit.y, exit.width, exit.height, 10, 10, 10, 10);
		
		surface.fill(0);
		String str = "Restart Game";
		float w = surface.textWidth(str);
		String str2 = "Back to Menu";
		float w2 = surface.textWidth(str2);
		String str3 = "Exit Game";
		float w3 = surface.textWidth(str3);
		
		surface.textSize(15);
		surface.textLeading(11);
		surface.text(str, restartGame.x+restartGame.width/2-w/2, restartGame.y+restartGame.height/2);
		surface.text(str2, backToMenu.x+backToMenu.width/2-w2/2, backToMenu.y+backToMenu.height/2);
		surface.text(str3, exit.x+exit.width/2-w3/2, exit.y+exit.height/2);
		
		String pointsEarned = "Points Earned: " + points;
		surface.text(pointsEarned, 10, 20, 800, 600);		
		surface.popStyle();
	}
	
	/**
	 * Switches screen when mouse is pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (restartGame.contains(p)) {
			surface.screens.set(level, new GameScreen(surface, level, w)); //edit this when it works out 
			surface.switchScreen(level);
		}	else if (backToMenu.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		}	else if (exit.contains(p)) {
			w.exit();
			//surface.switchScreen(ScreenSwitcher.SCREEN3);
		}
	}
	
	public void instantiateMain() {
		
	}
			
}
