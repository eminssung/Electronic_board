package ssireum.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CautionPanel extends JPanel {

	public int cautionBlueCount=0;
	public int cautionRedCount=0;
	public CautionPanel() {
		JLabel alertLabel = new JLabel("°æ°í");
		alertLabel.setFont(new Font("Gothic",Font.BOLD,25));
		alertLabel.setForeground(Color.white);
		this.setBackground(Color.black);
		this.add(alertLabel);
	}
	
	public void paint(Graphics g) {

		g.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,30));
		g.setColor(Color.white);
		if(cautionBlueCount==1) {
			g.drawArc(20, 20, 25, 25, 0, 360);
			g.setColor(Color.red);
			g.fillArc(59, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
		}else if(cautionBlueCount==2) {
			g.setColor(Color.red);
			g.fillArc(19, 19, 27, 27, 0, 360);
			g.fillArc(59, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
		}else if(cautionBlueCount==0) {
			g.drawArc(20, 20, 25, 25, 0, 360);
			g.drawArc(60, 20, 25, 25, 0, 360);
		}
		if(cautionRedCount==1) {
			g.setColor(Color.red);
			g.fillArc(454, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
			g.drawArc(495, 20, 25, 25, 0, 360);
		}else if(cautionRedCount==2) {
			g.setColor(Color.red);
			g.fillArc(454, 19, 27, 27, 0, 360);
			g.fillArc(494, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
		}else if(cautionRedCount==0) {
			g.drawArc(455, 20, 25, 25, 0, 360);
			g.drawArc(495, 20, 25, 25, 0, 360);
		}
		g.drawLine(100, 32 , 220, 32);
		g.drawString("°æ°í", 235, 40);
		g.drawLine(312, 32 , 432, 32);
	}
	
	public void cautionBlue() {
		cautionBlueCount++;
		this.repaint();
	}

	public void cautionRed() {
		cautionRedCount++;
		this.repaint();
	}


}
