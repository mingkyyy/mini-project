package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Dao.foodDao;
import Dto.foodDto;

public class StoreView extends JFrame implements ActionListener {
	private JPanel bigpanel, leftPanel, rightlPanel, storePanel, buttonPanel;
	private TextArea textarea;
	private TextArea textarea2;
	private JButton addbutton, backButton, deletebutton, updatebutton;
	private JLabel storename;
	private JTable table;
	private JScrollPane scrollPane;
	ImageIcon imageicon;
	foodDto fooddto;
	
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j ) { //이미지 크기 조절 클래스
		Image ximg=icon.getImage();
		Image yimg=ximg.getScaledInstance(i, j, Image.SCALE_SMOOTH);
		ImageIcon xyimg=new ImageIcon(yimg);
		return xyimg;
	}
	
	

	public StoreView() {

		super("미니 프로젝트");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		
		storename = new JLabel("손 반찬");

		textarea = new TextArea();
		textarea.setPreferredSize(new Dimension(400, 600));

		textarea2 = new TextArea();
		textarea2.setPreferredSize(new Dimension(400, 200));

		String[] header = { "음식이름", "음식금액", "음식 사진" };
		String[][] contents = {

		};
		
		//imageicon = new ImageIcon(foodpicture);
		//imageicon=imageSetSize(imageicon, 200, 20); //이미지 크기 조절


		DefaultTableModel model = new DefaultTableModel(contents, header) {

			@Override // 입력된 형태로 반환 
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
				case 1:
					return String.class;
				case 2:
					return ImageIcon.class;
				default:
					return String.class;
				}
			}

		};
		
		table = new JTable(model){// 테이블 수정 불가
		@Override
			public boolean isCellEditable(int row, int column) {
				return false;
		}
	 	};
		scrollPane = new JScrollPane(table);
	     table.setRowHeight(120);

		DefaultTableCellRenderer dtc = new DefaultTableCellRenderer(); // table 안의 값 강누데 정렬
		dtc.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < table.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtc);

		}

		addbutton = new JButton("추가");
		addbutton.setPreferredSize(new Dimension(150, 100));
		addbutton.addActionListener(this);

		deletebutton = new JButton("삭제");
		deletebutton.setPreferredSize(new Dimension(150, 100));
		deletebutton.addActionListener(this);

		updatebutton = new JButton("수정");
		updatebutton.setPreferredSize(new Dimension(150, 100));
		updatebutton.addActionListener(this);

		backButton = new JButton("back");
		backButton.setPreferredSize(new Dimension(60, 5));
		backButton.addActionListener(this);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3));
		buttonPanel.add(addbutton);
		buttonPanel.add(deletebutton);
		buttonPanel.add(updatebutton);
		buttonPanel.setPreferredSize(new Dimension(500, 80));

		storePanel = new JPanel();
		storePanel.setLayout(new BorderLayout());
		storePanel.add(backButton, BorderLayout.WEST);
		storePanel.add(storename, BorderLayout.CENTER);
		storePanel.setPreferredSize(new Dimension(500, 30));

		rightlPanel = new JPanel();
		rightlPanel.setLayout(new BorderLayout());
		rightlPanel.add(textarea, BorderLayout.CENTER);
		rightlPanel.add(textarea2, BorderLayout.SOUTH);
		rightlPanel.setPreferredSize(new Dimension(300, 450));

		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(storePanel, BorderLayout.NORTH);
		leftPanel.add(scrollPane, BorderLayout.CENTER);
		leftPanel.add(buttonPanel, BorderLayout.SOUTH);

		bigpanel = new JPanel();
		bigpanel.setLayout(new BorderLayout());
		bigpanel.add(leftPanel, BorderLayout.CENTER);
		bigpanel.add(rightlPanel, BorderLayout.EAST);

		this.add(bigpanel);
		setVisible(true);

	}

	public static void main(String[] args) {
		new StoreView();

	}

	@Override
	public void actionPerformed(ActionEvent e) {// 음식 추가
		String foodname = null;
		int foodprice = 0;
		String foodpictrue=null;
		if (e.getSource().equals(addbutton)) {
			foodname = JOptionPane.showInputDialog("추가할 음식 이름을 입력하세요");
			foodprice = Integer.parseInt(JOptionPane.showInputDialog("추가할 음식 가격을 입력하세요"));
			foodpictrue = JOptionPane.showInputDialog("추가할 사진 경로를 입력하세요");
			imageicon = new ImageIcon(foodpictrue);
			imageicon=imageSetSize(imageicon, 120, 100); 
			

			
			DefaultTableModel m = (DefaultTableModel) table.getModel();
			m.insertRow(0, new Object[] { foodname, foodprice, imageicon });
			

			fooddto = new foodDto();
			fooddto.setFoodname(foodname);
			fooddto.setFoodprice(foodprice);
			fooddto.setFoodpicture(foodpictrue);
			foodDao.getInstance().insert(fooddto);

			if (foodname.length() == 0 || foodprice == 0) {
				JOptionPane.showMessageDialog(this, "추가할 음식 이름 또는 음식 가격을 입력해주세요");
				return;
			}

		}

		else if (e.getSource().equals(deletebutton)) { // 삭제
			String deletefood = JOptionPane.showInputDialog("삭제 할 음식이름을 입력하세요");
			foodDto dto = foodDao.getInstance().findByfoodname(deletefood);
			if (foodDao.getInstance().delete(dto.getFoodno()) == 0) {
				JOptionPane.showMessageDialog(null, "삭제할 음식이 존재 하지 않습니다");

			}
			for (int i = 0; i < table.getRowCount(); i++) {
				if (deletefood.equals(table.getValueAt(i, 0))) {
					DefaultTableModel m = (DefaultTableModel) table.getModel();
					m.removeRow(i);
				}
			}

		} else if (e.getSource().equals(updatebutton)) { // 수정
			String updatefood = JOptionPane.showInputDialog("수정할 음식 이름을 선택하세요");		
			String update = JOptionPane.showInputDialog("1:이름수정, 2: 가격 수정, 3:사진 수정");
			for (int i = 0; i < table.getRowCount(); i++) {
				if (updatefood.equals(table.getValueAt(i, 0))) {
					if (update.equals("1")) {
						DefaultTableModel m = (DefaultTableModel) table.getModel();
						String newname = JOptionPane.showInputDialog("수정 할 이름을 입력하세요");
						m.setValueAt(newname, i, 0);
						return;
					} else if (update.equals("2")) {
						int newprice = Integer.parseInt(JOptionPane.showInputDialog("수정 할 가격 입력하세요"));
						DefaultTableModel m = (DefaultTableModel) table.getModel();
						m.setValueAt(newprice, i, 1);
						return;
					} else if (update.equals("3")) {
						String newpicture = JOptionPane.showInputDialog("수정 할 사진 입력하세요");
						imageicon = new ImageIcon(newpicture);
						imageicon=imageSetSize(imageicon, 200, 100); 
						DefaultTableModel m = (DefaultTableModel) table.getModel();
						m.setValueAt(imageicon, i, 2);
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null, "수정할 음식이 존재 하지 않습니다");
					return;
				}

			}
		} else if (e.getSource().equals(backButton)) { // 백 메인 화면으로 가기
			new MainView();
			setVisible(false);

		}
	}
}
