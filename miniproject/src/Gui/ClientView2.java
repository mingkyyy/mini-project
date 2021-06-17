package Gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import Dao.ordersDao;
import Dto.ordersDto;

/**
 * 
 * 가게2. 가게에서 반찬을 주문하는 시스템
 *
 */
public class ClientView2 extends JFrame implements ActionListener, MouseListener {
	private JPanel bigpanel, leftPanel, storePanel, rightPanel;
	private TextArea textarea, textarea2;
	private JButton backButton, orderButton;
	private JLabel storename;
	private JTable table;
	private JScrollPane scrollPane;
	int sum;
	SimpleDateFormat format;
	Calendar time;
	ordersDto ordersdto;
	ImageIcon imageicon,imageicon2,imageicon3,imageicon4,imageicon5,imageicon6,imageicon7,imageicon8;
	
	/**
	 * 
	 * @param icon 화면에 표시될 이미지 아이콘
	 * @param i 가로축의 길이
	 * @param j 세로축의 길이
	 * @return 가로세로축의 길이로 조절된 이미지 아이콘
	 */
	ImageIcon imageSetSize(ImageIcon icon, int i, int j ) { //이미지 크기 조절 클래스
		Image ximg=icon.getImage();
		Image yimg=ximg.getScaledInstance(i, j, Image.SCALE_SMOOTH);
		ImageIcon xyimg=new ImageIcon(yimg);
		return xyimg;
	}
	
	

	public ClientView2() {

		super("모녀소반");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
				
		storename = new JLabel("가게2");
		imageicon = new ImageIcon("food15.jpg");
		imageicon2 = new ImageIcon("food16.jpg");
		imageicon3= new ImageIcon("food17.jpg");
		imageicon4 = new ImageIcon("food18.jpg");
		imageicon5 = new ImageIcon("food19.jpg");
		imageicon6 = new ImageIcon("food23.jpg");
		imageicon7 = new ImageIcon("food21.jpg");
		imageicon8 = new ImageIcon("food22.jpg");
		
		imageicon=imageSetSize(imageicon, 120, 100);
		imageicon2=imageSetSize(imageicon2, 120, 100);
		imageicon3=imageSetSize(imageicon3, 120, 100);
		imageicon4=imageSetSize(imageicon4, 120, 100);
		imageicon5=imageSetSize(imageicon5, 120, 100);
		imageicon6=imageSetSize(imageicon6, 120, 100);
		imageicon7=imageSetSize(imageicon7, 120, 100);
		imageicon8=imageSetSize(imageicon8, 120, 100);
		

		String[] header = { "음식이름", "음식금액", "음식사진" };
		Object[][] contents = { 
				{ "부침개", "4000", imageicon }, 
				{ "오이소박이", "3000", imageicon2}, 
				{ "감자조림", "5000", imageicon3 },
				{ "단호박샐러드", "2000", imageicon4 },
				{ "가지볶음", "3000", imageicon5 },
				{ "잡채", "5000", imageicon6 },
				{ "모듬나물", "5500", imageicon7 },
				{ "동그랑땡", "4500", imageicon8 }
			

		};	
		/**
		 * jtable imageicon String 형이 아니라 imageicon 으로 보여지게 함
		 */	
		DefaultTableModel model = new DefaultTableModel(contents, header) {

			@Override 
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
		/**
		 * Jtable 샐 수정 불가
		 */
		table = new JTable(model) { 
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.getColumn("음식이름").setPreferredWidth(200);
		table.getColumn("음식금액").setPreferredWidth(200);
		table.getColumn("음식사진").setPreferredWidth(200);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFont(new Font("Magneto 굵게", Font.BOLD, 15));

		/**
		 * jtable 값 가운데 정렬
		 */
		DefaultTableCellRenderer dtc = new DefaultTableCellRenderer(); // table 안의 값 가운데 정렬
		dtc.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		
		for (int i = 0; i < 2; i++) {
			tcm.getColumn(i).setCellRenderer(dtc);
	}
		
		table.addMouseListener(this);
		scrollPane = new JScrollPane(table);
		table.setRowHeight(100);

		backButton = new JButton("back");
		backButton.setPreferredSize(new Dimension(60, 5));
		backButton.addActionListener(this);

		textarea = new TextArea();
		textarea.setPreferredSize(new Dimension(300, 620));

		textarea2 = new TextArea();
		textarea2.setPreferredSize(new Dimension(300, 100));

		orderButton = new JButton("주문");
		orderButton.setPreferredSize(new Dimension(300, 80));
		orderButton.addActionListener(this);

		storePanel = new JPanel();
		storePanel.setLayout(new BorderLayout());
		storePanel.add(backButton, BorderLayout.WEST);
		storePanel.add(storename, BorderLayout.CENTER);
		storePanel.setPreferredSize(new Dimension(500, 30));

		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(storePanel, BorderLayout.NORTH);
		leftPanel.add(scrollPane, BorderLayout.CENTER);

		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(textarea, BorderLayout.NORTH);
		rightPanel.add(textarea2, BorderLayout.CENTER);
		rightPanel.add(orderButton, BorderLayout.SOUTH);

		bigpanel = new JPanel();
		bigpanel.setLayout(new BorderLayout());
		bigpanel.add(leftPanel, BorderLayout.CENTER);
		bigpanel.add(rightPanel, BorderLayout.EAST);

		this.add(bigpanel);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ClientView2();

	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(backButton)) {
			new SearchView();
			setVisible(false);
		} else if (e.getSource().equals(orderButton)) {
			JOptionPane.showMessageDialog(this, "주문 하시겠습니까?");
			
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time = Calendar.getInstance();
			String format_time = format.format(time.getTime());
			ordersdto = new ordersDto();
			ordersdto.setOrderdata(format_time);
			ordersDao.getInstance().insert(ordersdto);

			textarea.setText("");
			textarea2.setText("");
		}

	}
	/**
	 * 사용자가 주문 총 합
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

		int row = table.getSelectedRow();
		String foodname = (String) table.getValueAt(row, 0);
		String foodprice = (String) table.getValueAt(row, 1);
		textarea.setText(textarea.getText() + foodname + " : " + foodprice + "원" + "\n");
		sum += Integer.parseInt((String) table.getValueAt(row, 1));
		textarea2.setText("총 금액" + sum + "원");

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