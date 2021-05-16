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
	
	/**
	 * Instantiates all of DeadScreen's fields, including the buttons
	 * @param surface PApplet onto which the menu will be drawn 
	 */
	public DeadScreen(DrawingSurface surface, int points, int level) {
		super(800,600);
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
		
		//Print instructions
		String pointsEarned = "Points Earned:" + points;
		surface.text(pointsEarned, 10, 20, 800, 600);		
		surface.popStyle();
	}
	
	/**
	 * Switches screen when mouse is pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (restartGame.contains(p)) {
			surface.screens.set(1, new GameScreen(surface, level)); //edit this when it works out 
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		}	else if (backToMenu.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		}	else if (exit.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SCREEN4);
		}
	}
			
}
