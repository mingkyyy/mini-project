package Gui;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView extends JFrame {
	JLabel login, id, pw;
	JTextField idField, pwField;
	JButton button, backbutton;
	
	LoginView(){
		super("회원가입");
		setSize(new Dimension(800, 800));
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800,800));
		
		
		button=new JButton("확인");
	    button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainView();
				setVisible(false);
				
			}
		});
	    
	    backbutton=new JButton("back");
		 backbutton.setBounds(0,0,60,30);
		 backbutton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new MainView();
						setVisible(false);
						
					}
				});
		
		login = new JLabel("로그인");
		login.setFont(new Font("Magneto 굵게",Font.BOLD , 60));
		id = new JLabel(" 아이디  ");
		id.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		pw = new JLabel(" 패스워드 ");
		pw.setFont(new Font("Magneto 굵게",Font.BOLD , 13));
		
		idField = new JTextField();
		pwField = new JTextField();
		
		login.setBounds(250, 100, 300, 100 );
		id.setBounds(150, 250, 70, 40);
		pw.setBounds(150, 300, 70, 40);
		idField.setBounds(220, 250, 300, 40);
		pwField.setBounds(220, 300, 300, 40);
		button.setBounds(220,350,300,50);
		
		panel.setLayout(null);
		panel.add(login);
		panel.add(id);
		panel.add(pw);
		panel.add(idField);
		panel.add(pwField);
		panel.add(button);
		panel.add(backbutton);
		
		
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LoginView();
	}

}