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
	static public JLabel BlueScoreLabel;
	static public JLabel RedScoreLabel;
	public int BlueScore = 0;
	public int RedScore = 0;
	public CautionPanel caution;
	static JLabel timeLabel;
	static JPanel TopPanel = new JPanel();
	static JPanel BottomPanel = new JPanel();
	WeightPanel weight;

	public ScorePanel(JLabel time,Player blue,Player red,boolean gamestart) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		this.setBackground(Color.black);
		this.setOpaque(false);
		
		this.setAlignmentY(BOTTOM_ALIGNMENT);
		timeLabel=time;

		//점수 + 타이머
		TopPanel.setLayout(new FlowLayout());
//		TopPanel.setBackground(Color.black);
		TopPanel.setOpaque(false);
		
		//테두리
		LineBorder lineborder = new LineBorder(Color.yellow,4,true);
		EmptyBorder emptyborder = new EmptyBorder(-10,20,-5,20);
		CompoundBorder b10 = new CompoundBorder(lineborder,emptyborder);



		//청 스코어라벨
		BlueScoreLabel = new JLabel("0");
		BlueScoreLabel.setFont(new Font("맑은 고딕",Font.BOLD,80));
		BlueScoreLabel.setForeground(Color.white);
		BlueScoreLabel.setBorder(b10);

		//홍 스코어라벨
		RedScoreLabel = new JLabel("0");
		RedScoreLabel.setBorder(b10);
		RedScoreLabel.setFont(new Font("맑은 고딕",Font.BOLD,80));
		RedScoreLabel.setForeground(Color.white);

		TopPanel.add(BlueScoreLabel);
		if(gamestart) {
			TopPanel.add(time);
		}else {
			time.setText("VS");
			TopPanel.add(time);

		}
		TopPanel.add(RedScoreLabel);



		//경고 + 체중 패널
		BottomPanel.setLayout(new BoxLayout(BottomPanel, BoxLayout.Y_AXIS));
//		BottomPanel.setBackground(Color.black);
		BottomPanel.setOpaque(false);
		
		caution = new CautionPanel();		
		weight = new WeightPanel(blue.weight,red.weight);

		caution.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 500));

		BottomPanel.add(caution);

		BottomPanel.add(weight);


		//추가
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
	
	public void cautionCancleBlue() {
		caution.cautionCancleBlue();
	}
	
	public void cautionCancleRed() {
		caution.cautionCancleRed();
	}

	public void changeScreen(JLabel time,boolean gamestartflag) {
		if(gamestartflag) {
			TopPanel.removeAll();
			TopPanel.add(BlueScoreLabel);
			TopPanel.add(time);
			time.setForeground(Color.red);
			TopPanel.add(RedScoreLabel);
			this.add(TopPanel);
			this.add(BottomPanel);
			this.repaint();  
		}else {
			TopPanel.removeAll();
			TopPanel.add(BlueScoreLabel);
			time.setText("VS");
			time.setForeground(Color.white);
			TopPanel.add(time);
			TopPanel.add(RedScoreLabel);
			this.add(TopPanel);
			this.add(BottomPanel);
			this.repaint();  
		}
	}

	public void reset(Player blue,Player red) {
		BlueScoreLabel.setText("0");
		RedScoreLabel.setText("0");
		BlueScore = 0;
		RedScore = 0;

		caution.resetCaution();
		weight.changeWeight(blue.weight,red.weight);
		this.repaint();

	}
}
