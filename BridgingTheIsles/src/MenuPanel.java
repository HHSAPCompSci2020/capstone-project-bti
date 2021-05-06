import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
