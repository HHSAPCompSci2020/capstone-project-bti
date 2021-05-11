package game;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** 
 * Window that displays the game and contains the initial drop-down menu to choose the level 
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 1
*/
public class MenuPanel extends JPanel implements ActionListener{

	Main w;
	
	/**
	 * Displays the level options and instructions at the beginning of the game
	 * @param w the Main object 
	 */
	public MenuPanel(Main w) {
		this.w = w;
		JTextArea instructions = new JTextArea("Instructions:"
				+ "\n1. You are on a deserted isle"
				+ "\n2. Press on the space button for a bridge to continue to get built. It gets longer in the vertical direction."
				+ "\n3. Stop pressing the ‘space button’ once you think the bridge is the correct length to connect the two islands"
				+ "\n4. The bridge falls, and the end point determines if you succeed");
		add(instructions);
		JButton button = new JButton("Easy");
		button.addActionListener(this);
		add(button);
	}
	
	/**
	 * Changes panel when game starts
	 * @param e ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
	//	w.changePanel();
		
	}
	
}
