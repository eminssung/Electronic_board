package ssireum.input;

import javax.swing.*;
import java.awt.*;

public class Player_info extends JFrame {
   
   static public Container contentPane;
   private JPanel North,Center; // 상단,센터
   
   //상단 패널 구성요소
   private JPanel king,checkbox;
   private JLabel kinglabel;//주관
   private JTextField kingtext;
   private JCheckBox[] type=new JCheckBox[2];//유형
   

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
      setTitle("game and player info");
      
      //큰 패널 추가
      contentPane.setLayout(new BorderLayout());
      
      //North 패널 레이아웃 나누기
      North = new JPanel(new GridLayout(1, 2));
      north();
      
      //센터
      Center = new JPanel(new GridLayout(1,2));
      centerLeft();
      centerRight();
   
      //설정
      setTitle("game and player info");
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
         kingtext =new JTextField(10);
         
         //체크박스      
         type[0] = new JCheckBox("5판 3선제",false);
         type[1] = new JCheckBox("3판 2선제",false);
         type[0].setFont(Big);
         type[1].setFont(Big);
         type[0].setBackground(Color.black);
         type[1].setBackground(Color.black);
         checkbox.setBackground(Color.black);
         type[0].setForeground(Color.white); 
         type[1].setForeground(Color.white);
         
         //패널 배치
         king.add(kinglabel);
         king.add(kingtext);
         checkbox.add(type[0]);
         checkbox.add(type[1]);
         North.add(king);
         North.add(checkbox);
         
         contentPane.add(North,"North");
      
      }

      
      private void centerLeft() {
         
         //레이아웃 나누기
         Left = new JPanel(new GridLayout(4,1));
         p0 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
         p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
         
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
      
      private void centerRight() {
          
          //레이아웃 나누기
          Left = new JPanel(new GridLayout(4,1));
          p0 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
          p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
          p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
          p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
          
          //배경색  설정
          p0.setBackground(Color.black);
          p1.setBackground(Color.black);
          p2.setBackground(Color.black);
          p3.setBackground(Color.black);
          
          //레이블 
          blue=new JLabel("청코너");
          name1 = new JLabel("이름 :");
          group1 = new JLabel("소속 :");
          weight1 = new JLabel("몸무게 :");
          
          //레이블 폰트 적용
          blue.setFont(small);
          blue.setForeground(Color.blue);
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
          p0.add(blue);
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
      
}