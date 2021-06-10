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
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class StoreView extends JFrame{
	private JPanel bigpanel;
	private JPanel leftPanel;
	private JPanel rightlPanel;
	private JPanel storePanel;		
	private JLabel storename;
	private JLabel store;
	private TextArea textarea;
	private TextArea textarea2;
	private JButton button, backButton;
	private JLabel picturLabel1, picturLabel2,picturLabel3,picturLabel4;
	private JLabel foodLabel,foodLabel2 ,foodLabel3,foodLabel4;
	private JLabel foodnameLabel, foodnameLabel2,foodnameLabel3,foodnameLabel4;
	private JPanel foodPanel, foodPanel2,foodPanel3,foodPanel4;
	private JPanel bigfoodPanel;
	
	
	public StoreView(){	
		super("미니 프로젝트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		
		
		textarea=new TextArea();		
		textarea.setPreferredSize(new Dimension(400,600));
		
		textarea2=new TextArea();		
		textarea2.setPreferredSize(new Dimension(400,200));
		
		button=new JButton("추가");
		button.setPreferredSize(new Dimension(400,100));
		
		backButton=new JButton("back");
		backButton.setPreferredSize(new Dimension(60,5));
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainView();
				setVisible(false);
				
			}
		});
				
		
		picturLabel1=new JLabel("picture");	
		picturLabel1.setPreferredSize(new Dimension(200,400));;
		picturLabel1.setOpaque(true);
		picturLabel1.setBackground(Color.WHITE);
		foodnameLabel=new JLabel("음식 이름");
		foodnameLabel.setPreferredSize(new Dimension(150,400));
		foodnameLabel.setOpaque(true);
		foodnameLabel.setBackground(Color.LIGHT_GRAY);
		foodnameLabel.setPreferredSize(new Dimension(150,400));
		foodLabel=new JLabel("음식 가격");	
		foodLabel.setOpaque(true);
		foodLabel.setBackground(Color.GRAY);
		foodLabel.setPreferredSize(new Dimension(50,50));
		
		picturLabel2=new JLabel("picture2");	
		picturLabel2.setPreferredSize(new Dimension(200,400));;
		picturLabel2.setOpaque(true);
		picturLabel2.setBackground(Color.gray);
		foodnameLabel2=new JLabel("음식 이름2");
		foodnameLabel2.setPreferredSize(new Dimension(150,400));
		foodnameLabel2.setOpaque(true);
		foodnameLabel2.setBackground(Color.white);
		foodnameLabel2.setPreferredSize(new Dimension(150,400));
		foodLabel2=new JLabel("음식 가격2");	
		foodLabel2.setOpaque(true);
		foodLabel2.setBackground(Color.darkGray);
		foodLabel2.setPreferredSize(new Dimension(50,50));
		
		picturLabel3=new JLabel("picture3");	
		picturLabel3.setPreferredSize(new Dimension(200,400));;
		picturLabel3.setOpaque(true);
		picturLabel3.setBackground(Color.WHITE);
		foodnameLabel3=new JLabel("음식 이름3");
		foodnameLabel3.setPreferredSize(new Dimension(150,400));
		foodnameLabel3.setOpaque(true);
		foodnameLabel3.setBackground(Color.darkGray);
		foodnameLabel3.setPreferredSize(new Dimension(150,400));
		foodLabel3=new JLabel("음식 가격3");	
		foodLabel3.setOpaque(true);
		foodLabel3.setBackground(Color.gray);
		foodLabel3.setPreferredSize(new Dimension(50,50));
		
		picturLabel4=new JLabel("pcture4");	
		picturLabel4.setPreferredSize(new Dimension(200,400));;
		picturLabel4.setOpaque(true);
		picturLabel4.setBackground(Color.GRAY);
		foodnameLabel4=new JLabel("음식 이름4");
		foodnameLabel4.setPreferredSize(new Dimension(150,400));
		foodnameLabel4.setOpaque(true);
		foodnameLabel4.setBackground(Color.WHITE);
		foodnameLabel4.setPreferredSize(new Dimension(150,400));
		foodLabel4=new JLabel("음식 가격4");	
		foodLabel4.setOpaque(true);
		foodLabel4.setBackground(Color.LIGHT_GRAY);
		foodLabel4.setPreferredSize(new Dimension(150,400));
				
		
		storename=new JLabel("가게 이름");
		storename.setOpaque(true);
		storename.setBackground(Color.WHITE);
		store=new JLabel("가게 설명 어쩌구 저쩌구");
		store.setPreferredSize(new Dimension(300,25));
		store.setOpaque(true);
		store.setBackground(Color.LIGHT_GRAY);
				

		foodPanel=new JPanel();
		foodPanel.setLayout(new BorderLayout());
		foodPanel.add(picturLabel1, BorderLayout.EAST);		
		foodPanel.add(foodnameLabel, BorderLayout.WEST);
		foodPanel.add(foodLabel, BorderLayout.CENTER);
		foodPanel.setPreferredSize(new Dimension(400,100));
		

		foodPanel2=new JPanel();
		foodPanel2.setLayout(new BorderLayout());
		foodPanel2.add(picturLabel2, BorderLayout.EAST);		
		foodPanel2.add(foodnameLabel2, BorderLayout.WEST);
		foodPanel2.add(foodLabel2, BorderLayout.CENTER);
		foodPanel2.setPreferredSize(new Dimension(400,100));
		
		foodPanel3=new JPanel();
		foodPanel3.setLayout(new BorderLayout());
		foodPanel3.add(picturLabel3, BorderLayout.EAST);		
		foodPanel3.add(foodnameLabel3, BorderLayout.WEST);
		foodPanel3.add(foodLabel3, BorderLayout.CENTER);
		foodPanel3.setPreferredSize(new Dimension(400,100));
		
		foodPanel4=new JPanel();
		foodPanel4.setLayout(new BorderLayout());
		foodPanel4.add(picturLabel4, BorderLayout.EAST);		
		foodPanel4.add(foodnameLabel4, BorderLayout.WEST);
		foodPanel4.add(foodLabel4, BorderLayout.CENTER);
		foodPanel4.setPreferredSize(new Dimension(400,100));
		
		bigfoodPanel=new JPanel();
		bigfoodPanel.setLayout(new GridLayout(4,1));
		bigfoodPanel.add(foodPanel);
		bigfoodPanel.add(foodPanel2);
		bigfoodPanel.add(foodPanel3);
		bigfoodPanel.add(foodPanel4);
		
		
		
		storePanel=new JPanel();
		storePanel.setLayout(new BorderLayout());
		storePanel.add(backButton,BorderLayout.WEST);
		storePanel.add(store,BorderLayout.EAST);
		storePanel.add(storename,BorderLayout.CENTER);

		rightlPanel = new JPanel();
		rightlPanel.setLayout(new BorderLayout());
		rightlPanel.add(textarea,BorderLayout.CENTER);
		rightlPanel.add(textarea2,BorderLayout.SOUTH);
		rightlPanel.setPreferredSize(new Dimension(300,450));
		
		leftPanel=new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(storePanel,BorderLayout.NORTH);
		leftPanel.add(bigfoodPanel, BorderLayout.CENTER);
		leftPanel.add(button,BorderLayout.SOUTH);
	   
		
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