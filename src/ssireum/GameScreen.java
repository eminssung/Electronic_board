package ssireum;

import java.awt.Container;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ssireum.Player;
import ssireum.Game.AdPanel;
import ssireum.Game.BluePlayer;
import ssireum.Game.HeaderTitle;
import ssireum.Game.RedPlayer;
import ssireum.Game.ScorePanel;
import ssireum.input.Player_info;


public class GameScreen extends JFrame{
	JLabel timerLabel = null;
	int time=60;
	//Ÿ�̸������
	boolean TimerOn = false;
	Container c;
	ScorePanel ScorePanel;
	Timer timer;
	int PlayGameNumber;
	JPanel CenterPanel;
	boolean BlueScoreOn=true;
	boolean RedScoreOn=true;
	public GameScreen(String GameName,String howManyPlayGame,ssireum.Player blue,ssireum.Player red) {

		//�Ǽ� ����
		if(howManyPlayGame.contentEquals("5")) {
			PlayGameNumber=5;
		}else {
			PlayGameNumber=3;
		}

		//�⺻����
		setTitle("����ȭ��");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);

		//��üȭ�� ����
		c = this.getContentPane();
		c.setBackground(Color.black);
		c.setLayout(new BorderLayout());



		//Ÿ�̸�
		timerLabel = new JLabel("60");
		timerLabel.setFont(new Font("���� ���",Font.BOLD,200));
		timerLabel.setForeground(Color.white);
		timerLabel.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));


		//�������
		HeaderTitle HeaderTitle = new HeaderTitle(GameName);

		//��� ���鼳��
		HeaderTitle.setBorder(BorderFactory.createEmptyBorder(80,0,0,0));

		//�����г� ���� + �߰�
		createCenterPanel(blue,red);

		//�����г� �߰�
		c.add(HeaderTitle,"North");

		//�����гλ��� + �߰�
		String[] Video = new String[3];
		Video[0] = ".\\res\\kang1.mp4";
		Video[1] = ".\\res\\kang2.mp4";
		Video[2] = ".\\res\\kang3.mp4";

		//
		//				AdPanel adPanel = new AdPanel();
		//				adPanel.setAV(Video);
		//		
		//				c.add(adPanel,"South");

		//Ǯ��ũ��
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		setVisible(true);



		//Ÿ�̸� ����
		timer = new Timer(1000, new ActionListener(){   
			public void actionPerformed (ActionEvent e){
				if(time==1) {
					time -= 1;
					timerLabel.setText(0+Integer.toString(time));
					time = 30;
					timerLabel.setText(Integer.toString(time));
					timer.stop();
					TimerOn=false;

				}else {
					time -= 1;
					if(time<10) {
						timerLabel.setText(0+Integer.toString(time));
					}else {
						timerLabel.setText(Integer.toString(time));
					}
				}

			}
		});



		//Ű�����
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyChar()+" keyTyped key");
				if(e.getKeyChar()== ' ') {
					if(TimerOn) {
						timer.stop();
						TimerOn=false;
					}else {
						timer.start();
						TimerOn=true;
					}
				}else if(e.getKeyChar() == 'a') {
					if(BlueScoreOn) {
						if(ScorePanel.BlueScore<PlayGameNumber-1) {
							timer.stop();
							TimerOn=false;
							time = 60;
							timerLabel.setText(Integer.toString(time));
							timer.stop();
							TimerOn=false;
							ScorePanel.blueWin();
							System.out.println("���: "+ScorePanel.BlueScore);
							if(ScorePanel.BlueScore==PlayGameNumber-1) {
								RedScoreOn=false;
								BlueScoreOn=false;
								System.out.println("���� ����");

							}
						}
					}
				}
				else if(e.getKeyChar() == '\'') {
					if(RedScoreOn) {
						if(ScorePanel.RedScore<PlayGameNumber-1) {
							timer.stop();
							TimerOn=false;
							time = 60;
							timerLabel.setText(Integer.toString(time));
							timer.stop();
							TimerOn=false;
							ScorePanel.redWin();
							System.out.println("����: "+ScorePanel.RedScore);
							if(ScorePanel.RedScore==PlayGameNumber-1) {
								RedScoreOn=false;
								BlueScoreOn=false;
								System.out.println("����� ����");

							}
						}
					}
				}
				else if(e.getKeyChar() == 's') {
					timer.stop();
					TimerOn=false;
					ScorePanel.cautionBlue();
					if(ScorePanel.caution.cautionBlueCount==3) {
						dispose();
						new Player_info();
					}
				}
				else if(e.getKeyChar() == ';') {
					timer.stop();
					TimerOn=false;
					ScorePanel.cautionRed();
					if(ScorePanel.caution.cautionRedCount==3) {
						dispose();
						new Player_info();
					}

				}else if(e.getKeyChar()=='y') {
					if(ScorePanel.BlueScore==(PlayGameNumber-1)||ScorePanel.RedScore==(PlayGameNumber-1)) {
						dispose();
						new Player_info();
					}
				}
			}
		});

	}

	public void createCenterPanel(Player blue,Player red) {


		//��������
		BluePlayer bp = new BluePlayer(blue.name, blue.affiliation);
		RedPlayer rp = new RedPlayer(red.name, red.affiliation);



		//�������� ��������
		bp.setBorder(BorderFactory.createEmptyBorder(200,0,50,0));
		rp.setBorder(BorderFactory.createEmptyBorder(200,0,50,0));


		//�����г�
		CenterPanel = new JPanel();
		CenterPanel.setLayout(new FlowLayout());
		CenterPanel.setBackground(Color.black);


		//���ھ� �߰�
		ScorePanel = new ScorePanel(timerLabel,blue,red);

		//�߰�
		CenterPanel.add(bp);
		CenterPanel.add(ScorePanel);
		CenterPanel.add(rp);

		c.add(CenterPanel,"Center");


	}


}
