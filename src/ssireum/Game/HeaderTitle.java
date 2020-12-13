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
		//��漳��
//		this.setBackground(Color.black);
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//�����г�
		JPanel WritingPanel = new JPanel();
//		WritingPanel.setBackground(Color.black);
		WritingPanel.setLayout(new FlowLayout());
		
		//������
		JLabel title = new JLabel(t);
		title.setFont(new Font("���� ���",Font.BOLD,70));
		title.setForeground(Color.white);
		
		//������
		JLabel spon = new JLabel("����������   ");
		spon.setFont(new Font("Gothic",Font.BOLD,40));
		spon.setForeground(Color.white);

		
		WritingPanel.add(spon);
		WritingPanel.add(title);
		
		//��������
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
