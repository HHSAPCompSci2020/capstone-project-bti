import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
	
	private JPanel cardPanel;
	
	private MenuPanel panel1;
	//private DrawingSurface panel2;
	private MenuPanel panel2;
	
	public Main(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		panel1 = new MenuPanel(this); 
		//panel2 = new DrawingSurface();
	    panel2 = new MenuPanel(this);
	    //panel2.init();
	    
	    cardPanel.add(panel1,"1");
	    cardPanel.add(panel2,"2");
	    
	    add(cardPanel);
	
	    setVisible(true);
	}

	public static void main(String[] args) {
<<<<<<< Updated upstream
=======

		Main w = new Main("Bridging the Isles");

	}

	public void changePanel() {
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		panel2.requestFocus();

>>>>>>> Stashed changes
		System.out.println("Hello World");
	}

}
