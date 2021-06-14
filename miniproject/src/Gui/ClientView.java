package Gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
import Dao.ordersDao;
import Dto.ordersDto;



public class ClientView extends JFrame implements ActionListener,MouseListener{
	private JPanel bigpanel,leftPanel,storePanel,rightPanel;
	private TextArea textarea,textarea2;
	private JButton  backButton, orderButton;
	private JLabel storename;
	private JTable table;
	private JScrollPane scrollPane;
	int sum;
	SimpleDateFormat format;
	Calendar time;
	ordersDto ordersdto;
	


	public ClientView(){	
		
		super("미니 프로젝트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		
		storename=new JLabel("가게 이름");
		
	
		
		
		
		  Object[] header= {"음식이름","음식금액","음식사진"};
		  Object[][] contents={
					{"a","500",""},
					{"b","700",""},
					{"c","800",""}
					
			};
					
			DefaultTableModel model=new DefaultTableModel(contents,header);		
			table=new JTable(model) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
					
				}
			};
			
			DefaultTableCellRenderer dtc=new DefaultTableCellRenderer(); //table 안의 값 강누데 정렬
			dtc.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcm=table.getColumnModel();
			for(int i=0; i<table.getColumnCount(); i++) {
				tcm.getColumn(i).setCellRenderer(dtc);
				
			}
				
			table.getColumn("음식이름").setPreferredWidth(200);
			table.getColumn("음식금액").setPreferredWidth(200);
			table.getColumn("음식사진").setPreferredWidth(200);
			table.addMouseListener(this);
			scrollPane = new JScrollPane(table);
			table.setRowHeight(100);
			
			
			
        
		
		backButton=new JButton("back");
		backButton.setPreferredSize(new Dimension(60,5));
		backButton.addActionListener(this);
		

		textarea=new TextArea();		
		textarea.setPreferredSize(new Dimension(300,620));
		
		textarea2=new TextArea();		
		textarea2.setPreferredSize(new Dimension(300,100));
		
		orderButton=new JButton("주문");
		orderButton.setPreferredSize(new Dimension(300,80));
		orderButton.addActionListener(this);
		
		
	
		storePanel=new JPanel();
		storePanel.setLayout(new BorderLayout());
		storePanel.add(backButton,BorderLayout.WEST);
		storePanel.add(storename,BorderLayout.CENTER);	
		storePanel.setPreferredSize(new Dimension(500,30));
	

		
		
		leftPanel=new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(storePanel,BorderLayout.NORTH);
		leftPanel.add(scrollPane, BorderLayout.CENTER);
		
	   
		rightPanel=new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(textarea,BorderLayout.NORTH);
		rightPanel.add(textarea2,BorderLayout.CENTER);
		rightPanel.add(orderButton, BorderLayout.SOUTH);
		
		bigpanel=new JPanel();
		bigpanel.setLayout(new BorderLayout());	
		bigpanel.add(leftPanel, BorderLayout.CENTER);
		bigpanel.add(rightPanel, BorderLayout.EAST);
		
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
		}else if(e.getSource().equals(orderButton)) {
			JOptionPane.showMessageDialog(this, "주문 하시겠습니까?");
			//주문 확인버튼 누르면 주문 정보 테이블에 저장해야함.
			format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time=Calendar.getInstance();
			String format_time=format.format(time.getTime());
			  ordersdto = new ordersDto();		
			  ordersdto.setOrderdata(format_time); 	
				ordersDao.getInstance().insert(ordersdto);
				
				textarea.setText(""); 
				textarea2.setText("");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row = table.getSelectedRow();
		String foodname=(String)table.getValueAt(row, 0);
		String foodprice=(String)table.getValueAt(row, 1);
		textarea.setText(textarea.getText()+foodname+" : "+foodprice+"원"+"\n");
		sum+=Integer.parseInt((String) table.getValueAt(row, 1));
		textarea2.setText("총 금액"+sum+"원");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {	
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}
	
}