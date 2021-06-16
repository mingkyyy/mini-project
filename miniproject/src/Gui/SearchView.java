package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

//import org.mariadb.jdbc.credential.aws.AwsIamCredentialPlugin;

public class SearchView extends JFrame implements ActionListener,MouseListener {

	private JPanel leftPanel;
	private JPanel bigPanel;
	private JPanel smallPanel;
	private JPanel westPanel;
	private JPanel eastPanel;
	private JLabel subwayLabel;
	private JLabel searchLabel;
	private JLabel store1,store2,store3,store4;
	private JTextField searchField;
	private JButton button, backButton;
	
	ImageIcon icon;

	public SearchView() {
		super("찾기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);

		button = new JButton("search");
		button.addActionListener(this);
		backButton = new JButton("<-");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainView Mainview = new MainView();
				Mainview.setVisible(true);
				Mainview.setLocationRelativeTo(null);

				dispose();

			}
		});

		searchField= new JTextField();
		
		icon = new ImageIcon("신촌역.jpg");
		westPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		store1=new JLabel("해드림찬도시락");	
		store1.setFont(new Font("Magneto 굵게", Font.BOLD, 20));
		store1.addMouseListener(this);	
		
		store2=new JLabel("모녀소반");	
		store2.setFont(new Font("Magneto 굵게", Font.BOLD, 20));
		store2.addMouseListener(this);
		
		store3=new JLabel("다인네 반찬");
		store3.setFont(new Font("Magneto 굵게", Font.BOLD, 20));
		store3.addMouseListener(this);	
		
		store4=new JLabel("예미찬방");
		store4.setFont(new Font("Magneto 굵게", Font.BOLD, 20));
		store4.addMouseListener(this);
		
		westPanel.setPreferredSize(new Dimension(550,800));
		eastPanel = new JPanel(); 
		eastPanel.setPreferredSize(new Dimension(250,800));
		eastPanel.setBackground(Color.white);
		eastPanel.setLayout(new GridLayout(4,1,10,10));
		eastPanel.add(store1);
		eastPanel.add(store2);
		eastPanel.add(store3);
		eastPanel.add(store4);
		eastPanel.setVisible(false);
	    


		searchLabel = new JLabel("지하철 역을 입력하세요:");

		smallPanel = new JPanel(); //상단 패널
		smallPanel.setLayout(new BorderLayout());
		smallPanel.add(backButton, BorderLayout.WEST);

		smallPanel.add(searchField, BorderLayout.CENTER);
		smallPanel.add(button, BorderLayout.EAST);

		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(westPanel, BorderLayout.CENTER);
		leftPanel.add(smallPanel, BorderLayout.NORTH);

		bigPanel = new JPanel();
		bigPanel.setLayout(new BorderLayout());
		bigPanel.add(leftPanel, BorderLayout.CENTER);
		bigPanel.add(eastPanel, BorderLayout.EAST);
		this.add(bigPanel);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (searchField.getText().equals("신촌")) {
			eastPanel.setVisible(true);
			double 위도 = 37.55514583255051;
			double 경도 = 126.93689753734925;
			try {
				Runtime.getRuntime().exec(new String[] { "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
						String.format("https://map.kakao.com/link/map/%f,%f", 위도, 경도)

				});
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) { 
		//가게 이름 라벨 클릭하면 가게로 이동함
		if(e.getSource().equals(store1)) {
			new ClientView();
			setVisible(false);
		}else if(e.getSource().equals(store2)) {
			new ClientView2();
			setVisible(false);
		}else if(e.getSource().equals(store3)) {
			new ClientView3();
			setVisible(false);
		}else if(e.getSource().equals(store4)) {
			new ClientView4();
			setVisible(false);
		}
		
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
	



	public static void main(String[] args) {
		new SearchView();

	}
	

}
