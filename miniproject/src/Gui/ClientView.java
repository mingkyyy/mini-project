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


public class ClientView extends JFrame implements ActionListener{
	private JPanel bigpanel,leftPanel,storePanel,buttonPanel;
	private TextArea textarea;
	private JButton  backButton;
	private JLabel storename;
	private JTable table;
	private JScrollPane scrollPane;
	public String foodname, foodpicture,foodprice;
	
	


	public ClientView(){	
		super("미니 프로젝트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		
		storename=new JLabel("가게 이름");
		
		textarea=new TextArea();		
		textarea.setPreferredSize(new Dimension(300,800));
		
		
		  String[] header= {"음식이름","음식금액","음식 사진"};
			String[][] contents={
					{"a","500",""},
					{"b","700",""},
					{"c","800",""}
					
			};
					
			DefaultTableModel model=new DefaultTableModel(contents,header);
			table=new JTable(model);
			scrollPane = new JScrollPane(table);
			table.setRowHeight(80);
		
		
        
		
		backButton=new JButton("back");
		backButton.setPreferredSize(new Dimension(60,5));
		backButton.addActionListener(this);
		
	
		storePanel=new JPanel();
		storePanel.setLayout(new BorderLayout());
		storePanel.add(backButton,BorderLayout.WEST);
		storePanel.add(storename,BorderLayout.CENTER);	
		storePanel.setPreferredSize(new Dimension(500,30));
	

		
		
		leftPanel=new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(storePanel,BorderLayout.NORTH);
		leftPanel.add(scrollPane, BorderLayout.CENTER);
		
	   
		
		bigpanel=new JPanel();
		bigpanel.setLayout(new BorderLayout());	
		bigpanel.add(leftPanel, BorderLayout.CENTER);
		bigpanel.add(textarea, BorderLayout.EAST);
		
		this.add(bigpanel);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new ClientView();
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(backButton)) {
			new MainView();
			setVisible(false);
		}
		
	}
}