package ssireum.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeightPanel extends JPanel {
	String blueWeight;
	String RedWeight;
	public WeightPanel(String b,String r) {
		blueWeight=b+" KG";
		RedWeight=r+" KG";
		JLabel alertLabel = new JLabel("체중");
		alertLabel.setFont(new Font("Gothic",Font.BOLD,25));
		alertLabel.setForeground(Color.white);
		this.setBackground(Color.black);
		this.add(alertLabel);
		this.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
	}

	public void paint(Graphics g) {
		g.setFont(new Font("Gothic",Font.BOLD,30));
		g.setColor(Color.white);
		g.drawString(blueWeight, 15, 37);
		g.drawLine(155, 28 , 220, 28);
		g.drawString("체중", 235, 40);
		g.drawLine(312, 28 , 377, 28);
		g.drawString(RedWeight, 400, 37);





	}


}
