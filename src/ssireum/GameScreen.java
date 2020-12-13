package ssireum;

import java.awt.Container;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class GameScreen extends JFrame{
	JPanel totalPanel;
	boolean gamestart=false;
	JLabel timerLabel = null;
	int time = 60;
	//타이머제어변수
	boolean TimerOn = false;
	Container c;
	ScorePanel ScorePanel;
	Timer timer;
	int PlayGameNumber;
	JPanel CenterPanel;
	boolean BlueScoreOn=true;
	boolean RedScoreOn=true;
	ArrayList<Player> temp = new ArrayList<Player>();
	Player[] player = new Player[100];
	int count=0;
	BluePlayer bp;
	RedPlayer rp;
	int idx;
	Iterator<Player> itr;
	int round=1;
	int playerNum;
	boolean longerGame=false;
	Clip clip;
	static ImageIcon icon;
	static String sound;

	public GameScreen(String GameName,String howManyPlayGame,Player[] p,int pN,String iconPath, String soundPath) {
		player=p;
		playerNum=pN;		
		sound = soundPath;
		
		setIcon(iconPath);

		if(icon!=null) {
			totalPanel =  new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(icon.getImage(), 0, 0, null);
					Dimension d = getSize();
					g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
		}else {
			totalPanel=new JPanel();
			totalPanel.setBackground(Color.black);
		}
		totalPanel.setLayout(new BorderLayout() );


		//판수 설정
		if(howManyPlayGame.contentEquals("5")) {
			PlayGameNumber=4;
		}else if(howManyPlayGame.contentEquals("3")){
			PlayGameNumber=3;
		}else {
			PlayGameNumber=2;
		}

		//기본설정
		setTitle("게임화면");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);

		//전체화면 설정
		c = this.getContentPane();
		c.add(totalPanel);



		//타이머
		timerLabel = new JLabel(Integer.toString(time));
		timerLabel.setFont(new Font("맑은 고딕",Font.BOLD,200));
		timerLabel.setForeground(Color.white);
		timerLabel.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));


		//헤더생성
		JPanel HeaderTitle = new JPanel();

		//헤더 공백설정
		HeaderTitle.setBorder(BorderFactory.createEmptyBorder(150,0,0,0));
		HeaderTitle.setOpaque(false);

		if(player[0]!=null && player[1]!=null) {
			//센터패널 생성 + 추가
			createCenterPanel(player[count],player[count+1]);
		}

		//위쪽패널 추가
		totalPanel.add(HeaderTitle,"North");

		//		//광고패널생성 + 추가
		//		String[] Video = new String[3];
		//		Video[0] = ".\\res\\kang1.mp4";
		//		Video[1] = ".\\res\\kang2.mp4";
		//		Video[2] = ".\\res\\kang3.mp4";
		//
		//
		//		AdPanel adPanel = new AdPanel();
		//		adPanel.setAV(Video);
		//
		//		c.add(adPanel,"South");

		//풀스크린
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		setVisible(true);



		//타이머 세팅
		timer = new Timer(1000, new ActionListener(){   
			public void actionPerformed (ActionEvent e){
				repaintTime();
				if(time == 0) {
					startMusic();
					timer.stop();
					TimerOn=false;
				}
			}
		});



		//키어댑터
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyCode()+" keyTyped key(code)");
				System.out.println(e.getKeyChar()+" keyTyped key");
				if(e.getKeyChar()== ' ') {
					if(gamestart) {
						if(time != 0) {
							if(TimerOn) {
								timer.stop();
								TimerOn=false;
							}else {
								repaintTime();
								timer.start();
								TimerOn=true;
							}
						}
					}
				}else if(e.getKeyChar() == 'a') {
					if(gamestart) {
						if(BlueScoreOn) {
							if(ScorePanel.BlueScore<PlayGameNumber-1) {
								endGame();
								ScorePanel.blueWin();
								if(ScorePanel.BlueScore==PlayGameNumber-1) {
									gamestart = false;
									RedScoreOn=false;
									BlueScoreOn=false;
									temp.add(player[count]);
								}
							}
						}
					}
				}
				else if(e.getKeyChar() == 's') {
					if(gamestart) {
						if(RedScoreOn) {
							if(ScorePanel.RedScore<PlayGameNumber-1) {
								endGame();
								ScorePanel.redWin();
								if(ScorePanel.RedScore==PlayGameNumber-1) {
									gamestart = false;
									RedScoreOn=false;
									BlueScoreOn=false;
									temp.add(player[count+1]);

								}
							}
						}
					}
				}
				else if(e.getKeyChar() == 'q') {
					if(gamestart) {
						timer.stop();
						TimerOn=false;
						ScorePanel.cautionBlue();
						if(RedScoreOn) {
							if(ScorePanel.caution.cautionBlueCount==3) {
								endGame();
								ScorePanel.redWin(); 
								if(ScorePanel.RedScore==PlayGameNumber-1) {
									gamestart = false;
									RedScoreOn=false;
									BlueScoreOn=false;
									temp.add(player[count+1]);
								}
							}
						}
					}
				}
				else if(e.getKeyChar() == 'w') {
					if(gamestart) {
						timer.stop();
						TimerOn=false;
						ScorePanel.cautionRed();
						if(BlueScoreOn) {
							if(ScorePanel.caution.cautionRedCount==3) {
								endGame();
								ScorePanel.blueWin();
								if(ScorePanel.BlueScore==PlayGameNumber-1) {
									gamestart = false;
									RedScoreOn=false;
									BlueScoreOn=false;
									temp.add(player[count]);
								}
							}
						}
					}
				}else if(e.getKeyChar() == 'e') {
					if(gamestart) {
						if(BlueScoreOn) {
							if(ScorePanel.caution.cautionBlueCount!=0) {
								ScorePanel.cautionCancleBlue();
								ScorePanel.caution.repaint();
							}
						}
					}
				}else if(e.getKeyChar() == 'r') {
					if(gamestart) {
						if(RedScoreOn) {
							if(ScorePanel.caution.cautionRedCount!=0) {
								ScorePanel.cautionCancleRed();
								ScorePanel.caution.repaint();
							}
						}
					}
				}
				else if(e.getKeyChar()=='y') {
					if(ScorePanel.BlueScore==(PlayGameNumber-1) || ScorePanel.RedScore==(PlayGameNumber-1)) {
						count+=2;
						if(round !=1 && playerNum-count == 3) {
							temp.add(player[count]);
							count++;
							resetGame(player[count],player[count+1]);
							ScorePanel.changeScreen(timerLabel,gamestart);
						}else {
							if(player[count] != null && player[count+1] != null) {
								resetGame(player[count],player[count+1]);
								ScorePanel.changeScreen(timerLabel,gamestart);

							}else if(player[count] != null && player[count+1] == null){
								round++;
								temp.add(player[count]);

								player = new Player[100];
								count=0;
								idx=0;
								itr = temp.iterator();
								while( itr.hasNext() ) {
									player[idx] = itr.next();
									idx++;
								}
								playerNum=idx;

								idx=0;
								temp.clear();
								resetGame(player[count],player[count+1]);
								ScorePanel.changeScreen(timerLabel,gamestart);

							}else if(player[count] == null && player[count+1] == null && temp.size()!=1){
								round++;
								player = new Player[100];
								count=0;
								idx=0;

								itr = temp.iterator();
								while( itr.hasNext() ) {
									player[idx] = itr.next();
									idx++;
								}
								playerNum=idx;
								idx=0;
								temp.clear();
								resetGame(player[count],player[count+1]);
								ScorePanel.changeScreen(timerLabel,gamestart);
							}else if(temp.size()==1) {
								System.exit(0);
							}

						}
					}

				}else if(e.getKeyChar()=='z') {
					gamestart=true;
					timerLabel.setText(Integer.toString(time));
					ScorePanel.changeScreen(timerLabel,gamestart);
				}else if(e.getKeyChar() == 'x') {
					if(time == 0) {
						if(longerGame==false) {
							time = 30;
							timerLabel.setText(Integer.toString(time));
							longerGame = true;
						}else {
							if( Double.parseDouble(player[count].getWeight()) < Double.parseDouble(player[count+1].getWeight())) {
								if(BlueScoreOn) {
									if(ScorePanel.BlueScore < PlayGameNumber-1) {
										System.out.println("블루 윈");
										endGame();
										ScorePanel.blueWin();
										if(ScorePanel.BlueScore == PlayGameNumber-1) {
											RedScoreOn=false;
											BlueScoreOn=false;
											temp.add(player[count]);
										}
									}
								}
							}else {
								if(RedScoreOn) {
									if(ScorePanel.RedScore < PlayGameNumber-1) {
										System.out.println("레드 윈");
										endGame();
										ScorePanel.redWin();
										if(ScorePanel.RedScore==PlayGameNumber-1) {
											RedScoreOn=false;
											BlueScoreOn=false;
											temp.add(player[count+1]);
										}
									}
								}
							}
						}
					}
				}
				
				if(e.getKeyCode() == 33) {
					if(!TimerOn) {
						time++;
						if(time<10) {
							timerLabel.setText(0+Integer.toString(time));
						}else {
							timerLabel.setText(Integer.toString(time));
						}
					}
				}
				
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(!TimerOn && time != 0) {
						time--;
						if(time<10) {
							timerLabel.setText(0+Integer.toString(time));
						}else {
							timerLabel.setText(Integer.toString(time));
						}
					}
				}
				
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				int key = e.getKeyCode();
				 switch(key){   
				   case KeyEvent.VK_UP:
					   if(!TimerOn) {
							time++;
							if(time<10) {
								timerLabel.setText(0+Integer.toString(time));
							}else {
								timerLabel.setText(Integer.toString(time));
							}
						}
					   break;
				   case KeyEvent.VK_DOWN:
					   if(!TimerOn && time != 0) {
							time--;
							if(time<10) {
								timerLabel.setText(0+Integer.toString(time));
							}else {
								timerLabel.setText(Integer.toString(time));
							}
						}
					   break;
				 }
				
			}
		});

	}

	public void createCenterPanel(Player blue,Player red) {


		//선수정보
		bp = new BluePlayer(blue.getName(), blue.getAffiliation());
		rp = new RedPlayer(red.getName(), red.getAffiliation());



		//선수정보 마진설정
		bp.setBorder(BorderFactory.createEmptyBorder(200,0,50,0));
		rp.setBorder(BorderFactory.createEmptyBorder(200,0,50,0));


		//센터패널
		CenterPanel = new JPanel();
		CenterPanel.setLayout(new FlowLayout());
		CenterPanel.setOpaque(false);

		//스코어 추가
		ScorePanel = new ScorePanel(timerLabel,blue,red,gamestart);

		//추가
		CenterPanel.add(bp);
		CenterPanel.add(ScorePanel);
		CenterPanel.add(rp);

		totalPanel.add(CenterPanel,"Center");

	}


	public void resetGame(Player blue,Player red) {
		//이름, 소속 리셋
		bp.changeLabel(blue.getName(), blue.getAffiliation());
		rp.changeLabel(red.getName(), red.getAffiliation());
		BlueScoreOn=true;
		RedScoreOn=true;
		gamestart=false;
		//스코어 리셋
		ScorePanel.reset(blue,red);
	}

	public void setIcon(String filePath) {
		icon = new ImageIcon(filePath);
	}

	public void startMusic() {
		File file = new File(sound);
//		File file = new File(".\\res\\buzzer.wav");
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	public void endGame() {
		ScorePanel.caution.cautionRedCount=0;
		ScorePanel.caution.cautionBlueCount=0;
		ScorePanel.caution.repaint();
		timer.stop();
		TimerOn=false;
		time = 60;
		timerLabel.setText(Integer.toString(time));
		timer.stop();
		TimerOn=false;
	}

	public void repaintTime() {
		if(time>0) {
			time--;
		}
		if(time<10) {
			timerLabel.setText(0+Integer.toString(time));
		}else {
			timerLabel.setText(Integer.toString(time));
		}

	}

}
