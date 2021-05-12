package game;



import java.awt.Point;
import java.awt.Rectangle;


public class MenuScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle button;

	public MenuScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		button = new Rectangle(800/2-100,600/2-50,200,100);
	}


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
				+ "				 \n3. Press 'enter' once you think the bridge is the correct length to let the bridge fall and connect the two islands\r\n"
				+ "				 \n4. The bridge falls, and the end point determines if you succeed";
		surface.text(instructions, 10, 20);
		
		surface.popStyle();
	}



	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN2);
	}
	

}
