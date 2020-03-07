package ssireum.Panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RedPlayer extends JPanel {

	public RedPlayer(String name,String affiliation)  {
		JLabel NameLabel = new JLabel(name);
		JLabel AffLabel = new JLabel(affiliation);

		NameLabel.setFont(new Font("Gothic",Font.BOLD,200));
		NameLabel.setForeground(Color.white);


		AffLabel.setFont(new Font("Gothic",Font.BOLD,80));
		AffLabel.setForeground(Color.white);


		NameLabel.setAlignmentX( Component.LEFT_ALIGNMENT );//0.0
		AffLabel.setAlignmentX( Component.LEFT_ALIGNMENT );//0.0

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.black);
		this.add(AffLabel);
		this.add(NameLabel); 
	}


}
