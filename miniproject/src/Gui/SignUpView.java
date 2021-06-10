package Gui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpView extends JFrame{
	JLabel signUp, name, id, pw;
	JTextField nameField, idField, pwField;
	
	SignUpView() {
		super("회원가입");
		setSize(new Dimension(800, 800));
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800,800));
		
		signUp = new JLabel("회원가입");
		signUp.setFont(new Font("Magneto 굵게",Font.BOLD , 30));
		name = new JLabel(" 이름  ");
		name.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		id = new JLabel(" 아이디  ");
		id.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		pw = new JLabel(" 패스워드 ");
		pw.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		nameField = new JTextField();
		idField = new JTextField();
		pwField = new JTextField();
		
		
		signUp.setBounds(250, 100, 300, 100 );
		name.setBounds(150, 200, 70, 40);
		id.setBounds(150, 250, 70, 40);
		pw.setBounds(150, 300, 70, 40);
		nameField.setBounds(220, 200, 300, 40);
		idField.setBounds(220, 250, 300, 40);
		pwField.setBounds(220, 300, 300, 40);
		
		panel.setLayout(null);
		panel.add(signUp);
		panel.add(name);
		panel.add(id);
		panel.add(pw);
		panel.add(nameField);
		panel.add(idField);
		panel.add(pwField);
		
				
		add(panel);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SignUpView();
	}

}