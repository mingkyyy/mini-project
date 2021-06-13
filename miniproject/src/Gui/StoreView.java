package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class StoreView extends JFrame implements ActionListener{
	private JPanel bigpanel,leftPanel,rightlPanel,storePanel,buttonPanel;
	private TextArea textarea;
	private TextArea textarea2;
	private JButton addbutton, backButton,deletebutton,updatebutton;
	private JLabel storename;
	private JTable table;
	private JScrollPane scrollPane;
	public String foodname, foodpicture,foodprice;
	
	


	public StoreView(){	
		super("미니 프로젝트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		
		storename=new JLabel("가게 이름");
		
		textarea=new TextArea();		
		textarea.setPreferredSize(new Dimension(400,600));
		
		textarea2=new TextArea();		
		textarea2.setPreferredSize(new Dimension(400,200));
		
		  String[] header= {"음식이름","음식금액","음식 사진"};
			String[][] contents={
					{"","",""}
			};
					
			DefaultTableModel model=new DefaultTableModel(contents,header);
			table=new JTable(model);
			scrollPane = new JScrollPane(table);
			table.setRowHeight(80);
		
		addbutton=new JButton("추가");
		addbutton.setPreferredSize(new Dimension(150,100));
        addbutton.addActionListener(this);
        
        deletebutton=new JButton("삭제");
        deletebutton.setPreferredSize(new Dimension(150,100));
        deletebutton.addActionListener(this);
        
        
        updatebutton=new JButton("수정");
        updatebutton.setPreferredSize(new Dimension(150,100));
        updatebutton.addActionListener(this);
        
		
		backButton=new JButton("back");
		backButton.setPreferredSize(new Dimension(60,5));
		backButton.addActionListener(this);
		
		
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		buttonPanel.add(addbutton);
		buttonPanel.add(deletebutton);
		buttonPanel.add(updatebutton);
		buttonPanel.setPreferredSize(new Dimension(500,80));
		
		
		storePanel=new JPanel();
		storePanel.setLayout(new BorderLayout());
		storePanel.add(backButton,BorderLayout.WEST);
		storePanel.add(storename,BorderLayout.CENTER);
		
		
		storePanel.setPreferredSize(new Dimension(500,30));
	

		rightlPanel = new JPanel();
		rightlPanel.setLayout(new BorderLayout());
		rightlPanel.add(textarea,BorderLayout.CENTER);
		rightlPanel.add(textarea2,BorderLayout.SOUTH);
		rightlPanel.setPreferredSize(new Dimension(300,450));
		
		leftPanel=new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(storePanel,BorderLayout.NORTH);
		leftPanel.add(scrollPane, BorderLayout.CENTER);
		leftPanel.add(buttonPanel,BorderLayout.SOUTH);
	   
		
		bigpanel=new JPanel();
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(addbutton)) {
			String foodname=JOptionPane.showInputDialog("추가할 음식 이름을 입력하세요");
			String foodprice=JOptionPane.showInputDialog("추가할 음식 가격을 입력하세요");
			String foodpicture=JOptionPane.showInputDialog("추가할 사진 경로를 입력하세요");
			
		    DefaultTableModel m=(DefaultTableModel)table.getModel();
		    m.insertRow(0, new Object[] {foodname,foodprice,foodpicture});
			table.updateUI();
			
		}
		else if(e.getSource().equals(deletebutton)) {
			String deletefood=JOptionPane.showInputDialog("삭제 할 음식이름을 입력하세요");
			
			for(int i=0; i<table.getRowCount(); i++) {
				if(deletefood.equals(table.getValueAt(i, 0))) {
					DefaultTableModel m=(DefaultTableModel)table.getModel();
					m.removeRow(i);
					return;
				}else {
					JOptionPane.showMessageDialog(null, "삭제할 음식이 존재 하지 않습니다");
					return;
				}
			}
			
		}else if(e.getSource().equals(updatebutton)) {
			String updatefood=JOptionPane.showInputDialog("수정할 음식 이름을 선택하세요");
			String update=JOptionPane.showInputDialog("1:이름수정, 2: 가격 수정, 3:사진 수정");
			
			for(int i=0; i<table.getRowCount(); i++) {
				if(updatefood.equals(table.getValueAt(i, 0))) {		
					if(update.equals("1")) {
						DefaultTableModel m=(DefaultTableModel)table.getModel();
						String newname = JOptionPane.showInputDialog("수정 할 이름을 입력하세요");						
						m.setValueAt(newname, i, 0);
						return;
						
					}else if(update.equals("2")) {
						String newprice = JOptionPane.showInputDialog("수정 할 가격 입력하세요");						
						DefaultTableModel m=(DefaultTableModel)table.getModel();
						m.setValueAt(newprice, i, 1);
						return;
					}else if(update.equals("3")) {
						String newpicture = JOptionPane.showInputDialog("수정 할 사진 입력하세요");
						DefaultTableModel m=(DefaultTableModel)table.getModel();
						m.setValueAt(newpicture, i, 2);
						return;
					}
				}else {
					JOptionPane.showMessageDialog(null, "수정할 음식이 존재 하지 않습니다");
					return;
				}
			
			}
		}else if(e.getSource().equals(backButton)) {
			new MainView();
			setVisible(false);
			
		}
			
		}
		
	}


