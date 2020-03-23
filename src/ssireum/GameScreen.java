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
	//타이머제어변수
	boolean TimerOn = false;
	Container c;
	ScorePanel ScorePanel;
	Timer timer;
	int PlayGameNumber;
	JPanel CenterPanel;
	boolean BlueScoreOn=true;
	boolean RedScoreOn=true;
	public GameScreen(String GameName,String howManyPlayGame,ssireum.Player blue,ssireum.Player red) {

		//판수 설정
		if(howManyPlayGame.contentEquals("5")) {
			PlayGameNumber=5;
		}else {
			PlayGameNumber=3;
		}

		//기본설정
		setTitle("게임화면");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);

		//전체화면 설정
		c = this.getContentPane();
		c.setBackground(Color.black);
		c.setLayout(new BorderLayout());



		//타이머
		timerLabel = new JLabel("60");
		timerLabel.setFont(new Font("맑은 고딕",Font.BOLD,200));
		timerLabel.setForeground(Color.white);
		timerLabel.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));


		//헤더생성
		HeaderTitle HeaderTitle = new HeaderTitle(GameName);

		//헤더 공백설정
		HeaderTitle.setBorder(BorderFactory.createEmptyBorder(80,0,0,0));

		//센터패널 생성 + 추가
		createCenterPanel(blue,red);

		//위쪽패널 추가
		c.add(HeaderTitle,"North");

		//광고패널생성 + 추가
		String[] Video = new String[3];
		Video[0] = ".\\res\\kang1.mp4";
		Video[1] = ".\\res\\kang2.mp4";
		Video[2] = ".\\res\\kang3.mp4";

		//
		//				AdPanel adPanel = new AdPanel();
		//				adPanel.setAV(Video);
		//		
		//				c.add(adPanel,"South");

		//풀스크린
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		setVisible(true);



		//타이머 세팅
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



		//키어댑터
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
							System.out.println("블루: "+ScorePanel.BlueScore);
							if(ScorePanel.BlueScore==PlayGameNumber-1) {
								RedScoreOn=false;
								BlueScoreOn=false;
								System.out.println("블루승 끄기");

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
							System.out.println("레드: "+ScorePanel.RedScore);
							if(ScorePanel.RedScore==PlayGameNumber-1) {
								RedScoreOn=false;
								BlueScoreOn=false;
								System.out.println("레드승 끄기");

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


		//선수정보
		BluePlayer bp = new BluePlayer(blue.name, blue.affiliation);
		RedPlayer rp = new RedPlayer(red.name, red.affiliation);



		//선수정보 마진설정
		bp.setBorder(BorderFactory.createEmptyBorder(200,0,50,0));
		rp.setBorder(BorderFactory.createEmptyBorder(200,0,50,0));


		//센터패널
		CenterPanel = new JPanel();
		CenterPanel.setLayout(new FlowLayout());
		CenterPanel.setBackground(Color.black);


		//스코어 추가
		ScorePanel = new ScorePanel(timerLabel,blue,red);

		//추가
		CenterPanel.add(bp);
		CenterPanel.add(ScorePanel);
		CenterPanel.add(rp);

		c.add(CenterPanel,"Center");


	}


}
