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
	private JPanel North,Center,South; // 상단,센터,하단부

	//상단 패널 구성요소
	private JPanel first,second,file,empty,radiobutton,image;
	private JTextArea fileName,imageRoute,soundRoute; 
	private JButton readFile,readRoute,soundReadButton; // 파일 가져오기 버튼
	private ButtonGroup group = new ButtonGroup(); // 라디오버튼 그룹
	private JRadioButton[] type = new JRadioButton[3];//유형

	//센터 패널 (테이블) 구성요소
	private static JTable table;
	private String title[] = { "이름", "소속","몸무게" };
	private DefaultTableModel model;
	private JScrollPane scrollpane;


	//하단패널 구성요소
	private JButton startbutton;

	// 폰트
	private Font Big = new Font("맑은 고딕", Font.BOLD, 23);
	private Font middle = new Font("맑은 고딕", Font.PLAIN, 17);
	private Font small = new Font("맑은 고딕", Font.PLAIN, 13);


	//더미 배열
	Player[] player = new Player[100];
	List<Player> playerList;

	//아이콘
	String iconPath,soundPath;

	public Player_info() throws EncryptedDocumentException, IOException { 

		//큰틀 , 기본값 설정
		contentPane = getContentPane();
		setTitle("SsungMinLove");

		//큰 패널 추가
		contentPane.setLayout(new BorderLayout());

		//North 패널 레이아웃 나누기
		North = new JPanel(new GridLayout(2,1));
		north();

		//센터
		Center = new JPanel(new FlowLayout(FlowLayout.LEFT, 90,12));
		Center.setBackground(Color.white);
		center();


		//하단
		South = new JPanel(new FlowLayout(FlowLayout.RIGHT,40 ,20));
		South.setBackground(Color.white);
		south();

		//설정
		setTitle("Layout");
		setSize(1000,600);
		setLocation(400, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void north() {
		//레이아웃
		first = new JPanel(new FlowLayout(FlowLayout.LEFT, 30,5));
		second = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		empty = new JPanel (new FlowLayout(FlowLayout.LEFT,22,17));
		radiobutton = new JPanel(new FlowLayout(FlowLayout.LEFT, 22,17));
		first.setBackground(Color.white);
		empty.setBackground(Color.white);
		second.setBackground(Color.white);

		//텍스트area
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

		//버튼
		readFile = new JButton("파일읽기");
		readFile.setFont(small);

		readRoute = new JButton("배경 선택");
		readRoute.setFont(small);
		
		soundReadButton = new JButton("부저 선택");
		soundReadButton.setFont(small);
	
		//라디오버튼		
		type[0] = new JRadioButton("단판",false);
		type[1] = new JRadioButton("3판 2선제",false);
		type[2] = new JRadioButton("5판3선제",false);

		for( int i=0; i<3; i++) {
			type[i].setFont(middle);
			type[i].setBackground(Color.white);
			group.add(type[i]);
			radiobutton.add(type[i]);

		}
		type[1].setSelected(true);
		radiobutton.setBackground(Color.white);

		//패널 배치
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
					JOptionPane.showMessageDialog(contentPane, "파일을 찾을 수 없습니다.", "정보", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}

		});
		
		readRoute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(imageRoute.getText()!=null) {
					iconPath = imageRoute.getText();
					JOptionPane.showMessageDialog(contentPane, "설정되었습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane, "배경 설정을 해주세요.", "정보", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		
		soundReadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soundRoute.getText()!=null) {
					soundPath = soundRoute.getText();
					JOptionPane.showMessageDialog(contentPane, "설정되었습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane, "부저 설정을 해주세요.", "정보", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}

	public void center() {
		System.out.println("센터");
		//테이블설정
		
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


		//패널배치
		Center.removeAll();
		Center.add(scrollpane);
		contentPane.add(Center,"Center");
		Center.repaint();
		contentPane.repaint();
	}

	public void south() {

		//버튼설정
		startbutton = new JButton("시작하기");
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
				new GameScreen("어쩌구저쩌구",howManyPlayGame,player,playerList.size(),iconPath,soundPath);
			}

		});

		//패널배치
		South.add(startbutton);
		contentPane.add(South,"South");

	}

	public void setNoVisible() {
		this.setVisible(false);
	}

	public static List<Player> getPlayerList(String filePath) throws EncryptedDocumentException, IOException {
		List<Player> studentList = new ArrayList<Player>();
		Scanner scan = new Scanner(System.in);

		System.out.println("리스트 읽어오기: "+ filePath);
		
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
				case 0: // 성명
					player.setName((String)getValueFromCell(cell)); 
					break;
				case 1: // 소속
					player.setAffiliation((String)getValueFromCell(cell)); 
					break; 
				case 2: // 체중 
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
