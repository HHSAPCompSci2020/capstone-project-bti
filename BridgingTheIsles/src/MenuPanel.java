import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** Window that displays the game and contains the initial drop-down menu to choose the level 
 * 
 * @author Kasturi Sinha
 * @author Samantha Sung
 * @author Riya Gupta
 * @version 1
*/
public class MenuPanel extends JPanel implements ActionListener{

	Main w;

	public MenuPanel(Main w) {
		this.w = w;
		JButton button = new JButton("level 1");
		button.addActionListener(this);
		add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
		
	}
	
}
