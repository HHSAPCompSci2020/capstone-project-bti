package game;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Displays the game 
 * @author Riya Gupta
 * @author Samantha Sung
 * @author Kasturi Sinha
 * @version 5/15
 */
public class MenuScreen extends Screen {

	private DrawingSurface surface;
	private Rectangle button1, button2, button3;

	/**
	 * Instantiates all of MenuScreen's fields, including the buttons 
	 * @param surface PApplet onto which the menu will be drawn 
	 */
	public MenuScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		button1 = new Rectangle(800/2-100,600/2-25,200,100);
		button2 = new Rectangle(800/2-100,600/2+85,200,100);
		button3 = new Rectangle(800/2-100,600/2+195,200,100);
	}

	/**
	 * Draws all of the objects onto the DrawingSurface
	 */
	public void draw() {
		surface.pushStyle();	
		surface.background(255,255,255);
		
		surface.fill(255);
		surface.rect(button1.x, button1.y, button1.width, button1.height, 10, 10, 10, 10);
		surface.rect(button2.x, button2.y, button2.width, button2.height, 10, 10, 10, 10);
		surface.rect(button3.x, button3.y, button3.width, button3.height, 10, 10, 10, 10);
		
		surface.fill(0);
		String str = "Original";
		float w = surface.textWidth(str);
		String str2 = "Invisible Bridge";
		float w2 = surface.textWidth(str2);
		String str3 = "Speeding Bridge";
		float w3 = surface.textWidth(str3);
		
		surface.textSize(15);
		surface.textLeading(11);
		surface.text(str, button1.x+button1.width/2-w/4, button1.y+button1.height/2);
		surface.text(str2, button2.x+button2.width/2-w2/4, button2.y+button2.height/2);
		surface.text(str3, button3.x+button3.width/2-w3/4, button3.y+button3.height/2);
		
		//Print instructions
		String instructions = "Instructions:\r\n"
				+ "				 \n1. You are on a deserted isle\r\n"
				+ "				 \n2. Press on the space button for a bridge to continue to get built in the vertical direction.\r\n"
				+ " 			 \n   The Invisible Bridge will not be shown while built; The Speeding Bridge builds faster the longer you press\r\n"
				+ "				 \n3. Release once you think the bridge is the correct length to let the bridge fall and connect the two islands\r\n"
				+ "				 \n4. The bridge falls, and the end point determines if you succeed\r\n"
				+ "				 \n5. The closer you get to the middle of the isle, the more points you receive\r\n"
				+ "				 \n6. Every time you get 20 more points, you receive another life";

		surface.text(instructions, 10, 70, 800, 600);
		
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
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		}	else if (button2.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SCREEN3);
		}	else if (button3.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SCREEN4);
		}
			
	}
}

