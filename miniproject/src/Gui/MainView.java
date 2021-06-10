package Gui;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame  {
private JButton loginButton, singUpButton, backButton;
private JButton findButton, myShopButton;
private CardLayout card;

	public MainView() {
		super("반찬 on subway");
		setLayout(new BorderLayout());
		add(getNorthPanel(),BorderLayout.NORTH);
		add(getCenterPanel(), BorderLayout.CENTER);
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(800, 800));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MainView();
	}
	
	private JPanel getCenterPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 720));
		
		JLabel mainName = new JLabel("반찬 \n on subway");
		mainName.setFont(new Font("Magneto 굵게",Font.BOLD , 40));
		mainName.setHorizontalAlignment(JLabel.CENTER);
		mainName.setBounds(150, 200, 400, 100 );
		
		findButton = new JButton("가게 찾기");
		findButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchView();
				setVisible(false);
				
			}
		});
		myShopButton = new JButton("찜한 가게");
		myShopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FavoriteView();
				setVisible(false);
				
			}
		});
		
		
		findButton.setBounds(150, 400, 150, 100);
		myShopButton.setBounds(350, 400, 150, 100);
		
		panel.setLayout(null);
		panel.add(mainName);
		panel.add(findButton);
		panel.add(myShopButton);
		
		
		return panel;
		
	}
	
	private JPanel getNorthPanel() {
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginView();
				setVisible(false);
				
			}
		});
		singUpButton = new JButton("Sing Up");
		singUpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUpView();
				setVisible(false);
				
			}
		});
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		panel.add(loginButton);
		panel.add(singUpButton);
		
		return panel;
	}



	
}
