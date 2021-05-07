import java.awt.geom.Rectangle2D;
import processing.core.PApplet;
import processing.core.PImage;

/** Represents any object in the game that moves or shifts to the left after one level is completed
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 1
*/
public class MovingImage extends Rectangle2D.Double{

	//FIELDS
	private PImage image;
	
	//CONSTRUCTORS
	public MovingImage(PImage img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}
	
	//METHODS
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	public void draw(PApplet g) {
		g.image(image,(int)x,(int)y,(int)width,(int)height);
	}

}
