package game;
import javax.swing.*;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

import java.awt.*;

/** Contains the main method, creates GameWindow
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 1
*/
public class Main extends JFrame{
	
//	private JPanel cardPanel;
	
//	private MenuPanel panel1;
//	private DrawingSurface panel2;
//	private MenuPanel panel2;

	
//	public Main(String title) {
//		super(title);
//		setBounds(100, 100, 800, 600);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//	//	cardPanel = new JPanel();
//		CardLayout cl = new CardLayout();
//	//	cardPanel.setLayout(cl);
//		
//	//	panel1 = new MenuPanel(this); 
//		panel2 = new DrawingSurface();
//	   // panel2 = new MenuPanel(this);
//	//    panel2.init();
//	    
//	    cardPanel.add(panel1,"1");
//	    cardPanel.add(panel2,"2");
//	    
//	    add(cardPanel);
//	
//	    setVisible(true);
//	}

	public static void main(String[] args) {
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		window.setSize(600, 500);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
		canvas.requestFocus();
	}

//	public void changePanel() {
//		((CardLayout)cardPanel.getLayout()).next(cardPanel);
//		panel2.requestFocus();

//	}

}
