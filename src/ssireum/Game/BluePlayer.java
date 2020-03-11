package ssireum.Game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BluePlayer extends JPanel {

	public BluePlayer(String name,String affiliation) {
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 300));
		JLabel NameLabel = new JLabel(name);
		JLabel AffLabel = new JLabel(affiliation);
		
		NameLabel.setFont(new Font("Gothic",Font.BOLD,200));
		NameLabel.setForeground(Color.white);
		

		AffLabel.setFont(new Font("Gothic",Font.BOLD,80));
		AffLabel.setForeground(Color.white);
		

		NameLabel.setAlignmentX( Component.RIGHT_ALIGNMENT );//0.0
		AffLabel.setAlignmentX( Component.RIGHT_ALIGNMENT );//0.0

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.black);
		this.add(AffLabel);
		this.add(NameLabel); 
	}

}
