package game;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Displays the game 
 * @author Riya Gupta
 * @author Samantha Sung
 * @author Kasturi Sinha
 * @version 5/17
 */
public class MenuScreen extends Screen {

	private DrawingSurface surface;
	private Rectangle button1, button2, button3;
	private Main w;
	
	/**
	 * Instantiates all of MenuScreen's fields, including the buttons 
	 * @param surface PApplet onto which the menu will be drawn 
	 */
	public MenuScreen(DrawingSurface surface, Main w) {
		super(800,600);
		this.w = w;
		this.surface = surface;
		button1 = new Rectangle(800/2-100,600/2-45,200,100);
		button2 = new Rectangle(800/2-100,600/2+65,200,100);
		button3 = new Rectangle(800/2-100,600/2+175,200,100);
	}

	/**
	 * Draws all of the objects onto the DrawingSurface
	 */
	public void draw() {
		surface.pushStyle();	
		surface.background(204, 255, 255);
		
		surface.fill(102, 255, 255);
		surface.rect(button1.x, button1.y, button1.width, button1.height, 10, 10, 10, 10);
		surface.rect(button2.x, button2.y, button2.width, button2.height, 10, 10, 10, 10);
		surface.rect(button3.x, button3.y, button3.width, button3.height, 10, 10, 10, 10);
		
		surface.textSize(20);
		surface.fill(0);
		String str = "Original";
		float w = surface.textWidth(str);
		String str2 = "Invisible Bridge";
		float w2 = surface.textWidth(str2);
		String str3 = "Speeding Bridge";
		float w3 = surface.textWidth(str3);

		
		surface.textLeading(11);
		surface.text(str, button1.x + button1.width / 2 - w / 2, button1.y + button1.height / 2);
		surface.text(str2, button2.x + button2.width / 2  - w2 / 2, button2.y + button2.height / 2);
		surface.text(str3, button3.x + button3.width / 2 - w3 / 2, button3.y + button3.height / 2);
		
		surface.textSize(15);
		surface.textLeading(11);
		String instructions = "Instructions:\r\n"
				+ "				 \n1. You are on a deserted isle\r\n"
				+ "				 \n2. Press on the space button for a bridge to build in the vertical direction.\r\n"
				+ " 			 \n   The Invisible Bridge will not be shown while built; The Speeding Bridge builds faster the longer you press\r\n"
				+ "				 \n3. Release once you think the bridge is the correct length to connect the two islands\r\n"
				+ "				 \n4. The bridge falls, and the end point determines if you succeed\r\n"
				+ "				 \n5. The closer you get to the middle of the isle, the more points you receive\r\n"
				+ "				 \n6. Every time you get 20 more points, you receive another life";

		surface.text(instructions, 10, 55, 800, 600);
		
		surface.fill(204, 51, 255);
		surface.textSize(30);
		surface.text("Bridging The Isles", 10, 35);
		
		surface.popStyle();
	}
	
	/**
	 * Switches screen when mouse is pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button1.contains(p)) {
			surface.screens.set(1, new GameScreen(surface, 1, w));
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		}	else if (button2.contains(p)) {
			surface.screens.set(1, new GameScreen(surface, 2, w));
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		}	else if (button3.contains(p)) {
			surface.screens.set(1, new GameScreen(surface, 3, w));
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		}
			
	}
}

