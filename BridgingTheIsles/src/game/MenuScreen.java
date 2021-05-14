package game;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Displays the game 
 * @author Riya Gupta
 * @author Samantha Sung
 * @version 5/14
 */
public class MenuScreen extends Screen {

	private DrawingSurface surface;
	private Rectangle button;

	/**
	 * Instantiates all of GameScreen's fields 
	 * @param surface PApplet onto which the menu will be drawn 
	 */
	public MenuScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		button = new Rectangle(800/2-100,600/2-50,200,100);
	}

	/**
	 * Draws all of the objects onto the DrawingSurface
	 */
	public void draw() {
		surface.pushStyle();	
		surface.background(255,255,255);
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Level 1";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
		
		//Print instructions
		String instructions = "Instructions:\r\n"
				+ "				 \n1. You are on a deserted isle\r\n"
				+ "				 \n2. Press on the space button for a bridge to continue to get built. It gets longer in the vertical direction.\r\n"
				+ "				 \n3. Release once you think the bridge is the correct length to let the bridge fall and connect the two islands\r\n"
				+ "				 \n4. The bridge falls, and the end point determines if you succeed\r\n"
				+ "				 \n5. The closer you get to the middle of the isle, the more points you receive\r\n"
				+ "				 \n6. Every time you get 20 more points, you receive another life";
		surface.text(instructions, 10, 20);
		
		surface.popStyle();
	}
	/**
	 * Switches screen when mouse is pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN2);
	}
}

