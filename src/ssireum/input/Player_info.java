package ssireum.input;

import javax.swing.*;

import ssireum.GameScreen;
import ssireum.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player_info extends JFrame {
   
   static public Container contentPane;
   private JPanel North,Center; // 상단,센터
   
   //상단 패널 구성요소
   private JPanel king,checkbox;
   private JLabel kinglabel;//주관
   private JTextField kingtext;

   private JRadioButton[] type=new JRadioButton[2];//유형


   //센터 왼쪽 패널 구성요소
   private JPanel Left;
   private JPanel p0,p1,p2,p3;
   private JLabel red,name1,group1,weight1;
   private JTextField inputName1,inputGroup1,inputWeight1;
   
   //센터 오른쪽 패널 구성요소
   private JPanel Right;
   private JPanel p00,p11,p22,p33;
   private JLabel blue,name2,group2,weight2;
   private JTextField inputName2,inputGroup2,inputWeight2;
      
      
   // 폰트
   private Font Big = new Font("맑은 고딕", Font.BOLD, 23);
   private Font middle = new Font("맑은 고딕", Font.PLAIN, 17);
   private Font small = new Font("맑은 고딕", Font.BOLD, 20);
   
   
   public Player_info(){   
      
      //큰틀 , 기본값 설정
      contentPane = getContentPane();
      setTitle("정보 입력");
      
      //큰 패널 추가
      contentPane.setLayout(new BorderLayout());
      
      
     JButton enter = new JButton("시작");
     
     contentPane.add(enter,"South");
     
     enter.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String RedName = inputName1.getText();
			String RedWeight = inputWeight1.getText();
			String RedGroup = inputGroup1.getText();
						
			String BlueName = inputName2.getText();
			String BlueWeight = inputWeight2.getText();
			String BlueGroup = inputGroup2.getText();
			
			if(RedName.equals("") || RedWeight.equals("") || RedGroup.equals("") || BlueName.equals("") || BlueWeight.equals("") || BlueGroup.equals("") || kingtext.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "선수정보를 모두 입력하세요", "정보입력 에러", JOptionPane.WARNING_MESSAGE);
			}else {
				Player RedPlayer = new Player(RedName,RedGroup,RedWeight);
				
				Player BluePlayer = new Player(BlueName,BlueGroup,BlueWeight);
				
				String howManyPlayGame = new String();
				setNoVisible();
				if(type[0].isSelected()) {
					howManyPlayGame= "5";
				}else {
					howManyPlayGame = "3";
				}
				new GameScreen(kingtext.getText(),howManyPlayGame,BluePlayer, RedPlayer);
			}
			
		}
	});
      

      //North 패널 레이아웃 나누기
      North = new JPanel(new GridLayout(1, 2));
      north();
      
      //센터
      Center = new JPanel(new GridLayout(1, 2));
      centerLeft();
      centerRight();
   
      //설정
      setTitle("정보 입력");
      setSize(800,500);
      setLocation(400, 100);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      }
   

   private void north() {
       
       //레이아웃
       king = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,10));
       checkbox = new JPanel();
       king.setBackground(Color.black);
       checkbox.setBackground(Color.black);
       
       //레이블
       kinglabel = new JLabel("주관 : ");
       kinglabel.setFont(Big);
       kinglabel.setForeground(Color.white); 
       
       //텍스트 필드
       kingtext =new JTextField(15);
       
       //체크박스      
       type[0] = new JRadioButton("5판 3선제",false);
       type[1] = new JRadioButton("3판 2선제",false);
       type[0].setFont(Big);
       type[1].setFont(Big);
       type[0].setBackground(Color.black);
       type[1].setBackground(Color.black);
       checkbox.setBackground(Color.black);
       type[0].setForeground(Color.white); 
       type[1].setForeground(Color.white);
       type[1].setSelected(true);
       //라디오 버튼 그룹화
       ButtonGroup groupRd = new ButtonGroup();
       groupRd.add(type[0]);
       groupRd.add(type[1]);
       this.add(type[0]);
       this.add(type[1]);
       
       
       //패널 배치
       king.add(kinglabel);
       king.add(kingtext);
       checkbox.add(type[0]);
       checkbox.add(type[1]);
       North.add(king);
       North.add(checkbox);
       
       contentPane.add(North,"North");
    
    }

      private void centerRight() {
         
         //레이아웃 나누기
         Left = new JPanel(new GridLayout(4,1));
         p0 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         
         //배경색  설정
         p0.setBackground(Color.black);
         p1.setBackground(Color.black);
         p2.setBackground(Color.black);
         p3.setBackground(Color.black);
         
         //레이블 
         red=new JLabel("홍코너");
         name1 = new JLabel("이름 :");
         group1 = new JLabel("소속 :");
         weight1 = new JLabel("몸무게 :");
         	
         //레이블 폰트 적용
         red.setFont(small);
         red.setForeground(Color.red);
         name1.setFont(middle);
         name1.setForeground(Color.white); 
         group1.setFont(middle);
         group1.setForeground(Color.white); 
         weight1.setFont(middle);
         weight1.setForeground(Color.white); 
         
         //텍스트 필드
         inputName1 = new JTextField(10);
         inputGroup1= new JTextField(10);
         inputWeight1= new JTextField(10);
         
         //패널에 추가
         p0.add(red);
         p1.add(name1);
         p1.add(inputName1);
         p2.add(group1);
         p2.add(inputGroup1);
         p3.add(weight1);
         p3.add(inputWeight1);
         
         Left.add(p0);
         Left.add(p1);
         Left.add(p2);
         Left.add(p3);
         
         Center.add(Left);
         contentPane.add(Center,"Center");
         
      }
      
      private void centerLeft() {
         
         //레이아웃 나누기
         Right= new JPanel(new GridLayout(4,1));
         p00 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p11 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p22 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p33 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         
         //배경색  설정
         p00.setBackground(Color.black);
         p11.setBackground(Color.black);
         p22.setBackground(Color.black);
         p33.setBackground(Color.black);
         
         //레이블 
         blue=new JLabel("청코너");
         name2= new JLabel("이름 :");
         group2 = new JLabel("소속 :");
         weight2 = new JLabel("몸무게 :");
         
         //레이블 폰트 적용
         blue.setFont(small);
         blue.setForeground(Color.blue);
         name2.setFont(middle);
         name2.setForeground(Color.white); 
         group2.setFont(middle);
         group2.setForeground(Color.white); 
         weight2.setFont(middle);
         weight2.setForeground(Color.white); 
         
         //텍스트 필드
         inputName2 = new JTextField(10);
         inputGroup2= new JTextField(10);
         inputWeight2= new JTextField(10);
         
         //패널에 추가
         p00.add(blue);
         p11.add(name2);
         p11.add(inputName2);
         p22.add(group2);
         p22.add(inputGroup2);
         p33.add(weight2);
         p33.add(inputWeight2);
         
         Right.add(p00);
         Right.add(p11);
         Right.add(p22);
         Right.add(p33);
         
         Center.add(Right);
         contentPane.add(Center,"Center");
         
      }

      public void setNoVisible() {
    	  this.setVisible(false);
      }

      
}