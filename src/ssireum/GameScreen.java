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
<<<<<<< HEAD
import java.io.File;
=======
>>>>>>> db7470642cb2c3f4e624c3d4b781c41f064fd66f
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


public class GameScreen extends JFrame{
	JLabel timerLabel = null;
	int time=15;
	//타이머제어변수
	boolean TimerOn = false;
	Container c;
<<<<<<< HEAD
	ScorePanel ScorePanel;
=======
>>>>>>> db7470642cb2c3f4e624c3d4b781c41f064fd66f
	public GameScreen(ssireum.Player blue,ssireum.Player red) {
		
		
		//기본설정
		setTitle("게임화면");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);

		//전체화면 설정
		c = this.getContentPane();
		c.setBackground(Color.black);
		c.setLayout(new BorderLayout());
		
		
		
		//타이머
		timerLabel = new JLabel("15");
		timerLabel.setFont(new Font("Gothic",Font.BOLD,200));
		timerLabel.setForeground(Color.white);
		timerLabel.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));
		

		//헤더생성
		HeaderTitle HeaderTitle = new HeaderTitle("2020홍성설날장사씨름대회");

		//헤더 공백설정
		HeaderTitle.setBorder(BorderFactory.createEmptyBorder(80,0,0,0));

		//센터패널 생성 + 추가
		createCenterPanel(blue,red);

		//위쪽패널 추가
		c.add(HeaderTitle,"North");

		//광고패널생성 + 추가
<<<<<<< HEAD
		String[] Video = new String[3];
		Video[0] = ".\\res\\kang1.mp4";
		Video[1] = ".\\res\\kang2.mp4";
		Video[2] = ".\\res\\kang3.mp4";
		
		File path = new File(".");
	    System.out.println(path.getAbsolutePath());
	    
		AdPanel adPanel = new AdPanel();
		adPanel.setAV(Video);
=======
		AdPanel adPanel = new AdPanel();
>>>>>>> db7470642cb2c3f4e624c3d4b781c41f064fd66f
		c.add(adPanel,"South");

		//풀스크린
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		setVisible(true);



		//타이머 세팅
		Timer timer = new Timer(1000, new ActionListener(){   
			public void actionPerformed (ActionEvent e){
				if(time==1) {
					time -= 1;
					timerLabel.setText(0+Integer.toString(time));
					System.exit(0);
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
<<<<<<< HEAD
					timer.stop();
					ScorePanel.blueWin();
				}
				else if(e.getKeyChar() == '\'') {
					timer.stop();
					ScorePanel.redWin();
				}
				else if(e.getKeyChar() == 's') {
					timer.stop();
					ScorePanel.cautionBlue();
				}
				else if(e.getKeyChar() == ';') {
					timer.stop();
					ScorePanel.cautionRed();
=======

>>>>>>> db7470642cb2c3f4e624c3d4b781c41f064fd66f
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
		JPanel CenterPanel = new JPanel();
		CenterPanel.setLayout(new FlowLayout());
		CenterPanel.setBackground(Color.black);

		
		//스코어 추가
<<<<<<< HEAD
		ScorePanel = new ScorePanel(timerLabel,blue,red);
=======
		ScorePanel ScorePanel = new ScorePanel(timerLabel,blue,red);
>>>>>>> db7470642cb2c3f4e624c3d4b781c41f064fd66f
		
		//추가
		CenterPanel.add(bp);
		CenterPanel.add(ScorePanel);
		CenterPanel.add(rp);
		
		c.add(CenterPanel,"Center");

	}
	

	
	
}
