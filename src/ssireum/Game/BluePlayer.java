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

	JLabel NameLabel;
	JLabel AffLabel;
	
	public BluePlayer(String name,String affiliation) {
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 300));
		NameLabel = new JLabel(name);
		AffLabel = new JLabel(affiliation);
		
		NameLabel.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,200));
		NameLabel.setForeground(Color.white);
		

		AffLabel.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,80));
		AffLabel.setForeground(Color.white);
		

		NameLabel.setAlignmentX( Component.RIGHT_ALIGNMENT );//0.0
		AffLabel.setAlignmentX( Component.RIGHT_ALIGNMENT );//0.0

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.black);
		this.setOpaque(false);
		this.add(AffLabel);
		this.add(NameLabel); 
	}
	
	public void changeLabel(String name,String affiliation) {
		NameLabel.setText(name);
		AffLabel.setText(affiliation);
	}

}
