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


public class GameScreen extends JFrame{
	JLabel timerLabel = null;
	int time=15;
	//Ÿ�̸������
	boolean TimerOn = false;
	Container c;
	public GameScreen(ssireum.Player blue,ssireum.Player red) {
		
		
		//�⺻����
		setTitle("����ȭ��");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);

		//��üȭ�� ����
		c = this.getContentPane();
		c.setBackground(Color.black);
		c.setLayout(new BorderLayout());
		
		
		
		//Ÿ�̸�
		timerLabel = new JLabel("15");
		timerLabel.setFont(new Font("Gothic",Font.BOLD,200));
		timerLabel.setForeground(Color.white);
		timerLabel.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));
		

		//�������
		HeaderTitle HeaderTitle = new HeaderTitle("2020ȫ��������羾����ȸ");

		//��� ���鼳��
		HeaderTitle.setBorder(BorderFactory.createEmptyBorder(80,0,0,0));

		//�����г� ���� + �߰�
		createCenterPanel(blue,red);

		//�����г� �߰�
		c.add(HeaderTitle,"North");

		//�����гλ��� + �߰�
		AdPanel adPanel = new AdPanel();
		c.add(adPanel,"South");

		//Ǯ��ũ��
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		setVisible(true);



		//Ÿ�̸� ����
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
		JPanel CenterPanel = new JPanel();
		CenterPanel.setLayout(new FlowLayout());
		CenterPanel.setBackground(Color.black);

		
		//���ھ� �߰�
		ScorePanel ScorePanel = new ScorePanel(timerLabel,blue,red);
		
		//�߰�
		CenterPanel.add(bp);
		CenterPanel.add(ScorePanel);
		CenterPanel.add(rp);
		
		c.add(CenterPanel,"Center");

	}
	

	
	
}
