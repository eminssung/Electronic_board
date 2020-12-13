package ssireum.input;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import ssireum.GameScreen;
import ssireum.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Player_info extends JFrame {

	static public Container contentPane;
	private JPanel North,Center,South; // ���,����,�ϴܺ�

	//��� �г� �������
	private JPanel first,second,file,empty,radiobutton,image;
	private JTextArea fileName,imageRoute,soundRoute; 
	private JButton readFile,readRoute,soundReadButton; // ���� �������� ��ư
	private ButtonGroup group = new ButtonGroup(); // ������ư �׷�
	private JRadioButton[] type = new JRadioButton[3];//����

	//���� �г� (���̺�) �������
	private static JTable table;
	private String title[] = { "�̸�", "�Ҽ�","������" };
	private DefaultTableModel model;
	private JScrollPane scrollpane;


	//�ϴ��г� �������
	private JButton startbutton;

	// ��Ʈ
	private Font Big = new Font("���� ���", Font.BOLD, 23);
	private Font middle = new Font("���� ���", Font.PLAIN, 17);
	private Font small = new Font("���� ���", Font.PLAIN, 13);


	//���� �迭
	Player[] player = new Player[100];
	List<Player> playerList;

	//������
	String iconPath,soundPath;

	public Player_info() throws EncryptedDocumentException, IOException { 

		//ūƲ , �⺻�� ����
		contentPane = getContentPane();
		setTitle("SsungMinLove");

		//ū �г� �߰�
		contentPane.setLayout(new BorderLayout());

		//North �г� ���̾ƿ� ������
		North = new JPanel(new GridLayout(2,1));
		north();

		//����
		Center = new JPanel(new FlowLayout(FlowLayout.LEFT, 90,12));
		Center.setBackground(Color.white);
		center();


		//�ϴ�
		South = new JPanel(new FlowLayout(FlowLayout.RIGHT,40 ,20));
		South.setBackground(Color.white);
		south();

		//����
		setTitle("Layout");
		setSize(1000,600);
		setLocation(400, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void north() {
		//���̾ƿ�
		first = new JPanel(new FlowLayout(FlowLayout.LEFT, 30,5));
		second = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		empty = new JPanel (new FlowLayout(FlowLayout.LEFT,22,17));
		radiobutton = new JPanel(new FlowLayout(FlowLayout.LEFT, 22,17));
		first.setBackground(Color.white);
		empty.setBackground(Color.white);
		second.setBackground(Color.white);

		//�ؽ�Ʈarea
		fileName = new JTextArea("C:\\play\\test2.xlsx",2,25);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		fileName.setBorder(BorderFactory.createCompoundBorder(border, 
		               BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		
		imageRoute = new JTextArea("C:\\play\\back2.png",2,25);
		imageRoute.setBorder(BorderFactory.createCompoundBorder(border, 
		               BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		
		soundRoute = new JTextArea("C:\\play\\buzzer.wav",2,25);
		soundRoute.setBorder(BorderFactory.createCompoundBorder(border, 
				BorderFactory.createEmptyBorder(2, 2, 2, 2)));

		//��ư
		readFile = new JButton("�����б�");
		readFile.setFont(small);

		readRoute = new JButton("��� ����");
		readRoute.setFont(small);
		
		soundReadButton = new JButton("���� ����");
		soundReadButton.setFont(small);
	
		//������ư		
		type[0] = new JRadioButton("����",false);
		type[1] = new JRadioButton("3�� 2����",false);
		type[2] = new JRadioButton("5��3����",false);

		for( int i=0; i<3; i++) {
			type[i].setFont(middle);
			type[i].setBackground(Color.white);
			group.add(type[i]);
			radiobutton.add(type[i]);

		}
		type[1].setSelected(true);
		radiobutton.setBackground(Color.white);

		//�г� ��ġ
		first.add(fileName);
		first.add(readFile);
		first.add(empty);
		first.add(radiobutton);
		second.add(imageRoute);
		second.add(readRoute);
		second.add(soundRoute);
		second.add(soundReadButton);
		North.add(first);
		North.add(second);
		contentPane.add(North,"North");


		readFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					playerList = getPlayerList(fileName.getText());
					for (int i = 0; i<playerList.size();i++){ 
						player[i]=new Player(playerList.get(i).getName(),playerList.get(i).getAffiliation(),playerList.get(i).getWeight());
					}
					updateTable();
				} catch (EncryptedDocumentException | IOException e1) {
					JOptionPane.showMessageDialog(contentPane, "������ ã�� �� �����ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}

		});
		
		readRoute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(imageRoute.getText()!=null) {
					iconPath = imageRoute.getText();
					JOptionPane.showMessageDialog(contentPane, "�����Ǿ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane, "��� ������ ���ּ���.", "����", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		
		soundReadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soundRoute.getText()!=null) {
					soundPath = soundRoute.getText();
					JOptionPane.showMessageDialog(contentPane, "�����Ǿ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane, "���� ������ ���ּ���.", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}

	public void center() {
		System.out.println("����");
		//���̺���
		
		model = new DefaultTableModel(title, 0);
		table = new JTable(model);

		if(playerList!=null) {
			for (int i = 0; i < playerList.size(); i++) {
				model = (DefaultTableModel) table.getModel();
				if(player[i]==null) {
					model.addRow(new String[] { "","","" });
				}else {
					model.addRow(new String[] { player[i].getName(), player[i].getAffiliation(),player[i].weight });
				}
			}
		}else {
			for (int i = 0; i < 30; i++) {
				model = (DefaultTableModel) table.getModel();
				model.addRow(new String[] { "","","" });
			}
		}


		scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(800, 295));


		//�гι�ġ
		Center.removeAll();
		Center.add(scrollpane);
		contentPane.add(Center,"Center");
		Center.repaint();
		contentPane.repaint();
	}

	public void south() {

		//��ư����
		startbutton = new JButton("�����ϱ�");
		startbutton.setFont(middle);

		startbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				String howManyPlayGame = new String();
				setNoVisible();
				if(type[0].isSelected()) {
					howManyPlayGame= "1";
				}else if(type[1].isSelected()){
					howManyPlayGame = "3";
				}else {
					howManyPlayGame = "5";
				}
				new GameScreen("��¼����¼��",howManyPlayGame,player,playerList.size(),iconPath,soundPath);
			}

		});

		//�гι�ġ
		South.add(startbutton);
		contentPane.add(South,"South");

	}

	public void setNoVisible() {
		this.setVisible(false);
	}

	public static List<Player> getPlayerList(String filePath) throws EncryptedDocumentException, IOException {
		List<Player> studentList = new ArrayList<Player>();
		Scanner scan = new Scanner(System.in);

		System.out.println("����Ʈ �о����: "+ filePath);
		
		InputStream inputStream = new FileInputStream(filePath);

		Workbook workbook = WorkbookFactory.create(inputStream);

		Sheet sheet = workbook.getSheetAt(0); 
		Iterator<Row> rowItr = sheet.iterator();
		while(rowItr.hasNext()) {
			Player player = new Player(); 
			Row row = rowItr.next();
			if(row.getRowNum() == 0) {
				continue; 
			}
			Iterator<Cell> cellItr = row.cellIterator();
			while(cellItr.hasNext()) {
				Cell cell = cellItr.next(); 
				int index = cell.getColumnIndex(); 
				switch(index) {
				case 0: // ����
					player.setName((String)getValueFromCell(cell)); 
					break;
				case 1: // �Ҽ�
					player.setAffiliation((String)getValueFromCell(cell)); 
					break; 
				case 2: // ü�� 
					player.setWeight(Double.toString((double) getValueFromCell(cell))); 
					break; 
				}
			}
			studentList.add(player);
		}
		return studentList;
	}

	private static Object getValueFromCell(Cell cell) {
		switch(cell.getCellType()) {
		case STRING: 
			return cell.getStringCellValue(); 
		case BOOLEAN:
			return cell.getBooleanCellValue(); 
		case NUMERIC: 
			if(DateUtil.isCellDateFormatted(cell)) { 
				return cell.getDateCellValue(); 
			}
			return cell.getNumericCellValue(); 
		case FORMULA: 
			return cell.getCellFormula(); 
		case BLANK: 
			return ""; 
		default:
			return ""; 
		}
	}
	
	public void updateTable() {
		model.setNumRows(0);
		if(playerList!=null) {
			for (int i = 0; i < playerList.size(); i++) {
				model = (DefaultTableModel) table.getModel();
				if(player[i]==null) {
					model.addRow(new String[] { "","","" });
				}else {
					model.addRow(new String[] { player[i].getName(), player[i].getAffiliation(),player[i].weight });
				}
			}
		}else {
			for (int i = 0; i < 30; i++) {
				model = (DefaultTableModel) table.getModel();
				model.addRow(new String[] { "","","" });
			}
		}
	}

}
