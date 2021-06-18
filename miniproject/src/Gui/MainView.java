package Gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 미니프로젝트(반찬가게)를 실행한 메인 gui 실행 클래스
 *
 */

public class MainView extends JFrame implements ActionListener{
private JButton loginButton, signUpButton;
private JButton findButton, myShopButton;



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
	
	
	
	private JPanel getCenterPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 720));
		
		JLabel mainName = new JLabel("반찬 \n on subway");
		mainName.setFont(new Font("Magneto 굵게",Font.BOLD , 40));
		mainName.setHorizontalAlignment(JLabel.CENTER);
		mainName.setBounds(150, 200, 400, 100 );
		
		findButton = new JButton("가게 찾기");
		findButton.addActionListener(this);
		myShopButton = new JButton("내 가게");
		myShopButton.addActionListener(this);
		
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
		loginButton.addActionListener(this);
		signUpButton = new JButton("Sign Up");
		signUpButton.addActionListener(this);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		panel.add(loginButton);
		panel.add(signUpButton);
		
		return panel;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		switch (jButton.getText()) {
		case "Login" : {
			onLoginButtonClick();
			break;
		}
		case "Sign Up": {
			onSignUpButtonClick();
			break;
		}
		case "가게 찾기": {
			onSearchButtonClick();
			break;
		}
		case "내 가게": {
			onFavoriteButtonClick();
			break;
		}
		default:
		
	}
		
	}
	
	private void onLoginButtonClick() {
		LoginView loginView = new LoginView();
		loginView.setVisible(true);
		loginView.setLocationRelativeTo(null);
		
		this.dispose();

	}
	
	
	private void onSignUpButtonClick() {
		SignUpView signUpView = new SignUpView();
		signUpView.setVisible(true);
		signUpView.setLocationRelativeTo(null);
		
		this.dispose();
	}
	
	private void onFavoriteButtonClick() {
		StoreView storeView = new StoreView();
		storeView.setVisible(true);
		storeView.setLocationRelativeTo(null);
		
		this.dispose();
	}
	private void onSearchButtonClick() {
		SearchView searchView = new SearchView();
		searchView.setVisible(true);
		searchView.setLocationRelativeTo(null);
		
		this.dispose();
	}
	
	
	
	public static void main(String[] args) {
		new MainView();
	}
	
}