package ssireum.Game;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdPanel extends JPanel {

	public AdPanel() {
		this.setBackground(Color.gray);
		this.setBorder(BorderFactory.createEmptyBorder(200,0,0,0));
		this.add(new JLabel("±¤°í"));
	}

	
}
