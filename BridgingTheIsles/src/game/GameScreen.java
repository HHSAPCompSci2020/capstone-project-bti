package game;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;

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
	private Isle isle1, isle2;
	private Isle tempIsle;
	private PointSystem points;
	private LifeCounter lives; 
	private Rectangle restart, backToMenu, exit; 
	private int level;
	private boolean space;
	private Main w;


	/**
	 * Instantiates all of GameScreen's fields 
	 * @param surface PApplet onto which the game will be drawn 
	 * @param level Version of the game (original, invisible, or speeding)
	 * @param w Main class
	 */
	public GameScreen(DrawingSurface surface, int level, Main w) {
		super(800,600);
		this.w = w; 
		this.surface = surface;
		this.level = level;
		space = false;

		isle1 = new Isle(4, 60);
		if(level == 1)
			bridge = new OriginalBridge(isle1.startX + isle1.width);
		else if(level == 2)
			bridge = new InvisibleBridge(isle1.startX + isle1.width);
		else if(level == 3)
			bridge = new SpeedingBridge(isle1.startX + isle1.width);
		isle2 = new Isle(3, isle1.startX +isle1.width);
		tempIsle = isle1;
		points = new PointSystem();
		lives = new LifeCounter();

		person = new Person(80, 400, lives);

		restart = new Rectangle(580, 150, 180, 40);
		backToMenu = new Rectangle(580, 200, 180, 40); 
		exit = new Rectangle(580, 250, 180, 40);
	}

	/**
	 * Sets up the game in the beginning 
	 */
	public void setup() {
	}

	/**
	 * Draws all of the objects onto the DrawingSurface
	 */
	public void draw() {
		surface.background(102, 255, 255);
		surface.fill(0, 0, 255); //water
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
		if(person.act()) {
			if (surface.screens.size() == 4) {
				surface.screens.add(new DeadScreen(surface, points.points, level, w));
			} else {
				surface.screens.set(4, new DeadScreen(surface, points.points, level, w));
			}
			surface.switchScreen(ScreenSwitcher.SCREEN3);
		}

		surface.fill(204, 255, 255);
		surface.rect(580, 30, 180, 90);
		surface.fill(50);
		surface.textSize(20);
		surface.text(("Points: " + Integer.toString(points.points)), 600, 40, 800, 80);
		surface.text(("Lives left: " + Integer.toString(lives.lifeCount)), 600, 80, 700, 120); 

		if(surface.isPressed(KeyEvent.VK_SPACE)) {
			bridge.startX = isle1.startX+isle1.width;
			bridge.build(5);
			space = true;
		}

		surface.fill(204, 255, 255);
		surface.rect(restart.x, restart.y, restart.width, restart.height, 10, 10, 10, 10);
		surface.fill(50);
		surface.textSize(20);
		String str = "Restart";
		float w = surface.textWidth(str);
		surface.text(str, restart.x + restart.width / 2 - w / 2, restart.y + restart.height / 2 + 5);

		surface.fill(204, 255, 255);
		surface.rect(backToMenu.x, backToMenu.y, backToMenu.width, backToMenu.height, 10, 10, 10, 10);
		surface.fill(50);
		surface.textSize(20);
		String str2 = "Back to Menu";
		float w1 = surface.textWidth(str2);
		surface.text(str2, backToMenu.x + backToMenu.width / 2 - w1 / 2, backToMenu.y + backToMenu.height / 2 + 5);
		
		surface.fill(204, 255, 255);
		surface.rect(exit.x, exit.y, exit.width, exit.height, 10, 10, 10, 10);
		surface.fill(50);
		surface.textSize(20);
		String str3 = "Exit";
		float w2 = surface.textWidth(str3);
		surface.text(str3, exit.x + exit.width / 2 - w2 / 2, exit.y + exit.height / 2 + 5);
	}

	/**
	 * Acts according to whether the bridge falls on the island
	 */
	public void keyReleased() {
		if(space) {
			int p = isle2.detectBridge(bridge.getEndCoordinate());
			int previous = points.points;
			points.incrementPoints(p);
			int n = points.points/20;
			if (previous < 20 * n && points.points >= 20 * n) 
				lives.addLife();

			person.walk(bridge.getEndCoordinate());
			bridge.fall(bridge.getEndCoordinate() - person.x);

			if (p > 0) {
				person.shift(bridge.getEndCoordinate() - isle2.startX);
				tempIsle = isle1;
				tempIsle.dir = 0;
				tempIsle.shift(bridge.getEndCoordinate() - person.x);
				isle1 = isle2;
				isle1.dir = 1;
				isle1.shift(bridge.getEndCoordinate() - person.x);
				isle2 = new Isle(2, 60+isle1.width);
				isle2.shift(bridge.getEndCoordinate() - person.x);
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
		space = false;
	}

	/**
	 * Acts according to which button is pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (restart.contains(p)) {
			surface.screens.set(1, new GameScreen(surface, level, w));
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		} else if (backToMenu.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		} else if (exit.contains(p)) {
			w.exit();
		}
	}

}

