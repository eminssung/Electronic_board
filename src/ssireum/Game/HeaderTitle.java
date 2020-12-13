package ssireum.Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderTitle extends JPanel {

	public HeaderTitle(String t) {
		//배경설정
//		this.setBackground(Color.black);
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//글자패널
		JPanel WritingPanel = new JPanel();
//		WritingPanel.setBackground(Color.black);
		WritingPanel.setLayout(new FlowLayout());
		
		//제목설정
		JLabel title = new JLabel(t);
		title.setFont(new Font("맑은 고딕",Font.BOLD,70));
		title.setForeground(Color.white);
		
		//스폰서
		JLabel spon = new JLabel("위더스제약   ");
		spon.setFont(new Font("Gothic",Font.BOLD,40));
		spon.setForeground(Color.white);

		
		WritingPanel.add(spon);
		WritingPanel.add(title);
		
		//마진설정
		WritingPanel.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));

		
		Box LinePanel = Box.createHorizontalBox();
		

		JPanel Blue = new JPanel();
		Blue.setBackground(Color.blue);
		
		JPanel Red = new JPanel();
		Red.setBackground(Color.red);
		
		
		LinePanel.add(Blue);
		LinePanel.add(Red);


		this.add(WritingPanel);
		this.add(LinePanel);
		
		

	}

}
