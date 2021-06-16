package Gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Dao.commonDao;


public class LoginView extends JFrame implements ActionListener {
	JLabel login, pw, idLabel;
	String id;
	JTextField idField;
	JPasswordField pwField;
	JButton loginButton, backButton;
	
	LoginView() {
		super("회원가입");
		setSize(new Dimension(800, 800));

		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 800));

		login = new JLabel("로그인");
		login.setFont(new Font("Magneto 굵게", Font.BOLD, 60));
		idLabel = new JLabel(" 아이디  ");
		idLabel.setFont(new Font("Magneto 굵게", Font.BOLD, 13));
		pw = new JLabel(" 패스워드 ");
		pw.setFont(new Font("Magneto 굵게", Font.BOLD, 13));

		idField = new JTextField();
		pwField = new JPasswordField();

		loginButton = new JButton("로그인");
		backButton = new JButton("<-");

		login.setBounds(250, 100, 300, 100);
		idLabel.setBounds(150, 250, 70, 40);
		pw.setBounds(150, 300, 70, 40);
		idField.setBounds(220, 250, 300, 40);
		pwField.setBounds(220, 300, 300, 40);
		loginButton.setBounds(438, 350, 80, 50);
		backButton.setBounds(0, 0, 50, 40);
		
		loginButton.addActionListener(this);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainView Mainview = new MainView();
				Mainview.setVisible(true);
				Mainview.setLocationRelativeTo(null);

				dispose();

				
			}
		});

		panel.setLayout(null);
		panel.add(login);
		panel.add(idLabel);
		panel.add(pw);
		panel.add(idField);
		panel.add(pwField);
		panel.add(loginButton);
		panel.add(backButton);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
	}

	
		

	@Override
	public void actionPerformed(ActionEvent e) {
		id = idField.getText();
		char[] cpw = pwField.getPassword();
		String pw= String.copyValueOf(cpw);
		
		commonDao dao = commonDao.getInstance();
		int result = dao.loginCheck(id, pw);
		if(result == 1) {
			MainClientView mainClientView = new MainClientView();
			mainClientView.setVisible(true);
			mainClientView.setLocationRelativeTo(null);
			CurrentUser.id = id;
			
			dispose();
			
		}else if(result ==0) {
			
			pwField.setText("비밀번호 불일치");
		}else if(result ==-1) {
			
			idField.setText("존재하지 않는 아이디입니다!!");
			
		}else {
			JOptionPane.showMessageDialog(this, "데이터베이스 오류");
		}
			
		
		
		
	}

	public static void main(String[] args) {
		new LoginView();
	}

}