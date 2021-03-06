package game;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * Displays the buttons and points after all lives are lost
 * @author Kasturi Sinha
 * @version 5/21
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
	 * @param points Points player received
	 * @param level Version of the game (original, invisible, or speeding)
	 * @param w Main Class
	 */
	public DeadScreen(DrawingSurface surface, int points, int level, Main w) {
		super(800,600);
		this.w = w; 
		this.points = points; 
		this.surface = surface;
		this.level = level;
		
		restartGame = new Rectangle(800 / 2 - 150, 600 / 2 - 80 + 20, 300, 100);
		backToMenu = new Rectangle(800 / 2 - 150, 600 / 2 + 30 + 20, 300, 100);
		exit = new Rectangle(800 / 2 - 150, 600 / 2 + 140 + 20, 300, 100);
	}

	/**
	 * Draws all of the objects onto the DrawingSurface
	 */
	public void draw() {
		surface.pushStyle();	
		surface.background(204, 255, 255);
		
		surface.fill(102, 255, 255);
		surface.rect(restartGame.x, restartGame.y, restartGame.width, restartGame.height, 10, 10, 10, 10);
		surface.rect(backToMenu.x, backToMenu.y, backToMenu.width, backToMenu.height, 10, 10, 10, 10);
		surface.rect(exit.x, exit.y, exit.width, exit.height, 10, 10, 10, 10);
		
		surface.fill(0);
		surface.textSize(30);
		String str = "Restart Game";
		float w = surface.textWidth(str);
		String str2 = "Back to Menu";
		float w2 = surface.textWidth(str2);
		String str3 = "Exit Game";
		float w3 = surface.textWidth(str3);
		
		surface.textLeading(11);
		surface.text(str, restartGame.x  + restartGame.width / 2 - w / 2, restartGame.y + restartGame.height / 2);
		surface.text(str2, backToMenu.x + backToMenu.width / 2 - w2 / 2, backToMenu.y + backToMenu.height / 2);
		surface.text(str3, exit.x + exit.width / 2 - w3 / 2, exit.y + exit.height / 2);
		

		surface.textSize(110);
		surface.fill(204, 51, 255);
		String gameOver = "GAME OVER";
		float w4 = surface.textWidth(gameOver);
		surface.text(gameOver, 400 - w4 / 2, 100);
		
		surface.textSize(80);
		String pointsEarned = "Points Earned: " + points;
		float w5 = surface.textWidth(pointsEarned);
		surface.text(pointsEarned, 400 - w5 / 2, 200);		
		surface.popStyle();
	}
	
	/**
	 * Switches screen when mouse is pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (restartGame.contains(p)) {
			surface.screens.set(level, new GameScreen(surface, level, w)); 
			surface.switchScreen(level);
		}	else if (backToMenu.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		}	else if (exit.contains(p)) {
			w.exit();
		}
	}

			
}
