package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.table.TableModel;


public class StoreView extends JFrame{
	private JPanel bigpanel,leftPanel,rightlPanel,storePanel,buttonPanel;
	private TextArea textarea;
	private TextArea textarea2;
	private JButton addbutton, backButton,deletebutton,updatebutton;
	private JTable table;
	private JScrollPane scrollPane;
	public String foodname, foodpicture,foodprice;
	
	
	public StoreView(){	
		super("미니 프로젝트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		
		
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
        addbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String foodname=JOptionPane.showInputDialog("추가할 음식 이름을 입력하세요");
				String foodprice=JOptionPane.showInputDialog("추가할 음식 가격을 입력하세요");
				String foodpicture=JOptionPane.showInputDialog("추가할 사진 경로를 입력하세요");
				
			    DefaultTableModel m=(DefaultTableModel)table.getModel();
			    m.insertRow(0, new Object[] {foodname,foodprice,foodpicture});
				table.updateUI();
				
				
			}
		});
        
        deletebutton=new JButton("삭제");
        deletebutton.setPreferredSize(new Dimension(150,100));
        deletebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
        
        updatebutton=new JButton("수정");
        updatebutton.setPreferredSize(new Dimension(150,100));
		
		backButton=new JButton("back");
		backButton.setPreferredSize(new Dimension(60,5));
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainView();
				setVisible(false);
				
			}
		});
		


		
		
		buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		buttonPanel.add(addbutton);
		buttonPanel.add(deletebutton);
		buttonPanel.add(updatebutton);
		buttonPanel.setPreferredSize(new Dimension(500,80));
		
		
		storePanel=new JPanel();
		storePanel.setLayout(new BorderLayout());
		storePanel.add(backButton,BorderLayout.WEST);
		
		
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

}