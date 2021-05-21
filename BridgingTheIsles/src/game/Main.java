package game;
import javax.swing.*;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import java.awt.*;

/** 
 * Contains the main method, creates DrawingSurface
 * 
 * @author Riya Gupta
 * @author Kasturi Sinha
 * @version 5/18
*/
public class Main extends JFrame{
	
	private static JFrame window; 
	
	/**
	 * Creates and displays the window 
	 */
	public Main() {
		DrawingSurface drawing = new DrawingSurface(this);
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		window = (JFrame)canvas.getFrame();
		window.setSize(600, 500);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
		canvas.requestFocus();
	}
	
	
	/**
	 * Main method
	 * @param args arguments
	 */
	public static void main(String[] args) {
		Main w = new Main(); 
	}
	
	/**
	 * Closes the window 
	 */
	public void exit() {
		window.dispose();
	}


}
