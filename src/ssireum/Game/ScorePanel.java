package ssireum.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import ssireum.Player;

public class ScorePanel extends JPanel {

	public ScorePanel(JLabel time,Player blue,Player red) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.black);
		this.setAlignmentY(BOTTOM_ALIGNMENT);
		
		//���� + Ÿ�̸�
		JPanel TopPanel = new JPanel();
		TopPanel.setLayout(new FlowLayout());
		TopPanel.setBackground(Color.cyan);
		
		//�׵θ�
		LineBorder lineborder = new LineBorder(Color.yellow,4,true);
		EmptyBorder emptyborder = new EmptyBorder(-10,20,-20,20);
		CompoundBorder b10 = new CompoundBorder(lineborder,emptyborder);



		//û ���ھ��
		JLabel BlueScore = new JLabel("0");
		BlueScore.setFont(new Font("Gothic",Font.BOLD,80));
		BlueScore.setForeground(Color.white);
		BlueScore.setBorder(b10);

		//ȫ ���ھ��
		JLabel RedScore = new JLabel("0");
		RedScore.setBorder(b10);
		RedScore.setFont(new Font("Gothic",Font.BOLD,80));
		RedScore.setForeground(Color.white);
		
		TopPanel.add(BlueScore);
		TopPanel.add(time);
		TopPanel.add(RedScore);
		
		
		//��� + ü�� �г�
		JPanel BottomPanel = new JPanel();
		BottomPanel.setLayout(new BoxLayout(BottomPanel, BoxLayout.Y_AXIS));
		BottomPanel.setBackground(Color.black);
		
		AlertPanel alert = new AlertPanel();		
		WeightPanel weight = new WeightPanel(blue.weight,red.weight);
	
		alert.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 500));
		
		BottomPanel.add(alert);
		BottomPanel.add(weight);
		

		//�߰�
		this.add(TopPanel);
		this.add(BottomPanel);
		
		
	}

}
