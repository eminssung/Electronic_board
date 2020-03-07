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

import ssireum.Panels.BluePlayer;
import ssireum.Panels.HeaderTitle;
import ssireum.Panels.RedPlayer;


public class GameScreen extends JFrame{
	JLabel timerLabel = null;
	int time=15;
	//Ÿ�̸������
	boolean TimerOn = false;
	public GameScreen() {




		//�⺻����
		setTitle("����ȭ��");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);

		//��üȭ�� ����
		Container c = this.getContentPane();
		c.setBackground(Color.black);
		c.setLayout(new BorderLayout());

		//�������
		HeaderTitle HeaderTitle = new HeaderTitle("2020ȫ��������羾����ȸ");

		//��� ���鼳��
		HeaderTitle.setBorder(BorderFactory.createEmptyBorder(80,0,0,0));



		//��������
		BluePlayer bp = new BluePlayer("�̴ټ�", "��Ɽ�ֽ�û");
		RedPlayer rp = new RedPlayer("���缱", "��굿��û");

		//�������� ��������
		bp.setBorder(BorderFactory.createEmptyBorder(200,0,50,0));
		rp.setBorder(BorderFactory.createEmptyBorder(200,0,50,0));


		//Ÿ�̸�
		timerLabel = new JLabel("15");
		timerLabel.setFont(new Font("Gothic",Font.BOLD,200));
		timerLabel.setForeground(Color.white);


		//�����г�
		JPanel CenterPanel = new JPanel();
		CenterPanel.setLayout(new FlowLayout());
		CenterPanel.setBackground(Color.black);

		CenterPanel.add(bp);
		CenterPanel.add(timerLabel);
		CenterPanel.add(rp);


		JButton b1 = new JButton("����");

		//Ǯ��ũ��
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		setVisible(true);



		//��üȭ�鿡 �߰�
		c.add(CenterPanel,"Center");
		//		c.add(timerLabel,"Center");
		c.add(HeaderTitle,"North");
		c.add(b1,"South");

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




		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				//				System.out.println(e.getKeyChar()+" keyTyped key");
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
}
