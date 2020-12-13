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
		this.setOpaque(false);
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,30));
		g.setColor(Color.white);
		if(cautionBlueCount==1) {
			g.setColor(Color.black);
			g.fillArc(34, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
			g.drawArc(35, 20, 25, 25, 0, 360);
			g.setColor(Color.red);
			g.fillArc(74, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
		}else if(cautionBlueCount==2) {
			g.setColor(Color.red);
			g.fillArc(34, 19, 27, 27, 0, 360);
			g.fillArc(74, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
		}else if(cautionBlueCount==0) {
			g.setColor(Color.black);
			g.fillArc(34, 19, 27, 27, 0, 360);
			g.fillArc(74, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
			g.drawArc(35, 20, 25, 25, 0, 360);
			g.drawArc(75, 20, 25, 25, 0, 360);
			g.setColor(Color.white);
		}
		if(cautionRedCount==1) {
			g.setColor(Color.red);
			g.fillArc(469, 19, 27, 27, 0, 360);
			g.setColor(Color.black);
			g.fillArc(509, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
			g.drawArc(510, 20, 25, 25, 0, 360);
		}else if(cautionRedCount==2) {
			g.setColor(Color.red);
			g.fillArc(469, 19, 27, 27, 0, 360);
			g.fillArc(509, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
		}else if(cautionRedCount==0) {
			g.setColor(Color.black);
			g.fillArc(469, 19, 27, 27, 0, 360);
			g.fillArc(509, 19, 27, 27, 0, 360);
			g.setColor(Color.white);
			g.drawArc(470, 20, 25, 25, 0, 360);
			g.drawArc(510, 20, 25, 25, 0, 360);
			g.setColor(Color.white);
		}
		g.drawLine(115, 32 , 235, 32);
		g.drawString("°æ°í", 250, 40);
		g.drawLine(327, 32 , 447, 32);
	}
	
	public void cautionBlue() {
		cautionBlueCount++;
		this.repaint();
	}

	public void cautionRed() {
		cautionRedCount++;
		this.repaint();
	}
	
	public void cautionCancleBlue() {
		cautionBlueCount--;
		this.repaint();
	}

	public void cautionCancleRed() {
		cautionRedCount--;
		this.repaint();
	}

	public void resetCaution() {
		cautionBlueCount=0;
		cautionRedCount=0;
	}
	

}
