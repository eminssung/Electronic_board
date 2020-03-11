package ssireum.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlertPanel extends JPanel {

	public AlertPanel() {
		JLabel alertLabel = new JLabel("경고");
		alertLabel.setFont(new Font("Gothic",Font.BOLD,25));
		alertLabel.setForeground(Color.white);
		this.setBackground(Color.black);
		this.add(alertLabel);
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("Gothic",Font.BOLD,30));
		g.setColor(Color.white);
		g.drawArc(20, 20, 25, 25, 0, 360);
		g.drawArc(60, 20, 25, 25, 0, 360);
		g.drawLine(100, 32 , 220, 32);
		g.drawString("경고", 235, 40);
		g.drawLine(312, 32 , 432, 32);
		g.drawArc(455, 20, 25, 25, 0, 360);
		g.drawArc(495, 20, 25, 25, 0, 360);
	}



}
