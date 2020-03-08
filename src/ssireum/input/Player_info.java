package ssireum.input;

import javax.swing.*;
import java.awt.*;

public class Player_info extends JFrame {
   
   static public Container contentPane;
   private JPanel North,Center; // ���,����
   
   //��� �г� �������
   private JPanel king,checkbox;
   private JLabel kinglabel;//�ְ�
   private JTextField kingtext;
   private JCheckBox[] type=new JCheckBox[2];//����
   

   //���� ���� �г� �������
   private JPanel Left;
   private JPanel p0,p1,p2,p3;
   private JLabel red,name1,group1,weight1;
   private JTextField inputName1,inputGroup1,inputWeight1;
   
   //���� ������ �г� �������
   private JPanel Right;
   private JPanel p00,p11,p22,p33;
   private JLabel blue,name2,group2,weight2;
   private JTextField inputName2,inputGroup2,inputWeight2;
      
      
   // ��Ʈ
   private Font Big = new Font("���� ���", Font.BOLD, 23);
   private Font middle = new Font("���� ���", Font.PLAIN, 17);
   private Font small = new Font("���� ���", Font.BOLD, 20);
   
   
   public Player_info(){   
      
      //ūƲ , �⺻�� ����
      contentPane = getContentPane();
      setTitle("game and player info");
      
      //ū �г� �߰�
      contentPane.setLayout(new BorderLayout());
      
      //North �г� ���̾ƿ� ������
      North = new JPanel(new GridLayout(1, 2));
      north();
      
      //����
      Center = new JPanel(new GridLayout(1,2));
      centerLeft();
      centerRight();
   
      //����
      setTitle("game and player info");
      setSize(800,500);
      setLocation(400, 100);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      }
   
      private void north() {
         
         //���̾ƿ�
         king = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,10));
         checkbox = new JPanel();
         king.setBackground(Color.black);
         checkbox.setBackground(Color.black);
         
         //���̺�
         kinglabel = new JLabel("�ְ� : ");
         kinglabel.setFont(Big);
         kinglabel.setForeground(Color.white); 
         
         //�ؽ�Ʈ �ʵ�
         kingtext =new JTextField(10);
         
         //üũ�ڽ�      
         type[0] = new JCheckBox("5�� 3����",false);
         type[1] = new JCheckBox("3�� 2����",false);
         type[0].setFont(Big);
         type[1].setFont(Big);
         type[0].setBackground(Color.black);
         type[1].setBackground(Color.black);
         checkbox.setBackground(Color.black);
         type[0].setForeground(Color.white); 
         type[1].setForeground(Color.white);
         
         //�г� ��ġ
         king.add(kinglabel);
         king.add(kingtext);
         checkbox.add(type[0]);
         checkbox.add(type[1]);
         North.add(king);
         North.add(checkbox);
         
         contentPane.add(North,"North");
      
      }

      
      private void centerLeft() {
         
         //���̾ƿ� ������
         Left = new JPanel(new GridLayout(4,1));
         p0 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
         p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
         p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
         
         //����  ����
         p0.setBackground(Color.black);
         p1.setBackground(Color.black);
         p2.setBackground(Color.black);
         p3.setBackground(Color.black);
         
         //���̺� 
         red=new JLabel("ȫ�ڳ�");
         name1 = new JLabel("�̸� :");
         group1 = new JLabel("�Ҽ� :");
         weight1 = new JLabel("������ :");
         
         //���̺� ��Ʈ ����
         red.setFont(small);
         red.setForeground(Color.red);
         name1.setFont(middle);
         name1.setForeground(Color.white); 
         group1.setFont(middle);
         group1.setForeground(Color.white); 
         weight1.setFont(middle);
         weight1.setForeground(Color.white); 
         
         //�ؽ�Ʈ �ʵ�
         inputName1 = new JTextField(10);
         inputGroup1= new JTextField(10);
         inputWeight1= new JTextField(10);
         
         //�гο� �߰�
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
          
          //���̾ƿ� ������
          Left = new JPanel(new GridLayout(4,1));
          p0 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
          p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,50));
          p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
          p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
          
          //����  ����
          p0.setBackground(Color.black);
          p1.setBackground(Color.black);
          p2.setBackground(Color.black);
          p3.setBackground(Color.black);
          
          //���̺� 
          blue=new JLabel("û�ڳ�");
          name1 = new JLabel("�̸� :");
          group1 = new JLabel("�Ҽ� :");
          weight1 = new JLabel("������ :");
          
          //���̺� ��Ʈ ����
          blue.setFont(small);
          blue.setForeground(Color.blue);
          name1.setFont(middle);
          name1.setForeground(Color.white); 
          group1.setFont(middle);
          group1.setForeground(Color.white); 
          weight1.setFont(middle);
          weight1.setForeground(Color.white); 
          
          //�ؽ�Ʈ �ʵ�
          inputName1 = new JTextField(10);
          inputGroup1= new JTextField(10);
          inputWeight1= new JTextField(10);
          
          //�гο� �߰�
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