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
	public JLabel BlueScoreLabel;
	public JLabel RedScoreLabel;
	public int BlueScore = 0;
	public int RedScore = 0;
	public CautionPanel caution;

	public ScorePanel(JLabel time,Player blue,Player red) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.black);
		this.setAlignmentY(BOTTOM_ALIGNMENT);
		
		//���� + Ÿ�̸�
		JPanel TopPanel = new JPanel();
		TopPanel.setLayout(new FlowLayout());
		TopPanel.setBackground(Color.black);
		
		//�׵θ�
		LineBorder lineborder = new LineBorder(Color.yellow,4,true);
		EmptyBorder emptyborder = new EmptyBorder(-10,20,-5,20);
		CompoundBorder b10 = new CompoundBorder(lineborder,emptyborder);



		//û ���ھ��
		BlueScoreLabel = new JLabel("0");
		BlueScoreLabel.setFont(new Font("���� ���",Font.BOLD,80));
		BlueScoreLabel.setForeground(Color.white);
		BlueScoreLabel.setBorder(b10);

		//ȫ ���ھ��
		RedScoreLabel = new JLabel("0");
		RedScoreLabel.setBorder(b10);
		RedScoreLabel.setFont(new Font("���� ���",Font.BOLD,80));
		RedScoreLabel.setForeground(Color.white);
		
		TopPanel.add(BlueScoreLabel);
		TopPanel.add(time);
		TopPanel.add(RedScoreLabel);

		
		
		//��� + ü�� �г�
		JPanel BottomPanel = new JPanel();
		BottomPanel.setLayout(new BoxLayout(BottomPanel, BoxLayout.Y_AXIS));
		BottomPanel.setBackground(Color.black);
		
		caution = new CautionPanel();		
		WeightPanel weight = new WeightPanel(blue.weight,red.weight);
	
		caution.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 500));
		
		BottomPanel.add(caution);

		BottomPanel.add(weight);
		

		//�߰�
		this.add(TopPanel);
		this.add(BottomPanel);
		
		
	}
	
	public void blueWin() {
		BlueScore++;
		BlueScoreLabel.setText(Integer.toString(BlueScore));
		this.repaint();
	}
	
	public void redWin() {
		RedScore++;
		RedScoreLabel.setText(Integer.toString(RedScore));
		this.repaint();
	}
	
	public void cautionBlue() {
		caution.cautionBlue();
	}
	
	public void cautionRed() {
		caution.cautionRed();
	}

}
