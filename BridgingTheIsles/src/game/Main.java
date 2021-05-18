package game;
import javax.swing.*;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import java.awt.*;

/** 
 * Contains the main method, creates DrawingSurface
 * 
 * @author Riya Gupta
 * @version 5/10
*/
public class Main extends JFrame{
	
	private static JFrame window; 
	
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
	
	public void exit() {
		window.dispose();
	}


}
